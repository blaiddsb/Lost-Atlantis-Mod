package vespi.lostcity.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import vespi.lostcity.blocks.ModBlocks;

public class ModSetup {
	public ItemGroup itemGroup = new ItemGroup("lostcity") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModBlocks.ARTIFACTBLOCK);
		}
	};
	
	public void init() {
		
	}
}
