package cobbledpaths.item;

import cobbledpaths.CobbledPaths;
import cobbledpaths.block.BetterPathBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class SledgeHammerItem extends Item {
    public final Map<Block, Block> transforms = new HashMap<>();

    public SledgeHammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return stack.getRegistryEntry().isIn(CobbledPaths.SLEDGEHAMMER_REPAIR_TAG) || super.canRepair(stack, ingredient);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        /*
        * Level level = context.level
        BlockPos blockPos = context.clickedPos
        BlockState blockState = level.getBlockState(blockPos)
        * */
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        if (context.getSide() == Direction.DOWN)
            return ActionResult.PASS;
        PlayerEntity player = context.getPlayer();
        Block outBlock = transforms.get(state.getBlock());
        if (outBlock != null) {
            BlockState outState = outBlock.getDefaultState();
            world.playSound(player, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!world.isClient) {
                if (outBlock instanceof BetterPathBlock) {
                    outState = BetterPathBlock.updateBlockState(outState, world, pos);
                }
                world.setBlockState(pos, outState, Block.field_31022);
                if (player != null) {
                    context.getStack().damage(1, player, (contextEntity) -> {
                        contextEntity.sendEquipmentBreakStatus(context.getHand() == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                    });
                }
            }
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
}
