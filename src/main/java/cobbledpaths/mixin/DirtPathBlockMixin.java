package cobbledpaths.mixin;

import cobbledpaths.block.BetterPathBlock;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(AbstractBlock.class)
public class DirtPathBlockMixin {
    @Unique
    private static final List<Direction> DIRECTIONS = List.of(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);
    @Inject(method = "onBlockAdded", at = @At("HEAD"))
    private void cobbledpaths$onPlace(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify, CallbackInfo ci) {
        if (state.getBlock() instanceof DirtPathBlock || state.getBlock() instanceof FarmlandBlock) {
            BlockPos abovePos = pos.offset(Direction.UP);
            for (Direction it : DIRECTIONS) {
                BlockPos relativePos = abovePos.offset(it);
                Block block = world.getBlockState(relativePos).getBlock();
                if (block instanceof BetterPathBlock) {
                    world.setBlockState(
                            relativePos,
                            world.getBlockState(relativePos)
                                    .with(
                                            BetterPathBlock.getDirectionProperty(it.getOpposite()),
                                            BetterPathBlock.hasBelow(world, relativePos.offset(Direction.DOWN))
                                    )
                    );
                }
            }
        }
    }
    @Inject(method = "onStateReplaced", at = @At("HEAD"))
    private void cobbledpaths$onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved, CallbackInfo ci) {
        if (state.getBlock() instanceof DirtPathBlock) {
            BlockPos abovePos = pos.offset(Direction.UP);
            for (Direction it : DIRECTIONS) {
                BlockPos relativePos = abovePos.offset(it);
                Block block = world.getBlockState(relativePos).getBlock();
                if (block instanceof BetterPathBlock) {
                    world.setBlockState(
                            relativePos,
                            world.getBlockState(relativePos)
                                    .with(
                                            BetterPathBlock.getDirectionProperty(it.getOpposite()),
                                            false
                                    )
                    );
                }
            }
        }
    }
}
