package mtr.data.remote.zones.utils;

import net.minecraft.world.entity.player.Player;

public class Location {
    private float x;
    private float y;
    private float z;

    public Location(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(double x, double y, double z) {
        this((float) x, (float) y, (float) z);
    }

    public float getZ() {
        return z;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public static Location Vec2Loc(Player player) {
        return new Location(player.position().x(), player.position().y(), player.position().z());
    }
}
