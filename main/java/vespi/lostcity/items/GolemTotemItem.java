package vespi.lostcity.items;

import java.util.ArrayList;
import java.util.Objects;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import vespi.lostcity.LostCity;
import vespi.lostcity.dimension.TutorialDimension;
import vespi.lostcity.entities.LesserGolemEntity;

public class GolemTotemItem extends Item {
	private final EntityType<?> typeIn;
	
	// Item variables
	private ArrayList<String> glyphs;
	private LivingEntity owner;
	private ITextComponent customName;
	
	
	public GolemTotemItem(EntityType<?> typeIn) {
		super(new Item.Properties()
				.maxStackSize(1)
				.group(LostCity.setup.itemGroup));
		
		this.typeIn = typeIn;
		
		this.glyphs = new ArrayList<String>();
		this.owner = null;
		this.customName = null;
	}
	
	public ActionResultType onItemUse(ItemUseContext context) {
	  World world = context.getWorld();
	  if (world.isRemote) {
	     return ActionResultType.SUCCESS;
	  } else {
	     ItemStack itemstack = context.getItem();
	     BlockPos blockpos = context.getPos();
	     Direction direction = context.getFace();
	     BlockState blockstate = world.getBlockState(blockpos);

	     BlockPos blockpos1;
	     if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
	        blockpos1 = blockpos;
	     } else {
	        blockpos1 = blockpos.offset(direction);
	     }
	
	     EntityType<?> entitytype = this.getType(itemstack.getTag());
	     LesserGolemEntity newEntity = (LesserGolemEntity) entitytype.spawn(world, itemstack, context.getPlayer(), blockpos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP);
	     if (newEntity != null) {
	    	newEntity.setGlyphs(this.glyphs);
	    	
	    	if (this.owner != null) {
	    		newEntity.setTamedBy((PlayerEntity) owner);
	    	}
	    	
	    	if (this.customName != null) {
		    	newEntity.setCustomName(this.customName);
	    	}
	    	
	        itemstack.shrink(1);
	     }
	
	     return ActionResultType.SUCCESS;
	  }
	}
	
	public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
	      if (p_208076_1_ != null && p_208076_1_.contains("EntityTag", 10)) {
	          CompoundNBT compoundnbt = p_208076_1_.getCompound("EntityTag");
	          if (compoundnbt.contains("id", 8)) {
	             return EntityType.byKey(compoundnbt.getString("id")).orElse(this.typeIn);
	          }
	       }

	       return this.typeIn;
	}
	
	public void setGlyphs(ArrayList<String> glyphs, LivingEntity livingEntity, ITextComponent customName) {
		this.glyphs = glyphs;
		this.owner = livingEntity;
		this.customName = customName;
	}
}
