package mtr.data.remote.zones;

import mtr.data.remote.zones.utils.BoundingBox;
import mtr.data.remote.zones.utils.Location;
import net.minecraft.world.entity.player.Player;

public class Zone extends BoundingBox {
    public final Location min;
    public final Location max;
    public final String name;
    public String areaId;

    public Zone(String name, Location first, Location second) {
        super(first, second);

        this.min = new Location(0, 0, 0);
        this.max = new Location(0, 0, 0);
        this.name = name;

        if (this.minX >= this.maxX) {
            this.max.setX(this.minX);
            this.min.setX(this.maxX);
        } else {
            this.max.setX(this.maxX);
            this.min.setX(this.minX);
        }

        if (this.minY >= this.maxY) {
            this.max.setY(this.minY);
            this.min.setY(this.maxY);
        } else {
            this.max.setY(this.maxY);
            this.min.setY(this.minY);
        }

        if (this.minZ >= this.maxZ) {
            this.max.setZ(this.minZ);
            this.min.setZ(this.maxZ);
        } else {
            this.max.setZ(this.maxZ);
            this.min.setZ(this.minZ);
        }
    }

    public boolean isInArea(Location loc)
    {
        if (loc == null)
            return false;
        else if (loc.getX() > this.max.getX() || this.min.getX() > loc.getX())
            return false;
        else if (loc.getY() > this.max.getY() || this.min.getY() > loc.getY())
            return false;
        else return !(loc.getZ() > this.max.getZ()) && !(this.min.getZ() > loc.getZ());
    }

    public boolean isPlayerInArea(Player player) {
        Location loc = Location.Vec2Loc(player);

        if (loc.getX() > this.max.getX() || this.min.getX() > loc.getX())
            return false;
        else if (loc.getY() > this.max.getY() || this.min.getY() > loc.getY())
            return false;
        else return !(loc.getZ() > this.max.getZ()) && !(this.min.getZ() > loc.getZ());
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
