package mtr.data.remote.zones.database;
import com.runarmc.annotations.Route;
import com.runarmc.models.AbstractModel;

@Route(
        method = "GET",
        route = "/api/area/fetch",
        result = FetchZones.class
)
public class FetchZones extends AbstractModel {

    private String _id;
    private String name;
    private Location min;
    private Location max;

    public static class Location {
        private int x;
        private int y;
        private int z;

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        public int getX() {
            return x;
        }
    }

    public String getName() {
        return name;
    }

    public Location getMax() {
        return max;
    }

    public Location getMin() {
        return min;
    }

    public String getId() {
        return _id;
    }
}