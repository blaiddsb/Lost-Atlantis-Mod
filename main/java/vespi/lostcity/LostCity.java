package vespi.lostcity;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vespi.lostcity.blocks.*;
import vespi.lostcity.items.*;
import vespi.lostcity.setup.*;

import java.awt.*;

import static vespi.lostcity.blocks.ModBlocks.*;


@Mod("lostcity")
public class LostCity {
    public static final String MODID = "lostcity";


    private static final Logger LOGGER = LogManager.getLogger();
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static ModSetup setup = new ModSetup();

    public LostCity() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(EventHandlers.class);
        
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
            event.getRegistry().register(new Crystalliser());
            event.getRegistry().register(new LostGlass());
            event.getRegistry().register(new OstrumOre());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties().group(setup.itemGroup);

            //blockItems
            event.getRegistry().register(new BlockItem(ARTIFACTBLOCK, new Item.Properties().group(ModSetup.itemGroup)).setRegistryName("artifactblock"));
            event.getRegistry().register(new BlockItem(CRYSTALLISER, new Item.Properties().group(ModSetup.itemGroup)).setRegistryName("crystalliser"));
            event.getRegistry().register(new BlockItem(LOSTGLASS,new Item.Properties().group(ModSetup.itemGroup)).setRegistryName("lostglass"));
            event.getRegistry().register(new BlockItem(OSTRUMORE, new Item.Properties().group(ModSetup.itemGroup)).setRegistryName("ostrumore"));


            //items
            event.getRegistry().register(new AlchemicalDust());
            event.getRegistry().register(new LostGem());
            event.getRegistry().register(new ElderSoul());
            event.getRegistry().register(new RelicHammer());
            event.getRegistry().register(new RelicPickaxe());
            event.getRegistry().register(new ArtifactShard());
            event.getRegistry().register(new RelicShovel());
            event.getRegistry().register(new RelicAxe());
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
            // this is how to build a registry for a tile entity.
            event.getRegistry().register(TileEntityType.Builder.create(CrystalliserTile::new, ModBlocks.CRYSTALLISER).build(null).setRegistryName("lostcity", "crystalliser"));

        }

        @SubscribeEvent
        public static void registerModDimensions(final RegistryEvent.Register<ModDimension> event) {
            //event.getRegistry().register(new ModLostDimension().setRegistryName(DIMENSION_ID));

        }
        
        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register( IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new CrystalliserContainer(windowId, LostCity.proxy.getClientWorld(), pos,inv);
            })).setRegistryName("crystalliser"));
        }
        
        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(lostSharkBuilder);
            event.getRegistry().register(lesserGolemBuilder);
        }
    }
}
