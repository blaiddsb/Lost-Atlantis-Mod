package vespi.lostcity.items;

import net.minecraft.item.PickaxeItem;
import vespi.lostcity.setup.ModSetup;

public class RelicPickaxe extends PickaxeItem {



   public RelicPickaxe(){
     super(ModItemTiers.ARTIFACT,5,-2.0f, new Properties().group(ModSetup.itemGroup));
     setRegistryName("relicpickaxe");

    }
}
