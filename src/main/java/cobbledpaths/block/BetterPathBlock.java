package cobbledpaths.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirtPathBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BetterPathBlock extends DirtPathBlock {
    public static final BooleanProperty NORTH = Properties.NORTH;
    public static final BooleanProperty SOUTH = Properties.SOUTH;
    public static final BooleanProperty EAST = Properties.EAST;
    public static final BooleanProperty WEST = Properties.WEST;

    final float speedModifier;

    public static BooleanProperty getDirectionProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
            default -> null;
        };
    }

    public final Map<Item, Block> transforms = new HashMap<>();

    final Supplier<Block> original;

    public BetterPathBlock(Settings settings, Supplier<Block> original, float speedModifier) {
        super(settings);
        this.original = original;
        this.speedModifier = speedModifier;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        ItemStack heldItemStack = player.getStackInHand(hand);
        Item heldItem = heldItemStack.getItem();
        Block toTransform = transforms.get(heldItem);
        if (toTransform instanceof BetterPathBlock) {
            BlockState outState = toTransform.getDefaultState();
            outState = updateBlockState(outState, world, pos);
            world.setBlockState(pos, outState, Block.NOTIFY_ALL);
            if (!player.isCreative()) {
                heldItemStack.decrement(1);
            }
            return ActionResult.SUCCESS;
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        if (!this.getDefaultState().canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
            return pushEntitiesUpBeforeBlockChange(this.getDefaultState(), this.original.get().getDefaultState(), ctx.getWorld(), ctx.getBlockPos());
        }
        World blockGetter = ctx.getWorld();
        BlockState stateOut = this.getDefaultState();
        stateOut = updateBlockState(stateOut, blockGetter, ctx.getBlockPos());
        return stateOut;
    }

    public static boolean hasBelow(BlockView blockGetter, BlockPos blockPos) {
        return isFaceFullSquare(blockGetter.getBlockState(blockPos).getSidesShape(blockGetter, blockPos), Direction.UP);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        state = updateBlockState(state, world, pos);
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public static BlockState updateBlockState(BlockState blockState, WorldAccess levelReader, BlockPos blockPos) {
        BlockPos nPos = blockPos.north();
        BlockPos sPos = blockPos.south();
        BlockPos ePos = blockPos.east();
        BlockPos wPos = blockPos.west();
        BlockPos dPos = blockPos.down();
        boolean hasBelow = hasBelow(levelReader, dPos);
        boolean n = levelReader.getBlockState(nPos.down()).getBlock() instanceof DirtPathBlock;
        boolean s = levelReader.getBlockState(sPos.down()).getBlock() instanceof DirtPathBlock;
        boolean e = levelReader.getBlockState(ePos.down()).getBlock() instanceof DirtPathBlock;
        boolean w = levelReader.getBlockState(wPos.down()).getBlock() instanceof DirtPathBlock;
        return blockState.with(NORTH, n && hasBelow).with(SOUTH, s && hasBelow).with(EAST, e && hasBelow).with(WEST, w && hasBelow);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.turnToOriginal(state, world, pos);
    }

    void turnToOriginal(BlockState blockState, World world, BlockPos blockPos) {
        world.setBlockState(blockPos, pushEntitiesUpBeforeBlockChange(blockState, this.original.get().getDefaultState(), world, blockPos));
    }
    public float getSpeedModifier() {
        return this.speedModifier;
    }
}
