package vespi.lostcity.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootTableManager;
import vespi.lostcity.blocks.ModBlocks;
import vespi.lostcity.items.ModItems;
import vespi.lostcity.world.OreGen;

public class ModSetup {
    private static  OreGen ORE_GEN = new OreGen();

    public static  ItemGroup itemGroup = new ItemGroup("lostcity") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.LOSTGEM);
        }
    };

    public void init(){
        ORE_GEN.setupOreGen();

    }
}
