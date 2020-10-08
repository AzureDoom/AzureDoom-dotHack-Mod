package mod.azure.dothack.client.render;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.client.model.NPCModel;
import mod.azure.dothack.entity.bases.NPCEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class AtoliRender extends MobRenderer<NPCEntity, NPCModel<NPCEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DotHackMod.MODID,
			"textures/entity/atoli.png");

	public AtoliRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new NPCModel<NPCEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(NPCEntity entity) {
		return TEXTURE;
	}

}