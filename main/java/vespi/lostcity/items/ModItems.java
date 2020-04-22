package vespi.lostcity.items;

import net.minecraftforge.registries.ObjectHolder;
import vespi.lostcity.items.glyphs.AttackGlyphItem;
import vespi.lostcity.items.glyphs.HealthGlyphItem;
import vespi.lostcity.items.glyphs.SpeedGlyphItem;

public class ModItems {
	@ObjectHolder("lostcity:heartgem")
	public static HeartGemItem HEARTGEM;
	
	@ObjectHolder("lostcity:golemtotem")
	public static GolemTotemItem GOLEMTOTEM;
	
	
	public static GlyphItem GLYPHITEM;
	
	@ObjectHolder("lostcity:speedglyph")
	public static SpeedGlyphItem HEALTHGLYPH;
	
	@ObjectHolder("lostcity:healthglyph")
	public static HealthGlyphItem SPEEDGLYPH;
	
	@ObjectHolder("lostcity:attackglyph")
	public static AttackGlyphItem ATTACKGLYPH;
}
