package vespi.lostcity.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;
import vespi.lostcity.tiles.GolemMaskTile;

public class ModBlocks {
    @ObjectHolder("lostcity:artifactblock")
    public static ArtifactBlock ARTIFACTBLOCK;
    
    @ObjectHolder("lostcity:golemmask")
    public static GolemMask GOLEMMASK;
    
    @ObjectHolder("lostcity:golemmask")
    public static TileEntityType<GolemMaskTile> GOLEMMASK_TILE;
}
