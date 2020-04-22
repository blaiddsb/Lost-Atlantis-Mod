package vespi.lostcity.items;

import net.minecraft.item.Item;
import vespi.lostcity.LostCity;

public class GlyphItem extends Item {
	public String GLYPH_ID;
	
	public GlyphItem() {
		super(new Item.Properties()
				.maxStackSize(16)
				.group(LostCity.setup.itemGroup));
	}
}
