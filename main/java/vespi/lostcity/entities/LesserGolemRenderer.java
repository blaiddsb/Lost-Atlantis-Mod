package vespi.lostcity.entities;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LesserGolemRenderer extends MobRenderer<LesserGolemEntity, LesserGolemModel<LesserGolemEntity>> {
   private static final ResourceLocation LESSER_GOLEM_TEXTURES = new ResourceLocation("lostcity", "textures/entity/lostgolem.png");

   public LesserGolemRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new LesserGolemModel<>(), 0.3F);
   }

   protected ResourceLocation getEntityTexture(LesserGolemEntity entity) {
      return LESSER_GOLEM_TEXTURES;
   }

   protected void applyRotations(LesserGolemEntity entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
      super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
      if (!((double)entityLiving.limbSwingAmount < 0.01D)) {
         float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
         float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
         GlStateManager.rotatef(6.5F * f2, 0.0F, 0.0F, 1.0F);
      }
   }
}