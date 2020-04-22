package vespi.lostcity.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;
import vespi.lostcity.blocks.ModBlocks;

public class OreGen {

    public static void setupOreGen(){
        for(Biome biome: ForgeRegistries.BIOMES){
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Biome.createDecoratedFeature
                  (Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.ARTIFACTBLOCK.getDefaultState(),2), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 20)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Biome.createDecoratedFeature
                    (Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,ModBlocks.OSTRUMORE.getDefaultState(),15),Placement.COUNT_RANGE, new CountRangeConfig(100,0,0,128)));
        }
    }

}
