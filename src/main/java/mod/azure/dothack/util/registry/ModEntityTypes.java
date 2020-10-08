package mod.azure.dothack.util.registry;

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
import mod.azure.dothack.entity.projectiles.BulletEntity;
import mod.azure.dothack.entity.projectiles.ManaEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			DotHackMod.MODID);

	public static final RegistryObject<EntityType<BulletEntity>> BULLETS = ENTITY_TYPES.register("bullets",
			() -> EntityType.Builder.<BulletEntity>create(BulletEntity::new, EntityClassification.MISC).size(0.5F, 0.5F)
					.build(new ResourceLocation(DotHackMod.MODID, "bullets").toString()));

	public static final RegistryObject<EntityType<ManaEntity>> MANA = ENTITY_TYPES.register("mana",
			() -> EntityType.Builder.<ManaEntity>create(ManaEntity::new, EntityClassification.MISC).size(1.0F, 1.0F)
					.build(new ResourceLocation(DotHackMod.MODID, "mana").toString()));

	public static final RegistryObject<EntityType<OvanEntity>> OVAN = ENTITY_TYPES.register("ovan",
			() -> EntityType.Builder.create(OvanEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "ovan").toString()));

	public static final RegistryObject<EntityType<ChimChimEntity>> CHIMCHIM = ENTITY_TYPES.register("chimchim",
			() -> EntityType.Builder.create(ChimChimEntity::new, EntityClassification.MONSTER).size(0.6f, 1.0F)
					.build(new ResourceLocation(DotHackMod.MODID, "chimchim").toString()));

	public static final RegistryObject<EntityType<HelbaEntity>> HELBA = ENTITY_TYPES.register("helba",
			() -> EntityType.Builder.create(HelbaEntity::new, EntityClassification.MONSTER ).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "helba").toString()));

	public static final RegistryObject<EntityType<SoraEntity>> SORA = ENTITY_TYPES.register("sora",
			() -> EntityType.Builder.create(SoraEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "sora").toString()));

	public static final RegistryObject<EntityType<SkeithEntity>> SKEITH = ENTITY_TYPES.register("skeith",
			() -> EntityType.Builder.create(SkeithEntity::new, EntityClassification.MONSTER).size(3.0f, 6.5F)
					.build(new ResourceLocation(DotHackMod.MODID, "skeith").toString()));

	public static final RegistryObject<EntityType<AlkaidEntity>> ALKAID = ENTITY_TYPES.register("alkaid",
			() -> EntityType.Builder.create(AlkaidEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "alkaid").toString()));

	public static final RegistryObject<EntityType<AtoliEntity>> ATOLI = ENTITY_TYPES.register("atoli",
			() -> EntityType.Builder.create(AtoliEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "atoli").toString()));

	public static final RegistryObject<EntityType<AuraEntity>> AURA = ENTITY_TYPES.register("aura",
			() -> EntityType.Builder.create(AuraEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "aura").toString()));

	public static final RegistryObject<EntityType<AzureBalmungEntity>> AZUREBALMUNG = ENTITY_TYPES.register("azurebalmung",
			() -> EntityType.Builder.create(AzureBalmungEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "azurebalmung").toString()));

	public static final RegistryObject<EntityType<AzureKiteEntity>> AZUREKITE = ENTITY_TYPES.register("azurekite",
			() -> EntityType.Builder.create(AzureKiteEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "azurekite").toString()));

	public static final RegistryObject<EntityType<AzureOrcaEntity>> AZUREORCA = ENTITY_TYPES.register("azureorca",
			() -> EntityType.Builder.create(AzureOrcaEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "azureorca").toString()));

	public static final RegistryObject<EntityType<BlackroseEntity>> BLACKROSE = ENTITY_TYPES.register("blackrose",
			() -> EntityType.Builder.create(BlackroseEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.build(new ResourceLocation(DotHackMod.MODID, "blackrose").toString()));

}