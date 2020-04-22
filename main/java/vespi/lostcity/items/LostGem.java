package vespi.lostcity.items;

import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import vespi.lostcity.setup.ModSetup;

public class LostGem extends Item {

    public LostGem(){
        super(new Properties()
                .maxStackSize(8)
                .group(ModSetup.itemGroup)
                .rarity(Rarity.RARE));

        setRegistryName("lostgem");

        }
    }

