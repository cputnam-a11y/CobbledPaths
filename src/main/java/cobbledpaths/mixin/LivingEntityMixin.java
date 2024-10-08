package cobbledpaths.mixin;

import cobbledpaths.CobbledPaths;
import cobbledpaths.block.BetterPathBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    LivingEntityMixin(EntityType<? extends Entity> entityType, World level) {
        super(entityType, level);
    }

    @Shadow
    protected abstract boolean shouldRemoveSoulSpeedBoost(BlockState state);

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract Map<StatusEffect, StatusEffectInstance> getActiveStatusEffects();

    @Inject(method = "baseTick()V", at = @At("HEAD"))
    private void cobbledpaths$baseTick(CallbackInfo ci) {
        BlockState state = this.getWorld().getBlockState(this.getBlockPos());
        if (state.isOf(CobbledPaths.PURPUR_PATH) || state.isOf(CobbledPaths.CRACKED_PURPUR_PATH)) {
            if (!this.getActiveStatusEffects().containsKey(StatusEffects.JUMP_BOOST) || this.getActiveStatusEffects().get(StatusEffects.JUMP_BOOST).getAmplifier() < 2) {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 10, 2, false, false, false));
            }
        }
    }

    @Inject(method = "fall", at = @At("HEAD"))
    private void cobbledpaths$checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos, CallbackInfo ci) {
        if (!this.getWorld().isClient && onGround && this.fallDistance > 0.0F) {
            this.cobbledpaths$removeStickySpeed();
            this.cobbledpaths$checkStickySpeed();
        }
    }

    private void cobbledpaths$removeStickySpeed() {
        EntityAttributeInstance movementSpeed = ((LivingEntity)(Object)this).getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (movementSpeed != null) {
            if (movementSpeed.getModifier(CobbledPaths.STICKY_SPEED_UUID) != null) {
                movementSpeed.removeModifier(CobbledPaths.STICKY_SPEED_UUID);
            }
        }
    }

    private void cobbledpaths$checkStickySpeed() {
        if (!this.getSteppingBlockState().isAir()) {
            if ((Object)this instanceof PlayerEntity player) {
                if (player.getAbilities().flying) {
                    return;
                }
            }
            Block block = this.getWorld().getBlockState(this.getBlockPos()).getBlock();
            if (block instanceof BetterPathBlock betterPathBlock) {
                double modifier = betterPathBlock.getSpeedModifier();
                EntityAttributeInstance movementSpeed = ((LivingEntity)(Object)this).getAttributes().getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                if (movementSpeed == null) {
                    return;
                }
                double completeModifier = movementSpeed.getBaseValue() * (modifier - 1.0F);
                movementSpeed.addTemporaryModifier(new EntityAttributeModifier(CobbledPaths.STICKY_SPEED_UUID, "Path speed boost", completeModifier, EntityAttributeModifier.Operation.ADDITION));
            }
        }
    }

    @Inject(method = "applyMovementEffects", at = @At("TAIL"))
    private void cobbledpaths$$blockChange(BlockPos pos, CallbackInfo ci) {
        if (this.shouldRemoveSoulSpeedBoost(this.getSteppingBlockState())) {
            this.cobbledpaths$removeStickySpeed();
        }
        this.cobbledpaths$checkStickySpeed();
    }
}