package vespi.lostcity.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import vespi.lostcity.setup.ModSetup;

public class AlchemicalDust extends Item {


    public AlchemicalDust() {
        super(new Properties()
                .maxStackSize(12)
                .group(ModSetup.itemGroup));
        setRegistryName("alchemicaldust");

    }
}
