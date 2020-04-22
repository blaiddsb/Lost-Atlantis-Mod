package vespi.lostcity.entities;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LostSharkRenderer extends MobRenderer<LostSharkEntity, LostSharkModel<LostSharkEntity>> {
   private static final ResourceLocation LOST_SHARK_TEXTURES = new ResourceLocation("lostcity", "textures/entity/lostshark.png");

   public LostSharkRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new LostSharkModel<>(), 0.3F);
   }

   protected ResourceLocation getEntityTexture(LostSharkEntity entity) {
      return LOST_SHARK_TEXTURES;
   }
}