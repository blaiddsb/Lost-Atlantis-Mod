package vespi.lostcity.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import vespi.lostcity.setup.ModSetup;

public class ElderSoul extends Item {

    public ElderSoul(){
    super(new Properties()
            .maxStackSize(16)
            .group(ModSetup.itemGroup));
    setRegistryName("eldersoul");

    }
}
