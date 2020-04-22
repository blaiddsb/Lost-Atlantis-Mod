package vespi.lostcity.entities;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vespi.lostcity.LostCity;
import vespi.lostcity.items.GlyphItem;
import vespi.lostcity.items.GolemTotemItem;
import vespi.lostcity.items.ModItems;

public class LesserGolemEntity extends TameableEntity {
	private int attackTimer;
	
	// Entity variables
	private ArrayList<String> glyphs;
//	private static final DataParameter<Boolean> DATA_ID_CHEST = EntityDataManager.createKey(LesserGolemEntity.class, DataSerializers.BOOLEAN);
	
	public LesserGolemEntity(EntityType<? extends LesserGolemEntity> type, World worldIn) {
		super(type, worldIn);
	    this.setTamed(false);
	    this.stepHeight = 1.0F;
	    this.glyphs = new ArrayList<String>();
	}
	
//	protected void registerData() {
//		super.registerData();
//		this.dataManager.register(DATA_ID_CHEST, false);
//	}
	
	protected void registerGoals() {
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.75D));
		this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.5F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}
	
	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
	   	super.setAttackTarget(entitylivingbaseIn);
	}
	
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_IRON_GOLEM_STEP, 0.15F, 1.0F);
	}
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
	}
	
	protected float getSoundVolume() {
		return 0.4f;
	}
	
	@SuppressWarnings("deprecation")
	public void livingTick() {
		super.livingTick();
		
		if (this.attackTimer > 0) {
			--this.attackTimer;
	    }
		
		if (func_213296_b(this.getMotion()) > (double)2.5000003E-7F && this.rand.nextInt(5) == 0) {
		    int i = MathHelper.floor(this.posX);
		    int j = MathHelper.floor(this.posY - (double)0.2F);
		    int k = MathHelper.floor(this.posZ);
		    BlockState blockstate = this.world.getBlockState(new BlockPos(i, j, k));
		    if (!blockstate.isAir()) {
		    	this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(new BlockPos(i, j, k)), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), this.getBoundingBox().minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
		    }
	    }
	}
	
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			Entity entity = source.getTrueSource();
			
			if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
				amount = (amount + 1.0F) / 2.0F;
			}
			
			return super.attackEntityFrom(source, amount);
		}
	}
	
	public boolean attackEntityAsMob(Entity entityIn) {
	    this.attackTimer = 10;
	    this.world.setEntityState(this, (byte)4);
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
      	}
	    
		this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
      	return flag;
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
        System.out.println("started interact");
		ItemStack itemstack = player.getHeldItem(hand);
		Item item = itemstack.getItem();
		
		if(itemstack.isEmpty()) {
			if (!this.isTamed() || (this.isTamed() && this.isOwner(player))) {
				if (!this.world.isRemote) {
		            this.navigator.clearPath();
		            this.setAttackTarget((LivingEntity)null);
		            
					Item newGolemItemEntity = this.entityDropItem(ModItems.GOLEMTOTEM).getItem().getItem();
					((GolemTotemItem) newGolemItemEntity).setGlyphs(this.glyphs, this.getOwner(), this.hasCustomName() ? this.getCustomName() : null);
					
		            this.remove();
				}
				
	            return true;
			} else {
				return super.processInteract(player, hand);
			}
		} else if (item == ModItems.HEARTGEM && !this.isTamed()) {
			// tame the golem
            if (!player.abilities.isCreativeMode) {
            	itemstack.shrink(1);
            }
			
            if (!this.world.isRemote()) {
                this.setTamedBy(player);
                this.navigator.clearPath();
                this.setAttackTarget((LivingEntity)null);
                this.setHealth(40.0F);
                this.playTameEffect(true);
                this.world.setEntityState(this, (byte)7);
            }
			return true;
		} else if (item instanceof GlyphItem) {
			System.out.println("glyph time!");
			
			GlyphItem glyphitem = (GlyphItem) item;
			if (addGlyph(glyphitem.GLYPH_ID)) {
	            if (!player.abilities.isCreativeMode) {
	            	itemstack.shrink(1);
	            }
			}
			
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}
	
	@Nullable
	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return null;
	}
	
	public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
		if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
			if (target instanceof TameableEntity) {
				TameableEntity tameableentity = (TameableEntity) target;
				if (tameableentity.isTamed() && tameableentity.getOwner() == owner) {
					return false;
				}
			}
			
			if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).canAttackPlayer((PlayerEntity)target)) {
				return false;
			} else if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame()) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 4) {
			this.attackTimer = 10;
	        this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}
	
	public boolean addGlyph(String glyphId) {
		if (!this.glyphs.contains(glyphId)) {
			this.glyphs.add(glyphId);
			calculateAttributes();
			
			return true;
		}
		return false;
	}
	
	public void setGlyphs(ArrayList<String> glyphs) {
		this.glyphs = glyphs;
		calculateAttributes();
	}
	
	public ArrayList<String> getGlyphs() {
		return this.glyphs;
	}
	
//	public boolean hasChest() {
//		return this.dataManager.get(DATA_ID_CHEST);
//	}
//	
//	public void setChested(boolean chested) {
//		this.dataManager.set(DATA_ID_CHEST, chested);
//	}
//	
//	protected int getInventorySize() {
//		return this.hasChest() ? 17 : 0;
//	}
//	
//	protected void dropInventory() {
//		super.dropInventory();
//		if (this.hasChest()) {
//			if (!this.world.isRemote) {
//				this.entityDropItem(Blocks.CHEST);
//	      	}
//			
//	      	this.setChested(false);
//	    }
//	}
	
	public void calculateAttributes(){
		if (this.glyphs.contains("speedglyph")) {
			this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.6F);
		} else {
			this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
		}
		
		if (this.glyphs.contains("healthglyph")) {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
		} else {
			this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		}
		
		if (this.glyphs.contains("attackglyph")) {
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
		} else {
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		}
		
		// TODO: Set up inventory
	}
}
