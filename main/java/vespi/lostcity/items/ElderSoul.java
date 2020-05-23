package vespi.lostcity.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import vespi.lostcity.dimension.ModDimensions;
import vespi.lostcity.dimension.TutorialDimension;
import vespi.lostcity.setup.ModSetup;

public class ElderSoul extends Item {
    public ElderSoul(){
        super(new Properties()
                .maxStackSize(16)
                .group(ModSetup.itemGroup));
        setRegistryName("eldersoul");
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote) {
            if (playerIn.isInWater()) {
                if (worldIn.dimension.getType() == ModDimensions.DIMENSION_TYPE) {
                    playerIn.changeDimension(DimensionType.OVERWORLD);
                } else {
                    playerIn.changeDimension(ModDimensions.DIMENSION_TYPE);
                }
            } else {
                playerIn.sendMessage(new StringTextComponent("The Soul seems to pull you toward the water... but not much else happens"));
            }
        }
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
