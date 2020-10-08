package mod.azure.dothack.item;

import java.util.function.Predicate;

import mod.azure.dothack.entity.projectiles.ManaEntity;
import mod.azure.dothack.util.DotHackTabs;
import mod.azure.dothack.util.HackTier;
import mod.azure.dothack.util.registry.DotHackItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

public class MagicItem extends ShootableItem {

	public MagicItem() {
		super(new Item.Properties().group(DotHackTabs.MagicItemGroup).maxStackSize(1));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return HackTier.MAGIC.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			boolean flag = playerentity.abilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerentity.findAmmo(stack);

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DotHackItems.MANA.get());
				}

				boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ManaItem
						&& ((ManaItem) itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
				if (!worldIn.isRemote) {
					ManaItem arrowitem = (ManaItem) (itemstack.getItem() instanceof ManaItem ? itemstack.getItem()
							: DotHackItems.MANA.get());
					ManaEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
					abstractarrowentity = customeArrow(abstractarrowentity);
					abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch,
							playerentity.rotationYaw, 0.0F, 0.5F * 3.0F, 1.0F);
					abstractarrowentity.hasNoGravity();

					stack.damageItem(1, playerentity, (p_220009_1_) -> {
						p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
					});
					if (flag1
							|| playerentity.abilities.isCreativeMode && (itemstack.getItem() == DotHackItems.MANA.get()
									|| itemstack.getItem() == DotHackItems.MANA.get())) {
						abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
					worldIn.addEntity(abstractarrowentity);
				}
				worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
						playerentity.getPosZ(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F,
						1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.5F * 0.5F);
				if (!flag1 && !playerentity.abilities.isCreativeMode) {
					itemstack.shrink(1);
					if (itemstack.isEmpty()) {
						playerentity.inventory.deleteStack(itemstack);
					}
				}
			}
		}
	}

	public static float getArrowVelocity(int charge) {
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

		if (ModList.get().isLoaded("mmorpg")) {
			return ActionResult.resultFail(itemstack);
		} else {
			ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn,
					playerIn, handIn, flag);
			if (ret != null)
				return ret;

			if (!playerIn.abilities.isCreativeMode && !flag) {
				return ActionResult.resultFail(itemstack);
			} else {
				playerIn.setActiveHand(handIn);
				return ActionResult.resultConsume(itemstack);
			}
		}
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return getAmmoPredicate();
	}

	@Override
	public Predicate<ItemStack> getAmmoPredicate() {
		return itemStack -> itemStack.getItem() instanceof ManaItem;
	}

	public ManaEntity customeArrow(ManaEntity arrow) {
		return arrow;
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}

}