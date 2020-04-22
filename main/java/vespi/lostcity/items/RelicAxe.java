package vespi.lostcity.items;

import net.minecraft.item.AxeItem;
import vespi.lostcity.setup.ModSetup;

public class RelicAxe extends AxeItem {
    public RelicAxe() {
        super(ModItemTiers.ARTIFACT, 7, 1.0f, new Properties().group(ModSetup.itemGroup));

        setRegistryName("relicaxe");
    }
}
