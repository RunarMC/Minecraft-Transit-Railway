package mtr.data.remote.balance;

import com.google.gson.Gson;
import com.runarmc.handler.RequestCallback;
import com.runarmc.handler.RequestHandler;
import com.runarmc.results.ErrorResult;
import com.runarmc.results.RequestResult;
import mtr.MTR;
import mtr.data.remote.balance.database.FetchPlayerBalance;
import mtr.data.remote.balance.database.UpdatePlayerBalance;
import mtr.data.remote.zones.AreaManager;
import mtr.data.remote.zones.Zone;
import mtr.data.remote.zones.utils.QueuedObject;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.Score;
import okhttp3.Response;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.injection.At;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static mtr.data.TicketSystem.BALANCE_OBJECTIVE;
import static mtr.data.TicketSystem.getPlayerScore;

public class Operations {

    private final Map<UUID, Integer> BALANCE_CACHE = new LinkedHashMap<>();
    private final List<Update> UPDATES_CACHE = new CopyOnWriteArrayList<>();

    private AreaManager areaManager;

    public Operations(){
        if (MTR.isRemoteServer) {
            this.areaManager = new AreaManager();
            MTR.executor.scheduleAtFixedRate(this::executeUpdate, 10, 30, TimeUnit.SECONDS);
        }
    }

    public boolean updateBalance(Player player,
                                 UpdatePlayerBalance.Operation operation, int amount) {

        if (MTR.isRemoteServer) {
            Update playerUpdate = new Update();
            playerUpdate.setPlayer(player);
            playerUpdate.setOperation(operation);
            playerUpdate.setAmount(amount);

            return this.UPDATES_CACHE.add(playerUpdate);
        } else {
            Score FALLBACK_BALANCE = getPlayerScore(player.level, player, BALANCE_OBJECTIVE);

            if (operation.equals(UpdatePlayerBalance.Operation.CREDIT)) {
                FALLBACK_BALANCE.add(amount);
            } else if (operation.equals(UpdatePlayerBalance.Operation.DEBIT)) {
                FALLBACK_BALANCE.add(-amount);
            }
        }

        return true;
    }

    public void executeUpdate() {
        this.UPDATES_CACHE.forEach(context -> {
            try {

                QueuedObject<Boolean, Zone> result = this.areaManager.getPlayerCurrentZone(context.getPlayer());
                UpdatePlayerBalance update = new UpdatePlayerBalance(context.getPlayer().getUUID(), context.getOperations(), context.getAmount());

                // To split the fare with the kingdom owner and the server economy
                // The calculation is based on the zone / by 2
                // Example: the player travel to the kingdom A to B and the base fare is 8
                // A would get 2 and B 2
                // As the server keep 4 as fee.

                if (result.getFirst()) {
                    if (result.getSecond().name.startsWith("kingdom_")
                            && result.getSecond().name.endsWith("_station")) {
                        update.setKingdomId(result.getSecond().getAreaId());
                    } else {
                        update.setKingdomId("none");
                    }
                } else {
                    update.setKingdomId("none");
                }

                MTR.remote.execute(MTR.remoteWrapper, update, new RequestCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        if (errorResult.getStatusCode() == 429) {
                            context.getPlayer().displayClientMessage(new TextComponent("[MTR] Your account is being rate limited. Please do not use the gate."), false);
                            return;
                        }
                        context.getPlayer().displayClientMessage(new TextComponent("MTR Cannot update " + context.getPlayer().getName() + " balance ( Operation : " + context.getOperations() + ", Amount : " + context.getAmount() + " )"), true);
                    }

                    @Override
                    public void onSuccess(RequestResult requestResult, Response response) {
                        UPDATES_CACHE.remove(context);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public synchronized int getFallbackBalance(Player player) {
        return getPlayerScore(player.level, player, BALANCE_OBJECTIVE).getScore();
    }

    public synchronized int getPlayerBalance(Player player) {
        if (MTR.isRemoteServer) {
            try {
                MTR.remote.execute(MTR.remoteWrapper, new FetchPlayerBalance(), new RequestCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        if (!BALANCE_CACHE.containsKey(player.getUUID())) {
                            BALANCE_CACHE.put(player.getUUID(), 0);
                        }
                    }

                    @Override
                    public void onSuccess(RequestResult requestResult, Response response) {
                        FetchPlayerBalance result = new Gson().fromJson(requestResult.getData(), FetchPlayerBalance.class);

                        if (BALANCE_CACHE.containsKey(player.getUUID())) {
                            int cached = BALANCE_CACHE.get(player.getUUID());
                            if (cached != result.getBalance()) {
                                BALANCE_CACHE.remove(player.getUUID());
                                BALANCE_CACHE.put(player.getUUID(), result.getBalance());
                            }
                        } else {
                            BALANCE_CACHE.put(player.getUUID(), result.getBalance());
                        }
                    }
                }, Collections.singletonMap("uuid", player.getUUID().toString()));
            } catch (Exception e) {
                return BALANCE_CACHE.getOrDefault(player.getUUID(), 0);
            }

            AtomicInteger debit = new AtomicInteger(0);
            AtomicInteger credit = new AtomicInteger(0);
            AtomicInteger balance = new AtomicInteger(BALANCE_CACHE.get(player.getUUID()));

            this.predicate(player, new Callback() {
                @Override
                public void debit(int amount) {
                    if (debit.get() == 0) {
                        debit.set(amount);
                    } else {
                        debit.set(debit.get() + amount);
                    }
                }

                @Override
                public void credit(int amount) {
                    if (credit.get() == 0) {
                        credit.set(amount);
                    } else {
                        credit.set(credit.get() + amount);
                    }
                }
            });

            balance.set(balance.get() - debit.get());
            balance.set(balance.get() + credit.get());

            if (player.getName().equals(new TextComponent("Vakea"))) {
                System.out.println("---------- DEBUG ----------");
                System.out.println(" -> Normal : " + BALANCE_CACHE.get(player.getUUID()));
                System.out.println(" -> Incoming debit : " + debit.get());
                System.out.println(" -> Incoming credit : " + credit.get());
                System.out.println("   -> Predicated : " + balance.get());
                System.out.println("   -> Player : " + player.getName().toString());
                System.out.println("---------- DEBUG ----------");
            }

            if (balance.get() < 0) {
                player.displayClientMessage(new TextComponent("Your balance is in negative, please refill your balance.").withStyle(ChatFormatting.RED), false);
            }

            return balance.get();
        } else {
            return this.getFallbackBalance(player);
        }
    }

    private synchronized void predicate(Player player, Callback callback) {
        for (Update predicate : this.UPDATES_CACHE) {
            if (predicate.getPlayer().equals(player)) {
                if (predicate.getOperations().equals(UpdatePlayerBalance.Operation.DEBIT)) {
                    callback.debit(predicate.getAmount());
                } else {
                    callback.credit(predicate.getAmount());
                }
            }
        }
    }

    private static class Update {
        private Player player;
        private UpdatePlayerBalance.Operation operations;
        private int amount;

        public UpdatePlayerBalance.Operation getOperations() {
            return operations;
        }

        public Player getPlayer() {
            return player;
        }

        public int getAmount() {
            return amount;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setOperation(UpdatePlayerBalance.Operation operations) {
            this.operations = operations;
        }
    }

    private interface Callback {
        void debit(int amount);
        void credit(int amount);
    }
}
