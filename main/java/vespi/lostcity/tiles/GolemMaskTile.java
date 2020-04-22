package vespi.lostcity.tiles;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

import static vespi.lostcity.blocks.ModBlocks.GOLEMMASK_TILE;

public class GolemMaskTile extends TileEntity implements ITickableTileEntity {

	public GolemMaskTile() {
		super(GOLEMMASK_TILE);
	}

	@Override
	public void tick() {
		if (world.isRemote) {
			System.out.print("GolemMaskTile.tick");
		}
	}
}
