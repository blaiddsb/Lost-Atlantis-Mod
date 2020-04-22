package vespi.lostcity.entities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class LostSharkEntity extends WaterMobEntity {

	public LostSharkEntity(EntityType<? extends LostSharkEntity> type, World worldIN) {
		super(type, worldIN);
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		this.setAir(this.getMaxAir());
		this.rotationPitch = 0.0F;
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	public boolean canBreatheUnderwater() {
		return false;
	}
	
	public void updateAir(int p_209207_1_) {
	}
}
