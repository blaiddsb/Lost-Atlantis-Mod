package vespi.lostcity.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OstrumOre  extends Block {
    public OstrumOre() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(4)
                .harvestLevel(4)
                .harvestTool(ToolType.PICKAXE));
            setRegistryName("ostrumore");


    }


}
