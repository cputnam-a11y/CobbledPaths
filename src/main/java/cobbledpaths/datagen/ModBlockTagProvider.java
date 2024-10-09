package cobbledpaths.datagen;

import cobbledpaths.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.SOUL_SPEED_BLOCKS)
                .add(
                        ModBlocks.NETHER_BRICK_PATH,
                        ModBlocks.CRACKED_NETHER_BRICK_PATH,
                        ModBlocks.RED_NETHER_BRICK_PATH,
                        ModBlocks.BLACKSTONE_PATH,
                        ModBlocks.CRACKED_BLACKSTONE_PATH,
                        ModBlocks.GILDED_BLACKSTONE_PATH
                );
    }
}
