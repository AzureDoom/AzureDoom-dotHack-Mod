package mod.azure.dothack.client.render;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.client.model.ChimChimModel;
import mod.azure.dothack.entity.ChimChimEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ChimChimRender extends MobRenderer<ChimChimEntity, ChimChimModel<ChimChimEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DotHackMod.MODID,
			"textures/entity/monster/chimchim.png");

	public ChimChimRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ChimChimModel<ChimChimEntity>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(ChimChimEntity entity) {
		return TEXTURE;
	}

}