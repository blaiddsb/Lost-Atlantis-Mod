package vespi.lostcity.dimensions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.registries.ObjectHolder;
import vespi.lostcity.LostCity;

public class ModDimensions {
    public static final ResourceLocation DIMENSION_ID = new ResourceLocation(LostCity.MODID,"dimension");

    @ObjectHolder("lostcity:dimension")
    public static ModDimension DIMENSION;
    public static DimensionType DIMENSION_TYPE;
}
