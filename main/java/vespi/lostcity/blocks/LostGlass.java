package vespi.lostcity.blocks;

import net.minecraft.block.Block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class LostGlass  extends Block {

    public LostGlass() {
        super(Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(1.0f).lightValue(14));
        setRegistryName("lostglass");

    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}


