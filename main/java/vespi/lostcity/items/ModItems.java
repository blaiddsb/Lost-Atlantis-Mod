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

    @ObjectHolder("lostcity:alchemicaldust")
    public static AlchemicalDust ALCHEMICALDUST;

    @ObjectHolder("lostcity:lostgem")
    public static LostGem LOSTGEM;

    @ObjectHolder("lostcity:eldersoul")
    public static ElderSoul ELDERSOUL;

    @ObjectHolder("lostcity:relichammer")
    public static RelicHammer RELICHAMMER;

    @ObjectHolder("lostcity:artifactshard")
    public static  ArtifactShard ARTIFACTSHARD;

    @ObjectHolder("lostcity:relicpickaxe")
    public static RelicPickaxe RELICPICKAXE;
    @ObjectHolder("lostcity:relicaxe")
    public static RelicAxe RELICAXE;
    @ObjectHolder("lostcity:relicshovel")
    public static RelicShovel RELICSHOVEL;
}
