package mod.azure.dothack.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.dothack.entity.ai.goal.RangedSteamGunAttackGoal;
import mod.azure.dothack.entity.bases.NPCEntity;
import mod.azure.dothack.entity.projectiles.BulletEntity;
import mod.azure.dothack.item.BulletAmmo;
import mod.azure.dothack.item.SteamGunItem;
import mod.azure.dothack.util.registry.DotHackItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class OvanEntity extends NPCEntity implements IRangedAttackMob {

	private final RangedSteamGunAttackGoal<OvanEntity> aiArrowAttack = new RangedSteamGunAttackGoal<>(this, 1.0D, 20,
			15.0F);
	private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, false) {
		public void resetTask() {
			super.resetTask();
			OvanEntity.this.setAggroed(false);
		}

		public void startExecuting() {
			super.startExecuting();
			OvanEntity.this.setAggroed(true);
		}
	};

	public OvanEntity(EntityType<OvanEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(DotHackItems.STEAMGUNNER18.get()));
		this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(DotHackItems.STEAMGUNNER17.get()));
		this.setCombatTask();
	}

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D)
				.createMutableAttribute(Attributes.MAX_HEALTH, 15.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.1D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	public static boolean spawning(EntityType<OvanEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, BlazeEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, CaveSpiderEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, CreeperEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, DrownedEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ElderGuardianEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EndermanEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EndermiteEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, EvokerEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, GhastEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, GuardianEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, HoglinEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, HuskEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MagmaCubeEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PhantomEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PillagerEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, RavagerEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SilverfishEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SkeletonEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SpiderEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, StrayEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VexEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VindicatorEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WitchEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, WitherSkeletonEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZoglinEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombieVillagerEntity.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ZombifiedPiglinEntity.class, true));
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.74F;
	}

	public void setCombatTask() {
		if (this.world != null && !this.world.isRemote) {
			this.goalSelector.removeGoal(this.aiAttackOnCollide);
			this.goalSelector.removeGoal(this.aiArrowAttack);
			ItemStack itemstack = this
					.getHeldItem(ProjectileHelper.getHandWith(this, DotHackItems.STEAMGUNNER17.get()));
			if (itemstack.getItem() instanceof SteamGunItem) {
				int i = 20;
				if (this.world.getDifficulty() != Difficulty.HARD) {
					i = 40;
				}

				this.aiArrowAttack.setAttackCooldown(i);
				this.goalSelector.addGoal(4, this.aiArrowAttack);
			} else {
				this.goalSelector.addGoal(4, this.aiAttackOnCollide);
			}

		}
	}

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		ItemStack itemstack = this
				.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, DotHackItems.STEAMGUNNER17.get())));
		BulletEntity abstractarrowentity = this.fireArrowa(itemstack, distanceFactor);
		if (this.getHeldItemMainhand().getItem() instanceof SteamGunItem)
			abstractarrowentity = ((SteamGunItem) this.getHeldItemMainhand().getItem())
					.customeArrow(abstractarrowentity);
		double d0 = target.getPosX() - this.getPosX();
		double d1 = target.getPosYHeight(0.3333333333333333D) - abstractarrowentity.getPosY();
		double d2 = target.getPosZ() - this.getPosZ();
		double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
		abstractarrowentity.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F,
				(float) (14 - this.world.getDifficulty().getId() * 4));
		this.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.addEntity(abstractarrowentity);
	}

	protected BulletEntity fireArrowa(ItemStack arrowStack, float distanceFactor) {
		return OvanEntity.fireArrow(this, arrowStack, distanceFactor);
	}

	public static BulletEntity fireArrow(LivingEntity shooter, ItemStack arrowStack, float distanceFactor) {
		BulletAmmo arrowitem = (BulletAmmo) (arrowStack.getItem() instanceof BulletAmmo ? arrowStack.getItem()
				: DotHackItems.BULLET.get());
		BulletEntity abstractarrowentity = arrowitem.createArrow(shooter.world, arrowStack, shooter);
		abstractarrowentity.setEnchantmentEffectsFromEntity(shooter, distanceFactor);

		return abstractarrowentity;
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setCombatTask();
	}

	@Override
	public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
		super.setItemStackToSlot(slotIn, stack);
		if (!this.world.isRemote) {
			this.setCombatTask();
		}
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);
		this.setCombatTask();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * difficultyIn.getClampedAdditionalDifficulty());
		if (this.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
			LocalDate localdate = LocalDate.now();
			int i = localdate.get(ChronoField.DAY_OF_MONTH);
			int j = localdate.get(ChronoField.MONTH_OF_YEAR);
			if (j == 10 && i == 31 && this.rand.nextFloat() < 0.25F) {
				this.setItemStackToSlot(EquipmentSlotType.HEAD,
						new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
				this.inventoryArmorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0.0F;
			}
		}
		return spawnDataIn;
	}

}