package vespi.lostcity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vespi.lostcity.blocks.ArtifactBlock;
import vespi.lostcity.blocks.GolemMask;
import vespi.lostcity.blocks.ModBlocks;
import vespi.lostcity.entities.LesserGolemEntity;
import vespi.lostcity.entities.LostSharkEntity;
import vespi.lostcity.items.GolemTotemItem;
import vespi.lostcity.items.HeartGemItem;
import vespi.lostcity.items.glyphs.AttackGlyphItem;
import vespi.lostcity.items.glyphs.HealthGlyphItem;
import vespi.lostcity.items.glyphs.SpeedGlyphItem;
import vespi.lostcity.setup.ClientProxy;
import vespi.lostcity.setup.IProxy;
import vespi.lostcity.setup.ModSetup;
import vespi.lostcity.setup.ServerProxy;
import vespi.lostcity.tiles.GolemMaskTile;


@Mod("lostcity")
public class LostCity {
    @SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger();
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static ModSetup setup = new ModSetup();
    
    // Entity builders 
    public static EntityType<?> lesserGolemBuilder;
    public static EntityType<?> lostSharkBuilder;

    public LostCity() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        // Create Entity Builders
        lostSharkBuilder = EntityType.Builder.create(LostSharkEntity::new, EntityClassification.WATER_CREATURE)
			.size(1,2)
			.setShouldReceiveVelocityUpdates(false)
			.build("lostsharkentity").setRegistryName("lostcity", "lostshark");
        
        lesserGolemBuilder = EntityType.Builder.create(LesserGolemEntity::new, EntityClassification.CREATURE)
        		.size(1,1)
        		.setShouldReceiveVelocityUpdates(false)
        		.build("lessergolementity").setRegistryName("lostcity", "lessergolem");
    }

    private void setup(final FMLCommonSetupEvent event) {
    	setup.init();
    	proxy.init();
    }
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new ArtifactBlock());
            
            event.getRegistry().register(new GolemMask());
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {        	
        	Item.Properties properties = new Item.Properties()
        			.group(setup.itemGroup);
        	
        	// register blocks
            event.getRegistry().register(new BlockItem(ModBlocks.ARTIFACTBLOCK, properties).setRegistryName("artifactblock"));
            event.getRegistry().register(new BlockItem(ModBlocks.GOLEMMASK, properties).setRegistryName("golemmask"));
            
            //register items
            event.getRegistry().register(new HeartGemItem());
            
            // register glyphs
            event.getRegistry().register(new SpeedGlyphItem());
            event.getRegistry().register(new HealthGlyphItem());
            event.getRegistry().register(new AttackGlyphItem());
            
            // register spawn objects
            event.getRegistry().register(new GolemTotemItem(lostSharkBuilder).setRegistryName("sharktotem"));
            event.getRegistry().register(new GolemTotemItem(lesserGolemBuilder).setRegistryName("golemtotem"));
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(GolemMaskTile::new, ModBlocks.GOLEMMASK).build(null).setRegistryName("golemmask"));
        }
        
        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(lostSharkBuilder);
            event.getRegistry().register(lesserGolemBuilder);
        }
    }
}
