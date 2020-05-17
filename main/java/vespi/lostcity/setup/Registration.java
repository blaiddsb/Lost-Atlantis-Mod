package vespi.lostcity.setup;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vespi.lostcity.LostCity;
import vespi.lostcity.dimension.TutorialModDimension;

public class Registration {
    private static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, LostCity.MODID);

    public static void init() {
        DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TutorialModDimension> DIMENSION = DIMENSIONS.register("dimension", TutorialModDimension::new);
}
