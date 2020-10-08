package mod.azure.dothack.client.render;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.client.model.SkeithModel;
import mod.azure.dothack.entity.SkeithEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SkeithRender extends MobRenderer<SkeithEntity, SkeithModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DotHackMod.MODID,
			"textures/entity/skeith-texturemap.png");

	public SkeithRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SkeithModel(), 0.8F);
	}

	@Override
	public ResourceLocation getEntityTexture(SkeithEntity entity) {
		return TEXTURE;
	}

}