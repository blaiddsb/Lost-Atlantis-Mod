package vespi.lostcity.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LesserGolemModel<T extends LesserGolemEntity> extends EntityModel<T> {
   private final RendererModel field_78178_a;
   private final RendererModel field_78176_b;
   public final RendererModel field_78177_c;
   private final RendererModel field_78174_d;
   private final RendererModel ironGolemLeftLeg;
   private final RendererModel ironGolemRightLeg;
   
   private static final float scale_adjustment = 0.5F;

   public LesserGolemModel() {
      this(0.0F);
   }

   public LesserGolemModel(float p_i1161_1_) {
      this(p_i1161_1_, 18F);
   }

   public LesserGolemModel(float p_i46362_1_, float p_i46362_2_) {	
	   	// Create Render Models 
		this.field_78178_a = (new RendererModel(this)).setTextureSize(128, 128);
		this.field_78176_b = (new RendererModel(this)).setTextureSize(128, 128);
		this.field_78177_c = (new RendererModel(this)).setTextureSize(128, 128);
		this.field_78174_d = (new RendererModel(this)).setTextureSize(128, 128);
		this.ironGolemLeftLeg = (new RendererModel(this, 0, 22)).setTextureSize(128, 128);
		this.ironGolemRightLeg = (new RendererModel(this, 0, 22)).setTextureSize(128, 128);
		
		// Set Rotation Points
		this.field_78178_a.setRotationPoint(0.0F, p_i46362_2_, -2.0F);
		this.field_78176_b.setRotationPoint(0.0F, p_i46362_2_, 0.0F);
		this.field_78177_c.setRotationPoint(0.0F, p_i46362_2_, 0.0F);
		this.field_78174_d.setRotationPoint(0.0F, p_i46362_2_, 0.0F);
		this.ironGolemLeftLeg.setRotationPoint(-4.0F, 18.0F + p_i46362_2_, 0.0F);
		this.ironGolemRightLeg.mirror = true;
		this.ironGolemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + p_i46362_2_, 0.0F);
		
		// Add Boxes
		this.field_78178_a.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, p_i46362_1_);
		this.field_78178_a.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, p_i46362_1_);
		this.field_78176_b.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, p_i46362_1_);
		this.field_78176_b.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, p_i46362_1_ + 0.5F);
		this.field_78177_c.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, p_i46362_1_);
		this.field_78174_d.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, p_i46362_1_);
		this.ironGolemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i46362_1_);
		this.ironGolemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, p_i46362_1_);
   }

   public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	  float adjusted_scale = scale * scale_adjustment;
	  this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, adjusted_scale);
      this.field_78178_a.render(adjusted_scale);
      this.field_78176_b.render(adjusted_scale);
      this.ironGolemLeftLeg.render(adjusted_scale);
      this.ironGolemRightLeg.render(adjusted_scale);
      this.field_78177_c.render(adjusted_scale);
      this.field_78174_d.render(adjusted_scale);
   }

   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
      this.field_78178_a.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
      this.field_78178_a.rotateAngleX = headPitch * ((float)Math.PI / 180F);
      this.ironGolemLeftLeg.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
      this.ironGolemRightLeg.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
      this.ironGolemLeftLeg.rotateAngleY = 0.0F;
      this.ironGolemRightLeg.rotateAngleY = 0.0F;
   }

   public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
      int i = entityIn.getAttackTimer();
      if (i > 0) {
         this.field_78177_c.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTick, 10.0F);
         this.field_78174_d.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTick, 10.0F);
      } else {
          this.field_78177_c.rotateAngleX = 0F;
          this.field_78174_d.rotateAngleX = 0F;
       }
   }

   private float triangleWave(float p_78172_1_, float p_78172_2_) {
      return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
   }

   public RendererModel func_205071_a() {
      return this.field_78177_c;
   }
}