package cobbledpaths.datagen;

import cobbledpaths.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModItemTags.SLEDGEHAMMER_REPAIR_TAG)
                .add(Items.COPPER_INGOT);
        getOrCreateTagBuilder(ModItemTags.SPADE_REPAIR_TAG)
                .add(Items.COPPER_INGOT);
        getOrCreateTagBuilder(ModItemTags.SPADE_COMPATIBLE_TAG)
                .addOptionalTag(
                        ItemTags.DIRT
                ).add(
                        Items.SOUL_SAND,
                        Items.SOUL_SOIL,
                        Items.END_STONE,
                        Items.GRAVEL,
                        Items.SNOW_BLOCK
                );
    }
}
