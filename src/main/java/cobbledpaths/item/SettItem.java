package cobbledpaths.item;

import cobbledpaths.block.BetterPathBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SettItem extends Item {
    private final Supplier<? extends Block> createdBlock;
    private final List<Supplier<? extends Block>> originalBlocks;

    public SettItem(Settings settings, Supplier<? extends Block> createdBlock, Supplier<? extends Block>... originalBlocks) {
        super(settings);
        this.createdBlock = createdBlock;
        this.originalBlocks = Arrays.asList(originalBlocks);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState blockState = world.getBlockState(pos);
        if (context.getSide() == Direction.DOWN)
            return ActionResult.PASS;
        PlayerEntity player = context.getPlayer();
        if (originalBlocks.stream().anyMatch(block -> blockState.isOf(block.get()))) {
            Block toCreate = createdBlock.get();
            if (toCreate instanceof BetterPathBlock) {
                world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!world.isClient) {
                    BlockState outState = toCreate.getDefaultState();
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, outState));
                    outState = BetterPathBlock.updateBlockState(outState, world, pos);
                    world.setBlockState(pos, outState, Block.field_31022);
                    context.getStack().decrement(1);
                }
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.PASS;
    }
}
