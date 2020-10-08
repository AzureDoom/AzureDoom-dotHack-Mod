package mod.azure.dothack.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChimChimModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer chimBody;
	public ModelRenderer orb;
	public ModelRenderer chimRightLeg;
	public ModelRenderer chimLeftLeg;

	public ChimChimModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.chimBody = new ModelRenderer(this, 16, 16);
		this.chimBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chimBody.addBox(-4.0F, 9.6F, -2.0F, 8.0F, 12.0F, 4.0F, 1.0F, -1.0F, 0.25F);
		this.chimLeftLeg = new ModelRenderer(this, 16, 48);
		this.chimLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
		this.chimLeftLeg.addBox(-2.0F, 7.8F, -2.0F, 4.0F, 12.0F, 4.0F, -0.75F, -0.75F, -0.75F);
		this.orb = new ModelRenderer(this, 0, 0);
		this.orb.setRotationPoint(0.0F, 7.4F, 0.0F);
		this.orb.addBox(-4.0F, -4.0F, -6.3F, 8.0F, 8.0F, 8.0F, -1.75F, -1.75F, -1.75F);
		this.chimRightLeg = new ModelRenderer(this, 0, 16);
		this.chimRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
		this.chimRightLeg.addBox(-2.0F, 7.8F, -2.0F, 4.0F, 12.0F, 4.0F, -0.75F, -0.75F, -0.75F);
		this.chimBody.addChild(this.chimLeftLeg);
		this.chimBody.addChild(this.chimRightLeg);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.chimBody, this.orb).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.chimRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.chimLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}