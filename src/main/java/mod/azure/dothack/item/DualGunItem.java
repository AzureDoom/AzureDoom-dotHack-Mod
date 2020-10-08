package mod.azure.dothack.item;

import java.util.function.Predicate;

import mod.azure.dothack.entity.projectiles.BulletEntity;
import mod.azure.dothack.util.DotHackTabs;
import mod.azure.dothack.util.registry.DotHackItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DualGunItem extends ShootableItem implements IVanishable {

	public DualGunItem() {
		super(new Item.Properties().group(DotHackTabs.GunsItemGroup).maxStackSize(1).maxDamage(1000));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return ItemTier.IRON.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public void onUse(World worldIn, LivingEntity entityLiving, ItemStack stack, int count) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			boolean flag = playerentity.abilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerentity.findAmmo(stack);

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DotHackItems.BULLET.get());
				}

				boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof BulletAmmo
						&& ((BulletAmmo) itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
				if (!worldIn.isRemote) {
					BulletAmmo arrowitem = (BulletAmmo) (itemstack.getItem() instanceof BulletAmmo ? itemstack.getItem()
							: DotHackItems.BULLET.get());
					BulletEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
					abstractarrowentity = customeArrow(abstractarrowentity);
					abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch,
							playerentity.rotationYaw, 0.0F, 1 * 3.0F, 1.0F);

					abstractarrowentity.hasNoGravity();

					stack.damageItem(1, playerentity, (p_220009_1_) -> {
						p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
					});
					if (flag1 || playerentity.abilities.isCreativeMode
							&& (itemstack.getItem() == DotHackItems.BULLET.get()
									|| itemstack.getItem() == DotHackItems.BULLET.get())) {
						abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
					worldIn.addEntity(abstractarrowentity);
				}
				worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
						playerentity.getPosZ(), SoundEvents.BLOCK_ANVIL_HIT, SoundCategory.PLAYERS, 1.0F,
						1.0F / (random.nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
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

		if (!playerIn.abilities.isCreativeMode && !flag) {
			return ActionResult.resultFail(itemstack);
		} else {
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(itemstack);
		}
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return getAmmoPredicate();
	}

	@Override
	public Predicate<ItemStack> getAmmoPredicate() {
		return itemStack -> itemStack.getItem() instanceof BulletAmmo;
	}

	public BulletEntity customeArrow(BulletEntity arrow) {
		return arrow;
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}

}