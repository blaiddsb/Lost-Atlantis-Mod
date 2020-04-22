package vespi.lostcity.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import vespi.lostcity.setup.ModSetup;

public class RelicHammer extends PickaxeItem {

    public RelicHammer() {
        super(new IItemTier() {
            @Override
            public int getMaxUses() {
                return 8700;
            }

            @Override
            public float getEfficiency() {
                return 16;
            }

            @Override
            public float getAttackDamage() {
                return 0;
            }

            @Override
            public int getHarvestLevel() {
                return 4;
            }

            @Override
            public int getEnchantability() {
                return 1;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return null;
            }
        }, 8, -2, new Properties().group(ModSetup.itemGroup).maxDamage(16000).addToolType(ToolType.AXE,4).addToolType(ToolType.SHOVEL,4));
        setRegistryName("relichammer");
    }
}
