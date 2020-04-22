package vespi.lostcity.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import vespi.lostcity.entities.LesserGolemEntity;
import vespi.lostcity.entities.LesserGolemRenderer;

public class ClientProxy implements IProxy{
	@Override
	public void init() {
		RenderingRegistry.registerEntityRenderingHandler(LesserGolemEntity.class, LesserGolemRenderer::new);
	}
	
    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
