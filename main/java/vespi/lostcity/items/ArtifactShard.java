package vespi.lostcity.items;

import net.minecraft.item.Item;
import vespi.lostcity.setup.ModSetup;

public class ArtifactShard extends Item {

    public ArtifactShard() {
        super(new Properties().group(ModSetup.itemGroup).maxStackSize(64));
        setRegistryName("artifactshard");
    }

}
