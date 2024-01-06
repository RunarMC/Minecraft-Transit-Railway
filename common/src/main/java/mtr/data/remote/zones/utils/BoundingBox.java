package mtr.data.remote.zones.utils;


import com.mojang.math.Vector3d;
import com.mojang.math.Vector3f;
import mtr.data.remote.zones.Zone;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

/**
 * A mutable block-based axis-aligned bounding box.
 *
 * <p>This is a rectangular box defined by minimum and maximum corners
 * that can be used to represent a collection of blocks.
 *
 * <p>While similar to Bukkit's {@link org.bukkit.util.BoundingBox BoundingBox},
 * this implementation is much more focused on performance and does not use as
 * many input sanitization operations.
 */
@SuppressWarnings("ALL")
public class BoundingBox implements Cloneable {

    public static @NotNull BoundingBox ofArea(@NotNull Zone claim) {
        return new BoundingBox(claim);
    }

    /**
     * -- GETTER --
     *  Gets the minimum X coordinate of the bounding box.
     *
     * @return the minimum X value
     */
    public float minX;
    /**
     * -- GETTER --
     *  Gets the minimum Y coordinate of the bounding box.
     *
     * @return the minimum Y value
     */
    public float minY;
    /**
     * -- GETTER --
     *  Gets the minimum Y coordinate of the bounding box.
     *
     * @return the minimum Y value
     */
    public float minZ;
    /**
     * -- GETTER --
     *  Gets the maximum X coordinate of the bounding box.
     *
     * @return the maximum X value
     */
    public float maxX;
    /**
     * -- GETTER --
     *  Gets the maximum Y coordinate of the bounding box.
     *
     * @return the maximum Y value
     */
    public float maxY;
    /**
     * -- GETTER --
     *  Gets the maximum Z coordinate of the bounding box.
     *
     * @return the maximum Z value
     */
    public float maxZ;

    /**
     * Construct a new bounding box with the given corners.
     *
     * @param x1 the X coordinate of the first corner
     * @param y1 the Y coordinate of the first corner
     * @param z1 the Z coordinate of the first corner
     * @param x2 the X coordinate of the second corner
     * @param y2 the Y coordinate of the second corner
     * @param z2 the Z coordinate of the second corner
     * @param verify whether or not to verify that the provided corners are in fact the minimum corners
     */
    protected BoundingBox(float x1, float y1, float z1, float x2, float y2, float z2, boolean verify) {
        if (verify)
        {
            verify(x1, y1, z1, x2, y2, z2);
        }
        else
        {
            this.minX = x1;
            this.maxX = x2;
            this.minY = y1;
            this.maxY = y2;
            this.minZ = z1;
            this.maxZ = z2;
        }
    }

    /**
     * Construct a new bounding box with the given corners.
     *
     * @param x1 the X coordinate of the first corner
     * @param y1 the Y coordinate of the first corner
     * @param z1 the Z coordinate of the first corner
     * @param x2 the X coordinate of the second corner
     * @param y2 the Y coordinate of the second corner
     * @param z2 the Z coordinate of the second corner
     */
    public BoundingBox(int x1, int y1, int z1, int x2, int y2, int z2)
    {
        this(x1, y1, z1, x2, y2, z2, true);
    }

    /**
     * Construct a new bounding box with the given corners.
     *
     * @param pos1 the position of the first corner
     * @param pos2 the position of the second corner
     * @param verify whether or not to verify that the provided corners are in fact the minimum corners
     */
    protected BoundingBox(@NotNull Location pos1, @NotNull Location pos2, boolean verify)
    {
        this(pos1.getX(), pos1.getY(), pos1.getZ(),
                pos2.getX(), pos2.getY(), pos2.getZ(),
                verify);
    }

    /**
     * Construct a new bounding box with the given corners.
     *
     * @param pos1 the position of the first corner
     * @param pos2 the position of the second corner
     */
    public BoundingBox(@NotNull Location pos1, @NotNull Location pos2)
    {
        this(pos1, pos2, true);
    }
    /**
     * Construct a new bounding box with the given corners.
     *
     * @param pos1 the position of the first corner
     * @param pos2 the position of the second corner
     */
    public BoundingBox(@NotNull Vector3f pos1, @NotNull Vector3f pos2)
    {
        this(pos1.x(), pos1.y(), pos1.z(),
                pos2.x(), pos2.y(), pos2.z(), true);
    }

    /**
     * Construct a new bounding box representing the given claim.
     *
     * @param claim the claim
     */
    public BoundingBox(@NotNull Zone claim)
    {
        this(claim.min, claim.max, false);
        this.maxY = 256;
    }

    /**
     * Construct a new bounding box representing the given block.
     *
     * @param block the block
     */
    public BoundingBox(@NotNull BlockPos block)
    {
        this(block.getX(), block.getY(), block.getZ(), block.getX(), block.getY(), block.getZ(), false);
    }

