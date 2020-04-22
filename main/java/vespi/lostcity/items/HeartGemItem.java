package vespi.lostcity.items;

import net.minecraft.item.Item;
import vespi.lostcity.LostCity;

public class HeartGemItem extends Item {
	public HeartGemItem() {
		super(new Item.Properties()
				.maxStackSize(16)
				.group(LostCity.setup.itemGroup));
		
		setRegistryName("heartgem");
	}
}
