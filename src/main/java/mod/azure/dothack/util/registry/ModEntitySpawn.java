package mod.azure.dothack.util.registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;

public class ModEntitySpawn {

	@SuppressWarnings("deprecation")
	public static void addSpawnEntries() {
		for (Biome biome : WorldGenRegistries.BIOME) {
			if (biome.getCategory().equals(Biome.Category.PLAINS)) {
				addMobSpawnToBiome(biome, EntityClassification.MONSTER,
						new MobSpawnInfo.Spawners(ModEntityTypes.OVAN.get(), 12, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.CHIMCHIM.get(), 12, 2, 4),
						new MobSpawnInfo.Spawners(ModEntityTypes.HELBA.get(), 12, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.SKEITH.get(), 12, 1, 1),
						new MobSpawnInfo.Spawners(ModEntityTypes.SORA.get(), 12, 1, 1));
			}
		}
	}

	public static void addMobSpawnToBiome(Biome biome, EntityClassification classification,
			MobSpawnInfo.Spawners... spawnInfos) {
		convertImmutableSpawners(biome);
		List<MobSpawnInfo.Spawners> spawnersList = new ArrayList<>(
				biome.getMobSpawnInfo().spawners.get(classification));
		spawnersList.addAll(Arrays.asList(spawnInfos));
		biome.getMobSpawnInfo().spawners.put(classification, spawnersList);
	}

	private static void convertImmutableSpawners(Biome biome) {
		if (biome.getMobSpawnInfo().spawners instanceof ImmutableMap) {
			biome.getMobSpawnInfo().spawners = new HashMap<>(biome.getMobSpawnInfo().spawners);
		}
	}

	public static void EntitySpawnPlacementRegistry() {
		EntitySpawnPlacementRegistry.register(ModEntityTypes.OVAN.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.CHIMCHIM.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.HELBA.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SORA.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
		EntitySpawnPlacementRegistry.register(ModEntityTypes.SKEITH.get(),
				EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}
}