package vespi.lostcity.dimension;

import net.minecraft.world.dimension.Dimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.registries.ObjectHolder;
import vespi.lostcity.LostCity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceLocation DIMENSION_ID = new ResourceLocation(LostCity.MODID, "tutdim");

    @ObjectHolder("lostcity:tutdim")
    public static ModDimension DIMENSION;

    public static DimensionType DIMENSION_TYPE;
}
