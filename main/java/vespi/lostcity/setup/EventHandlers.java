package vespi.lostcity.setup;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vespi.lostcity.LostCity;
import vespi.lostcity.dimension.ModDimensions;

@Mod.EventBusSubscriber(modid = LostCity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandlers {

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        if (event.getName().equals(new ResourceLocation("minecraft", "entities/elder_guardian"))) {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation("lostcity", "entities/elder_guardian"))).build());
        }
    }

    @SubscribeEvent
    public static void onDimensionRegistry(RegisterDimensionsEvent event){
       ModDimensions.DIMENSION_TYPE = DimensionManager.registerOrGetDimension(ModDimensions.DIMENSION_ID, ModDimensions.DIMENSION,null,true);    }
}


