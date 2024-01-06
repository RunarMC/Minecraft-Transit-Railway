package mtr.data.remote.zones;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.runarmc.handler.RequestCallback;
import com.runarmc.results.ErrorResult;
import com.runarmc.results.RequestResult;
import mtr.MTR;
import mtr.data.remote.zones.database.FetchZones;
import mtr.data.remote.zones.utils.Location;
import mtr.data.remote.zones.utils.QueuedObject;
import net.minecraft.world.entity.player.Player;
import okhttp3.Response;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class AreaManager {

    private final List<Zone> cache = new CopyOnWriteArrayList<>();

    public AreaManager()  {
        if (MTR.isRemoteServer) {
            try {
                MTR.remote.execute(MTR.remoteWrapper, new FetchZones(), new RequestCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                    }

                    @Override
                    public void onSuccess(RequestResult requestResult, Response response) {
                        Type listType = new TypeToken<ArrayList<FetchZones>>(){}.getType();
                        ArrayList<FetchZones> result = new Gson().fromJson(requestResult.getData(), listType);

                        result.forEach(context -> {
                            Zone zone = new Zone(context.getName(),
                                new Location(
                                    context.getMin().getX(),
                                    context.getMin().getY(),
                                    context.getMin().getZ()
                            ),  new Location(
                                    context.getMax().getX(),
                                    context.getMax().getY(),
                                    context.getMax().getZ()
                            ));
                            zone.setAreaId(context.getId());
                            cache.add(zone);
                            System.out.println("[MTR] Zone " + zone.name + " loaded from remote " + MTR.remoteConfig.getHost());
                        });
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("[MTR] Ignoring zone loading because there is no remote.");
        }
    }

    public QueuedObject<Boolean, Zone> getPlayerCurrentZone(Player player) {
        AtomicReference<QueuedObject<Boolean, Zone>> result = new AtomicReference<>(QueuedObject.of(false, null));

        this.cache.forEach(context -> {
            if (context.isPlayerInArea(player)) {
                result.set(QueuedObject.of(true, context));
            }
        });

        return result.get();
    }
}
