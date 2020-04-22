package vespi.lostcity.blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import vespi.lostcity.blocks.ModBlocks;
import javax.annotation.Nullable;

public class CrystalliserContainer extends Container {
    public  CrystalliserContainer(int windowId, World world, BlockPos pos, PlayerInventory inventory) {
        super(ModBlocks.CRYSTALLISER_CONTAINER, windowId);
       TileEntity tileEntity = world.getTileEntity(pos);
       tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