    /**
     * Construct a new bounding box representing the given Bukkit {@link org.bukkit.util.BoundingBox BoundingBox}.
     *
     * @param boundingBox the Bukkit bounding box
     */
    public BoundingBox(@NotNull BoundingBox boundingBox)
    {
        this((int) boundingBox.minX,
                (int) boundingBox.minY,
                (int) boundingBox.minZ,
                // Since Bukkit bounding boxes are inclusive of upper bounds, subtract a small number.
                // This ensures that a full block Bukkit bounding boxes yield correct equivalents.
                // Uses Math.max to account for degenerate boxes.
                (int) Math.max(boundingBox.minX, boundingBox.maxX - .0001),
                (int) Math.max(boundingBox.minY, boundingBox.maxY - .0001),
                (int) Math.max(boundingBox.minZ, boundingBox.maxZ - .0001),
                false);
    }

    /**
     * Sets bounds of this bounding box to the specified values.
     * Ensures that the minimum and maximum corners are set from the correct respective values.
     *
     * @param x1 the first X value
     * @param y1 the first Y value
     * @param z1 the first Z value
     * @param x2 the second X value
     * @param y2 the second Y value
     * @param z2 the second Z value
     */
    private void verify(float x1, float y1, float z1, float x2, float y2, float z2) {
        if (x1 < x2)
        {
            this.minX = x1;
            this.maxX = x2;
        }
        else
        {
            this.minX = x2;
            this.maxX = x1;
        }
        if (y1 < y2)
        {
            this.minY = y1;
            this.maxY = y2;
        }
        else
        {
            this.minY = y2;
            this.maxY = y1;
        }
        if (z1 < z2)
        {
            this.minZ = z1;
            this.maxZ = z2;
        }
        else
        {
            this.minZ = z2;
            this.maxZ = z1;
        }
    }

    /**
     * Gets the minimum corner's coordinates as a vector.
     *
     * @return the minimum corner as a vector
     */
    public @NotNull Vector3f getMinToVec()
    {
        return new Vector3f(this.minX, this.minY, this.minZ);
    }

    /**
     * Gets the maximum corner's coordinates as a vector.
     *
     * @return the maximum corner as a vector
     */
    public @NotNull Vector3f getMaxToVec()
    {
        return new Vector3f(this.maxX, this.maxY, this.maxZ);
    }

    /**
     * Gets the length of the bounding box on the X axis.
     *
     * @return the length on the X axis
     */
    public float getLength()
    {
        return (this.maxX - this.minX) + 1;
    }

    /**
     * Gets the length of the bounding box on the Y axis.
     *
     * @return the length on the Y axis
     */
    public float getHeight()
    {
        return (this.maxY - this.minY) + 1;
    }

    /**
     * Gets the length of the bounding box on the Z axis.
     *
     * @return the length on the Z axis
     */
    public float getWidth()
    {
        return (this.maxZ - this.minZ) + 1;
    }

    /**
     * Gets the center of the bounding box on the X axis.
     *
     * <p>Note that center coordinates are world coordinates
     * while all of the other coordinates are block coordinates.
     *
     * @return the center of the X axis
     */
    public double getCenterX()
    {
        return this.minX + (this.getLength() / 2D);
    }

    /**
     * Gets the center of the bounding box on the Y axis.
     *
     * <p>Note that center coordinates are world coordinates
     * while all of the other coordinates are block coordinates.
     *
     * @return the center of the X axis
     */
    public double getCenterY()
    {
        return this.minY + (this.getHeight() / 2D);
    }

    /**
     * Gets the center of the bounding box on the Z axis.
     *
     * <p>Note that center coordinates are world coordinates
     * while all of the other coordinates are block coordinates.
     *
     * @return the center of the X axis
     */
    public double getCenterZ()
    {
        return this.minZ + (this.getWidth() / 2D);
    }

    /**
     * Gets the center of the bounding box as a vector.
     *
     * <p>Note that center coordinates are world coordinates
     * while all of the other coordinates are block coordinates.
     *
     * @return the center of the X axis
     */
    public @NotNull Vector3d getCenter()
    {
        return new Vector3d(this.getCenterX(), this.getCenterY(), this.getCenterZ());
    }

    /**
     * Gets the area of the base of the bounding box.
     *
     * <p>The base is the lowest plane defined by the X and Z axis.
     *
     * @return the area of the base of the bounding box
     */
    public float getArea()
    {
        return this.getLength() * this.getWidth();
    }

    /**
     * Gets the volume of the bounding box.
     *
     * @return the volume of the bounding box
     */
    public float getVolume()
    {
        return this.getArea() * getHeight();
    }

    /**
     * Copies the dimensions and location of another bounding box.
     *
     * @param other the bounding box to copy
     */
    public void copy(@NotNull BoundingBox other)
    {
        this.minX = other.minX;
        this.minY = other.minY;
        this.minZ = other.minZ;
        this.maxX = other.maxX;
        this.maxY = other.maxY;
        this.maxZ = other.maxZ;
    }

    @Override
    public boolean equals(@Nullable Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoundingBox other = (BoundingBox) o;
        return this.minX == other.minX
                && this.minY == other.minY
                && this.minZ == other.minZ
                && this.maxX == other.maxX
                && this.maxY == other.maxY
                && this.maxZ == other.maxZ;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    @Override
    public @NotNull String toString()
    {
        return "BoundingBox{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", minZ=" + minZ +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                ", maxZ=" + maxZ +
                '}';
    }

    @Override
    public @NotNull BoundingBox clone()
    {
        try
        {
            return (BoundingBox) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            throw new Error(e);
        }
    }

}