package vespi.lostcity.items;

import net.minecraft.item.ShovelItem;
import vespi.lostcity.setup.ModSetup;

public class RelicShovel extends ShovelItem {
    public RelicShovel() {
        super(ModItemTiers.ARTIFACT,2,-2.0f,new Properties().group(ModSetup.itemGroup));
        setRegistryName("relicshovel");
    }
}
