package mod.azure.dothack.client.model;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.entity.SkeithEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SkeithModel extends AnimatedEntityModel<SkeithEntity> {

	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer bone2;
	private final AnimatedModelRenderer bone4;
	private final AnimatedModelRenderer bone3;
	private final AnimatedModelRenderer bone5;
	private final AnimatedModelRenderer bone6;
	private final AnimatedModelRenderer bone7;
	private final AnimatedModelRenderer bone8;
	private final AnimatedModelRenderer bone9;
	private final AnimatedModelRenderer bone18;
	private final AnimatedModelRenderer bone12;
	private final AnimatedModelRenderer bone15;
	private final AnimatedModelRenderer bone16;
	private final AnimatedModelRenderer bone17;
	private final AnimatedModelRenderer bone13;
	private final AnimatedModelRenderer bone14;
	private final AnimatedModelRenderer bone10;
	private final AnimatedModelRenderer bone11;

	public SkeithModel() {
		textureWidth = 256;
		textureHeight = 256;
		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(0.0F, -64.0F, 0.0F);
		setRotationAngle(bone, 0.5236F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-13.0F, -7.0F, -10.0F, 26.0F, 15.0F, 19.0F, 0.0F, false);
		bone.setModelRendererName("bone");
		this.registerModelRenderer(bone);

		bone2 = new AnimatedModelRenderer(this);
		bone2.setRotationPoint(0.0F, 6.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, -0.5672F, 0.0F, 0.0F);
		bone2.setTextureOffset(39, 80).addBox(-4.5F, -1.0F, -6.0F, 9.0F, 20.0F, 9.0F, 0.0F, false);
		bone2.setModelRendererName("bone2");
		this.registerModelRenderer(bone2);

		bone4 = new AnimatedModelRenderer(this);
		bone4.setRotationPoint(0.0F, 18.0F, 0.0F);
		bone2.addChild(bone4);
		setRotationAngle(bone4, 0.6981F, 0.0F, 0.0F);

		bone4.setModelRendererName("bone4");
		this.registerModelRenderer(bone4);

		bone3 = new AnimatedModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone3);
		setRotationAngle(bone3, 0.0F, -0.7854F, 0.0F);
		bone3.setTextureOffset(0, 59).addBox(-7.5F, -5.0F, -7.5F, 12.0F, 12.0F, 12.0F, 0.0F, false);
		bone3.setModelRendererName("bone3");
		this.registerModelRenderer(bone3);

		bone5 = new AnimatedModelRenderer(this);
		bone5.setRotationPoint(0.0F, -7.0F, 7.5F);
		bone.addChild(bone5);
		setRotationAngle(bone5, 1.0472F, 0.0F, 0.0F);
		bone5.setTextureOffset(104, 73).addBox(-4.0F, -7.0F, -2.5F, 7.0F, 7.0F, 7.0F, 0.0F, false);
		bone5.setModelRendererName("bone5");
		this.registerModelRenderer(bone5);

		bone6 = new AnimatedModelRenderer(this);
		bone6.setRotationPoint(0.0F, -3.0F, 1.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.6109F, 0.0F, 0.0F);
		bone6.setTextureOffset(0, 120).addBox(-20.0F, 0.5479F, 0.7528F, 41.0F, 34.0F, 0.0F, 0.0F, false);
		bone6.setModelRendererName("bone6");
		this.registerModelRenderer(bone6);

		bone7 = new AnimatedModelRenderer(this);
		bone7.setRotationPoint(-21.5F, -1.5F, 1.5F);
		bone.addChild(bone7);
		setRotationAngle(bone7, -0.0873F, 0.0F, 0.3491F);
		bone7.setTextureOffset(71, 0).addBox(-7.5F, -4.5F, -4.5F, 12.0F, 9.0F, 9.0F, 0.0F, false);
		bone7.setModelRendererName("bone7");
		this.registerModelRenderer(bone7);

		bone8 = new AnimatedModelRenderer(this);
		bone8.setRotationPoint(-2.0F, 9.0F, -1.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, -1.789F, 0.0873F, -0.0436F);
		bone8.setTextureOffset(95, 99).addBox(-3.5F, -2.5F, -0.5F, 7.0F, 6.0F, 10.0F, 0.0F, false);
		bone8.setModelRendererName("bone8");
		this.registerModelRenderer(bone8);

		bone9 = new AnimatedModelRenderer(this);
		bone9.setRotationPoint(0.0F, 1.0F, 15.0F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, -0.5236F, 0.0873F, -0.1309F);
		bone9.setTextureOffset(49, 49).addBox(-5.5F, -4.5F, -0.5F, 10.0F, 10.0F, 21.0F, 0.0F, false);
		bone9.setTextureOffset(91, 45).addBox(-1.0F, -3.5F, 20.5F, 2.0F, 8.0F, 16.0F, 0.0F, false);
		bone9.setModelRendererName("bone9");
		this.registerModelRenderer(bone9);

		bone18 = new AnimatedModelRenderer(this);
		bone18.setRotationPoint(23.5F, 79.5F, -15.5F);
		bone9.addChild(bone18);
		bone18.setTextureOffset(215, 161).addBox(-24.1514F, -118.3636F, 41.7471F, 2.0F, 90.0F, 4.0F, 0.0F, false);
		bone18.setTextureOffset(0, 192).addBox(-23.1967F, -59.2267F, 23.7425F, 0.0F, 30.0F, 34.0F, 0.0F, false);
		bone18.setModelRendererName("bone18");
		this.registerModelRenderer(bone18);

		bone12 = new AnimatedModelRenderer(this);
		bone12.setRotationPoint(21.5F, -1.5F, 1.5F);
		bone.addChild(bone12);
		setRotationAngle(bone12, -0.0873F, 0.0F, -0.3491F);
		bone12.setTextureOffset(71, 0).addBox(-4.5F, -4.5F, -4.5F, 12.0F, 9.0F, 9.0F, 0.0F, true);
		bone12.setModelRendererName("bone12");
		this.registerModelRenderer(bone12);

		bone15 = new AnimatedModelRenderer(this);
		bone15.setRotationPoint(2.0F, 9.0F, -1.0F);
		bone12.addChild(bone15);
		setRotationAngle(bone15, -1.789F, -0.0873F, 0.0436F);
		bone15.setTextureOffset(95, 99).addBox(-3.5F, -2.5F, -0.5F, 7.0F, 6.0F, 10.0F, 0.0F, true);
		bone15.setModelRendererName("bone15");
		this.registerModelRenderer(bone15);

		bone16 = new AnimatedModelRenderer(this);
		bone16.setRotationPoint(0.0F, 1.0F, 15.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, -0.5236F, -0.0873F, 0.1309F);
		bone16.setTextureOffset(49, 49).addBox(-4.5F, -4.5F, -0.5F, 10.0F, 10.0F, 21.0F, 0.0F, true);
		bone16.setTextureOffset(91, 45).addBox(-1.0F, -3.5F, 20.5F, 2.0F, 8.0F, 16.0F, 0.0F, true);
		bone16.setModelRendererName("bone16");
		this.registerModelRenderer(bone16);

		bone17 = new AnimatedModelRenderer(this);
		bone17.setRotationPoint(0.0F, 35.5622F, -18.2224F);
		bone.addChild(bone17);
		setRotationAngle(bone17, -0.5236F, 0.0F, 0.0F);

		bone17.setModelRendererName("bone17");
		this.registerModelRenderer(bone17);

		bone13 = new AnimatedModelRenderer(this);
		bone13.setRotationPoint(-14.0F, -2.0F, 0.0F);
		bone17.addChild(bone13);
		setRotationAngle(bone13, 0.0F, -0.7854F, -0.2618F);
		bone13.setTextureOffset(79, 23).addBox(-6.0F, -5.0F, -5.0F, 11.0F, 10.0F, 11.0F, 0.0F, false);
		bone13.setModelRendererName("bone13");
		this.registerModelRenderer(bone13);

		bone14 = new AnimatedModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.48F, -0.7854F, 0.0F);
		bone14.setTextureOffset(75, 80).addBox(-3.5F, 0.7F, -4.4F, 7.0F, 21.0F, 8.0F, 0.0F, false);
		bone14.setTextureOffset(0, 83).addBox(-2.0F, 21.7F, -4.4F, 4.0F, 30.0F, 6.0F, 0.0F, false);
		bone14.setModelRendererName("bone14");
		this.registerModelRenderer(bone14);

		bone10 = new AnimatedModelRenderer(this);
		bone10.setRotationPoint(14.0F, -2.0F, 0.0F);
		bone17.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 0.7854F, 0.2618F);
		bone10.setTextureOffset(79, 23).addBox(-5.0F, -5.0F, -5.0F, 11.0F, 10.0F, 11.0F, 0.0F, true);
		bone10.setModelRendererName("bone10");
		this.registerModelRenderer(bone10);

		bone11 = new AnimatedModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.48F, 0.7854F, 0.0F);
		bone11.setTextureOffset(75, 80).addBox(-3.5F, 0.7F, -4.4F, 7.0F, 21.0F, 8.0F, 0.0F, true);
		bone11.setTextureOffset(0, 83).addBox(-2.0F, 21.7F, -4.4F, 4.0F, 30.0F, 6.0F, 0.0F, true);
		bone11.setModelRendererName("bone11");
		this.registerModelRenderer(bone11);

		this.rootBones.add(bone);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DotHackMod.MODID, "animations/skeith_animation.json");
	}
}