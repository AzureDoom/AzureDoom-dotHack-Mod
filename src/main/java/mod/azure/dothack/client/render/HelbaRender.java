package mod.azure.dothack.client.render;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.client.model.NPCModel;
import mod.azure.dothack.entity.HelbaEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class HelbaRender extends MobRenderer<HelbaEntity, NPCModel<HelbaEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DotHackMod.MODID,
			"textures/entity/helba.png");

	public HelbaRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NPCModel<HelbaEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(HelbaEntity entity) {
		return TEXTURE;
	}

}