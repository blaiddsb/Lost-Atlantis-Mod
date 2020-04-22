package vespi.lostcity.blocks;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("lostcity:artifactblock")
    public static ArtifactBlock ARTIFACTBLOCK;

    @ObjectHolder("lostcity:crystalliser")
    public static Crystalliser CRYSTALLISER;

    @ObjectHolder("lostcity:crystalliser")
    public static TileEntityType<CrystalliserTile>  CRYSTALLISER_TILE;

    @ObjectHolder("lostcity:lostglass")
    public static LostGlass LOSTGLASS;

    @ObjectHolder("lostcity:ostrumore")
    public static OstrumOre OSTRUMORE;

    @ObjectHolder("lostcity:crystalliser")

    public static ContainerType<CrystalliserContainer> CRYSTALLISER_CONTAINER;



}
