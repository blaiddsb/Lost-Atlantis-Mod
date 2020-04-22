package vespi.lostcity.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public class LostSharkModel<T extends LostSharkEntity> extends EntityModel<T> {
	private final RendererModel frontbody;
	private final RendererModel head;
	private final RendererModel mouth;
	private final RendererModel midbody;
	private final RendererModel tail;
	private final RendererModel tailfin;
	private final RendererModel rightflipper;
	private final RendererModel leftflipper;

	public LostSharkModel() {
		textureWidth = 64;
		textureHeight = 64;

		frontbody = new RendererModel(this);
		frontbody.setRotationPoint(0.0F, 20.0F, 0.0F);
		frontbody.cubeList.add(new ModelBox(frontbody, 0, 0, -4.0F, -3.0F, -4.0F, 8, 6, 9, 0.0F, false));
		frontbody.cubeList.add(new ModelBox(frontbody, 33, 34, -1.0F, -5.0F, 0.0F, 2, 2, 5, 0.0F, false));
		frontbody.cubeList.add(new ModelBox(frontbody, 0, 37, -1.0F, -7.0F, 1.0F, 2, 2, 4, 0.0F, false));
		frontbody.cubeList.add(new ModelBox(frontbody, 24, 39, -1.0F, -8.0F, 2.0F, 2, 1, 3, 0.0F, false));
		frontbody.cubeList.add(new ModelBox(frontbody, 7, 0, 0.0F, -9.0F, 5.0F, 0, 4, 1, 0.0F, false));
		frontbody.cubeList.add(new ModelBox(frontbody, 0, 0, 0.0F, -9.0F, 6.0F, 0, 1, 1, 0.0F, false));
		frontbody.cubeList.add(new ModelBox(frontbody, 0, 1, 0.0F, -9.0F, 3.0F, 0, 1, 2, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, -1.0F, -4.0F);
		frontbody.addChild(head);
		head.cubeList.add(new ModelBox(head, 34, 41, -2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 25, 0, -3.0F, -2.0F, -5.0F, 6, 5, 3, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 34, 8, -3.0F, -1.0F, -6.0F, 6, 4, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 34, 18, -2.0F, -2.0F, -6.0F, 4, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 29, -3.0F, -2.0F, -2.0F, 6, 6, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 12, 37, -2.0F, -1.0F, -8.0F, 4, 4, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 6, 5, -2.0F, 3.0F, -4.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 6, 4, -2.0F, 3.0F, -6.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 4, -1.0F, 3.0F, -8.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 1, 1.0F, 3.0F, -8.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 5, 0, 2.0F, 3.0F, -6.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 5, 2.0F, 3.0F, -4.0F, 0, 1, 1, 0.0F, false));

		mouth = new RendererModel(this);
		mouth.setRotationPoint(0.0F, 3.0F, -1.0F);
		setRotationAngle(mouth, 0.3491F, 0.0F, 0.0F);
		head.addChild(mouth);
		mouth.cubeList.add(new ModelBox(mouth, 0, 5, -1.0F, 0.432F, -7.1062F, 2, 1, 2, 0.0F, false));
		mouth.cubeList.add(new ModelBox(mouth, 25, 25, -2.0F, 0.432F, -5.1062F, 4, 1, 5, 0.0F, false));

		midbody = new RendererModel(this);
		midbody.setRotationPoint(0.0F, -1.0F, 4.0F);
		frontbody.addChild(midbody);
		midbody.cubeList.add(new ModelBox(midbody, 0, 15, -3.0F, -2.0F, 1.0F, 6, 5, 9, 0.0F, false));

		tail = new RendererModel(this);
		tail.setRotationPoint(0.0F, 0.0F, 10.0F);
		midbody.addChild(tail);
		tail.cubeList.add(new ModelBox(tail, 21, 15, -2.0F, -2.0F, 0.0F, 4, 4, 5, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 0, 2, 0.0F, -1.0F, 6.0F, 0, 1, 2, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 16, 29, -1.0F, -2.0F, 5.0F, 2, 3, 1, 0.0F, false));

		tailfin = new RendererModel(this);
		tailfin.setRotationPoint(0.0F, 0.0F, 8.0F);
		tail.addChild(tailfin);
		tailfin.cubeList.add(new ModelBox(tailfin, 6, 7, 0.0F, -1.0F, 0.0F, 0, 1, 1, 0.0F, false));
		tailfin.cubeList.add(new ModelBox(tailfin, 0, 16, 0.0F, -5.0F, 2.0F, 0, 1, 3, 0.0F, false));
		tailfin.cubeList.add(new ModelBox(tailfin, 0, 17, 0.0F, 3.0F, 2.0F, 0, 1, 3, 0.0F, false));
		tailfin.cubeList.add(new ModelBox(tailfin, 0, 5, 0.0F, 2.0F, 1.0F, 0, 1, 3, 0.0F, false));
		tailfin.cubeList.add(new ModelBox(tailfin, 0, 18, 0.0F, -4.0F, 1.0F, 0, 1, 3, 0.0F, false));
		tailfin.cubeList.add(new ModelBox(tailfin, 0, 12, 0.0F, 0.0F, 0.0F, 0, 2, 3, 0.0F, false));
		tailfin.cubeList.add(new ModelBox(tailfin, 0, 14, 0.0F, -3.0F, 0.0F, 0, 2, 3, 0.0F, false));

		rightflipper = new RendererModel(this);
		rightflipper.setRotationPoint(-3.0F, 3.0F, 0.0F);
		setRotationAngle(rightflipper, 0.0F, 0.0F, -0.0873F);
		frontbody.addChild(rightflipper);
		rightflipper.cubeList.add(new ModelBox(rightflipper, 35, 20, -4.1024F, -0.6552F, -1.0F, 3, 1, 4, 0.0F, false));
		rightflipper.cubeList.add(new ModelBox(rightflipper, 24, 31, -1.1024F, -1.6552F, -2.0F, 1, 2, 6, 0.0F, false));
		rightflipper.cubeList.add(new ModelBox(rightflipper, 35, 25, -8.1024F, 0.3448F, 0.0F, 4, 0, 3, 0.0F, false));
		rightflipper.cubeList.add(new ModelBox(rightflipper, 2, 2, -9.1024F, 0.3448F, 1.0F, 1, 0, 3, 0.0F, false));

		leftflipper = new RendererModel(this);
		leftflipper.setRotationPoint(3.0F, 3.0F, 0.0F);
		setRotationAngle(leftflipper, 0.0F, 3.1416F, 0.0873F);
		frontbody.addChild(leftflipper);
		leftflipper.cubeList.add(new ModelBox(leftflipper, 34, 13, -4.1024F, -0.6552F, -1.0F, 3, 1, 4, 0.0F, false));
		leftflipper.cubeList.add(new ModelBox(leftflipper, 16, 29, -1.1024F, -1.6552F, -2.0F, 1, 2, 6, 0.0F, false));
		leftflipper.cubeList.add(new ModelBox(leftflipper, 29, 31, -8.1024F, 0.3448F, -1.0F, 4, 0, 3, 0.0F, false));
		leftflipper.cubeList.add(new ModelBox(leftflipper, 0, 0, -9.1024F, 0.3448F, -2.0F, 1, 0, 3, 0.0F, false));
	}

	@Override
	public void render(LostSharkEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		frontbody.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}