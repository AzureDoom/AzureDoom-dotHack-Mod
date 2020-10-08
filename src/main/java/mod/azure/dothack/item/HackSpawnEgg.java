package mod.azure.dothack.item;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import mod.azure.dothack.util.DotHackTabs;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;

public class HackSpawnEgg extends SpawnEggItem {
	private Supplier<? extends EntityType<?>> typeGetter;

	public HackSpawnEgg(Supplier<? extends EntityType<?>> typeIn, int primaryColorIn, int secondaryColorIn) {
		super(null, primaryColorIn, secondaryColorIn,
				new Item.Properties().maxStackSize(1).group(DotHackTabs.EggsItemGroup));
		typeGetter = typeIn;
	}

	@Override
	public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
		return typeGetter.get();
	}

}