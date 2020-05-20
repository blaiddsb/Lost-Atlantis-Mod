package vespi.lostcity.dimension;

import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;
import vespi.lostcity.tools.SimplexNoise;

import javax.annotation.Nullable;
import java.util.*;

public class TutorialBiomeProvider extends BiomeProvider {
    private final Biome[] biomes = new Biome[]{Biomes.WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN};

    public TutorialBiomeProvider() {
    }

    @Override
    public Biome getBiome(BlockPos pos) {

        return this.getBiome(pos.getX(), pos.getZ());
    }

    @Override
    public Biome getBiome(int x, int y) {
        float noise = (float) SimplexNoise.noise((float)x/40, (float)y/40);
        if (noise >= 0) {
            return Biomes.WARM_OCEAN;
        } else {
            return Biomes.DEEP_LUKEWARM_OCEAN;
        }
    }

    @Override
    public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
        Biome[] biomes = new Biome[width * length];
        for (int bx = 0; bx < width; bx++){
            for (int bz = 0; bz < length; bz++){
                biomes[bx + bz * width] = getBiome(x/16, z/16);
            }
        }
        return biomes;
    }

    @Override
    public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength) {
        return Collections.singleton(this.getBiome(centerX, centerZ));
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
        if (this.topBlocksCache.isEmpty()) {
            for(Biome biome : this.biomes) {
                this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
            }
        }

        return this.topBlocksCache;
    }
}
