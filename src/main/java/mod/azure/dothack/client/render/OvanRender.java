package mod.azure.dothack.client.render;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.client.model.NPCModel;
import mod.azure.dothack.entity.OvanEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class OvanRender extends MobRenderer<OvanEntity, NPCModel<OvanEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DotHackMod.MODID,
			"textures/entity/ovan.png");

	public OvanRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NPCModel<OvanEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(OvanEntity entity) {
		return TEXTURE;
	}

}