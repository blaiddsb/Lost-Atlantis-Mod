package vespi.lostcity.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ArtifactBlock extends Block{
    public ArtifactBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(12)
        );
        setRegistryName("artifactblock");
    }
}
