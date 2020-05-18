package vespi.lostcity.dimension;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;

import javax.annotation.Nullable;
import java.util.*;

public class TutorialBiomeProvider extends BiomeProvider {
    private final Biome biome;
    private static final List<Biome> SPAWN = Arrays.asList(Biomes.WARM_OCEAN, Biomes.OCEAN);

    public TutorialBiomeProvider() {
        biome = Biomes.WARM_OCEAN;
    }

    @Override
    public Biome getBiome(int x, int y) {
        return biome;
    }

    @Override
    public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
        Biome[] biomes = new Biome[width * length];
        Arrays.fill(biomes, biome);
        return biomes;
    }

    @Override
    public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength) {
        return Collections.singleton(biome);
    }

    @Nullable
    @Override
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        return new BlockPos(x, 65, z);
    }

    @Override
    public boolean hasStructure(Structure<?> structureIn) {
        return false;
    }

    @Override
    public Set<BlockState> getSurfaceBlocks() {
        if (topBlocksCache.isEmpty()) {
            topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
        }

        return topBlocksCache;
    }
}
