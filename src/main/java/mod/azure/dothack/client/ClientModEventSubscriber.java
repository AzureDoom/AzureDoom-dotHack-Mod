package mod.azure.dothack.client;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.client.render.AlkaidRender;
import mod.azure.dothack.client.render.AtoliRender;
import mod.azure.dothack.client.render.AuraRender;
import mod.azure.dothack.client.render.AzureBalmungRender;
import mod.azure.dothack.client.render.AzureKiteRender;
import mod.azure.dothack.client.render.AzureOrcaRender;
import mod.azure.dothack.client.render.BlackroseRender;
import mod.azure.dothack.client.render.BulletsRender;
import mod.azure.dothack.client.render.ChimChimRender;
import mod.azure.dothack.client.render.HelbaRender;
import mod.azure.dothack.client.render.ManaRender;
import mod.azure.dothack.client.render.OvanRender;
import mod.azure.dothack.client.render.SkeithRender;
import mod.azure.dothack.client.render.SoraRender;
import mod.azure.dothack.util.registry.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = DotHackMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BULLETS.get(), BulletsRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MANA.get(), ManaRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.OVAN.get(), OvanRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHIMCHIM.get(), ChimChimRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HELBA.get(), HelbaRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SORA.get(), SoraRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SKEITH.get(), SkeithRender::new);
		

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALKAID.get(), AlkaidRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ATOLI.get(), AtoliRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.AURA.get(), AuraRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.AZUREBALMUNG.get(), AzureBalmungRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.AZUREKITE.get(), AzureKiteRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.AZUREORCA.get(), AzureOrcaRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BLACKROSE.get(), BlackroseRender::new);
	}
}