package mtr.data.remote;

import com.google.gson.Gson;
import com.runarmc.handler.RequestCallback;
import com.runarmc.handler.RequestHandler;
import com.runarmc.results.ErrorResult;
import com.runarmc.results.RequestResult;
import mtr.MTR;
import net.minecraft.world.entity.player.Player;
import okhttp3.Response;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Operations {

    private final Map<UUID, Integer> BALANCE_CACHE = new LinkedHashMap<>();
    private final List<Update> UPDATES_CACHE = new CopyOnWriteArrayList<>();

    private final RequestHandler remote = new RequestHandler();

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(16);

    public Operations() {
        this.executor.scheduleAtFixedRate(this::executeUpdate, 10, 30, TimeUnit.SECONDS);
    }

    public boolean updateBalance(Player player,
                                        UpdatePlayerBalance.Operation operation, int amount) {
        Update playerUpdate = new Update();
        playerUpdate.setPlayer(player.getUUID());
        playerUpdate.setOperation(operation);
        playerUpdate.setAmount(amount);

        return this.UPDATES_CACHE.add(playerUpdate);
    }

    public void executeUpdate() {
        if (this.UPDATES_CACHE.isEmpty()) {
            System.out.println("[MTR] No balance to update.");
            return;
        }
        this.UPDATES_CACHE.forEach(context -> {
            try {
                this.remote.execute(MTR.remoteWrapper, new UpdatePlayerBalance(context.getPlayer(), context.getOperations(), context.getAmount()), new RequestCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        throw new IllegalStateException("MTR Cannot update " + context.getPlayer() + " balance ( Operation : " + context.getOperations() + ", Amount : " + context.getAmount() + " )");
                    }

                    @Override
                    public void onSuccess(RequestResult requestResult, Response response) {
                        UPDATES_CACHE.remove(context);
                        System.out.println("[MTR] Player " + context.getPlayer() + " balance updated!");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public int getPlayerBalance(Player player) {
        try {
            this.remote.execute(MTR.remoteWrapper, new FetchPlayerBalance(), new RequestCallback() {
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

        return  (BALANCE_CACHE.get(player.getUUID()) - this.getUpcomingMinus(player)) + this.getUpcomingIncome(player);
    }

    private int getUpcomingMinus(Player player) {
        AtomicInteger result = new AtomicInteger(0);

        this.UPDATES_CACHE.forEach(context -> {
            if (context.getOperations().equals(UpdatePlayerBalance.Operation.DEBIT)) {
                if (context.getPlayer().equals(player.getUUID())) {
                    result.set(result.get() + context.getAmount());
                }
            }
        });

        return result.get();
    }

    private int getUpcomingIncome(Player player) {
        AtomicInteger result = new AtomicInteger(0);

        this.UPDATES_CACHE.forEach(context -> {
            if (context.getOperations().equals(UpdatePlayerBalance.Operation.CREDIT)) {
                if (context.getPlayer().equals(player.getUUID())) {
                    result.set(result.get() + context.getAmount());
                }
            }
        });

        return result.get();
    }

    private static class Update {
        private UUID player;
        private UpdatePlayerBalance.Operation operations;
        private int amount;

        public UpdatePlayerBalance.Operation getOperations() {
            return operations;
        }

        public UUID getPlayer() {
            return player;
        }

        public int getAmount() {
            return amount;
        }

        public void setPlayer(UUID player) {
            this.player = player;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public void setOperation(UpdatePlayerBalance.Operation operations) {
            this.operations = operations;
        }
    }
}
