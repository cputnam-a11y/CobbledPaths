package cobbledpaths.item;

import cobbledpaths.CobbledPaths;
import cobbledpaths.tag.ModItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpadeItem extends Item {
    public SpadeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return stack.getRegistryEntry().isIn(ModItemTags.SPADE_REPAIR_TAG) || super.canRepair(stack, ingredient);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);
        PlayerEntity player = context.getPlayer();
        if (player != null) {
            Hand offhand = oppositeHand(context.getHand());
            ItemStack offHandItem = player.getStackInHand(offhand);
            Block blockToPlace = Block.getBlockFromItem(offHandItem.getItem());
            Item itemToGet = blockState.getBlock().asItem();
            if (blockToPlace != null && itemToGet != null &&
                    Registries.ITEM.getEntry(itemToGet).isIn(ModItemTags.SPADE_COMPATIBLE_TAG) &&
                    offHandItem.getRegistryEntry().isIn(ModItemTags.SPADE_COMPATIBLE_TAG)) {
                world.playSound(player, pos, SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!world.isClient) {
                    BlockState outState = blockToPlace.getDefaultState();
                    world.setBlockState(pos, outState, Block.field_31022);
                    if (!player.isCreative()) {
                        offHandItem.decrement(1);
                        player.giveItemStack(new ItemStack(itemToGet, 1));
                    }
                    context.getStack().damage(1, player, contextEntity -> contextEntity.sendEquipmentBreakStatus(context.getHand() == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND));
                }
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.PASS;
    }
    private static Hand oppositeHand(Hand hand) {
        return switch (hand) {
            case OFF_HAND -> Hand.MAIN_HAND;
            case MAIN_HAND -> Hand.OFF_HAND;
        };
    }
}
