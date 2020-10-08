package mod.azure.dothack.item;

import mod.azure.dothack.util.DotHackTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class DothackSword extends SwordItem {

	public DothackSword(int attackDamageIn) {
		super(ItemTier.IRON, attackDamageIn, -2.4F,
				new Item.Properties().group(DotHackTabs.SwordItemGroup).maxStackSize(1));
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemTier.IRON.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

}