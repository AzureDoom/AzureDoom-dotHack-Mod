package mod.azure.dothack.util;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.entity.AlkaidEntity;
import mod.azure.dothack.entity.AtoliEntity;
import mod.azure.dothack.entity.AuraEntity;
import mod.azure.dothack.entity.AzureBalmungEntity;
import mod.azure.dothack.entity.AzureKiteEntity;
import mod.azure.dothack.entity.AzureOrcaEntity;
import mod.azure.dothack.entity.BlackroseEntity;
import mod.azure.dothack.entity.ChimChimEntity;
import mod.azure.dothack.entity.HelbaEntity;
import mod.azure.dothack.entity.OvanEntity;
import mod.azure.dothack.entity.SkeithEntity;
import mod.azure.dothack.entity.SoraEntity;
import mod.azure.dothack.item.BulletAmmo;
import mod.azure.dothack.item.ManaItem;
import mod.azure.dothack.util.registry.DotHackItems;
import mod.azure.dothack.util.registry.ModEntitySpawn;
import mod.azure.dothack.util.registry.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = DotHackMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		@SuppressWarnings("unused")
		final IForgeRegistry<Item> registry = event.getRegistry();
		((BulletAmmo) (DotHackItems.BULLET.get())).setItemReference(DotHackItems.BULLET);
		((ManaItem) (DotHackItems.MANA.get())).setItemReference(DotHackItems.MANA);
	}

	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(ModEntityTypes.OVAN.get(), ModEntityTypes.CHIMCHIM.get());
		ModEntitySpawn.addSpawnEntries();
		ModEntitySpawn.EntitySpawnPlacementRegistry();
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void imstuff(final RegistryEvent.Register<EntityType<?>> event) {
		GlobalEntityTypeAttributes.put(ModEntityTypes.OVAN.get(), OvanEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.CHIMCHIM.get(), ChimChimEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.HELBA.get(), HelbaEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.SORA.get(), SoraEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.SKEITH.get(), SkeithEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ALKAID.get(), AlkaidEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.ATOLI.get(), AtoliEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.AURA.get(), AuraEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.AZUREBALMUNG.get(), AzureBalmungEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.AZUREKITE.get(), AzureKiteEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.AZUREORCA.get(), AzureOrcaEntity.func_234200_m_().create());
		GlobalEntityTypeAttributes.put(ModEntityTypes.BLACKROSE.get(), BlackroseEntity.func_234200_m_().create());
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(DotHackMod.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}

}