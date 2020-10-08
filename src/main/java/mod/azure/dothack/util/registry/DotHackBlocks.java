package mod.azure.dothack.util.registry;

import mod.azure.dothack.DotHackMod;
import mod.azure.dothack.block.HackChestBlock;
import mod.azure.dothack.block.OhNoMelonBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DotHackBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			DotHackMod.MODID);

	public static final RegistryObject<Block> OHNOMELON = BLOCKS.register("ohnomelon", () -> new OhNoMelonBlock(
			(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance().notSolid())));

	public static final RegistryObject<Block> TRAPCHEST = BLOCKS.register("trapchest",
			() -> new HackChestBlock(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance()));

	public static final RegistryObject<Block> NORMALCHEST = BLOCKS.register("normalchest",
			() -> new HackChestBlock(AbstractBlock.Properties.create(Material.PLANTS).zeroHardnessAndResistance()));
}