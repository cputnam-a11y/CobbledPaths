package cobbledpaths.datagen;

import cobbledpaths.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.math.intprovider.IntProvider;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLACKSTONE_PATH, Items.SOUL_SAND);
////         skip blue ice;
        addDrop(ModBlocks.BLUE_ICE_PATH,
                new LootTable.Builder().pool(
                        LootPool.builder()
                                .with(
                                        AlternativeEntry.builder(
                                                ItemEntry.builder(Items.SNOW_BLOCK).conditionally(WITH_SILK_TOUCH),
                                                ItemEntry.builder(Items.SNOWBALL)
                                                        .apply(
                                                                SetCountLootFunction
                                                                        .builder(ConstantLootNumberProvider.create(4))
                                                        ).apply(ExplosionDecayLootFunction.builder())
                                        ).build()
                                )
                )
        );
        addDrop(ModBlocks.CRACKED_BLUE_ICE_PATH,
                new LootTable.Builder().pool(
                        LootPool.builder()
                                .with(
                                        AlternativeEntry.builder(
                                                ItemEntry.builder(Items.SNOW_BLOCK).conditionally(WITH_SILK_TOUCH),
                                                ItemEntry.builder(Items.SNOWBALL)
                                                        .apply(
                                                                SetCountLootFunction
                                                                        .builder(ConstantLootNumberProvider.create(4))
                                                        ).apply(ExplosionDecayLootFunction.builder())
                                        ).build()
                                )
                )
        );
        addDrop(ModBlocks.ICE_PATH,
                new LootTable.Builder().pool(
                        LootPool.builder()
                                .with(
                                        AlternativeEntry.builder(
                                                ItemEntry.builder(Items.SNOW_BLOCK).conditionally(WITH_SILK_TOUCH),
                                                ItemEntry.builder(Items.SNOWBALL)
                                                        .apply(
                                                                SetCountLootFunction
                                                                        .builder(ConstantLootNumberProvider.create(4))
                                                        ).apply(ExplosionDecayLootFunction.builder())
                                        ).build()
                                )
                )
        );
        addDrop(ModBlocks.CRACKED_ICE_PATH,
                new LootTable.Builder().pool(
                        LootPool.builder()
                                .with(
                                        AlternativeEntry.builder(
                                                ItemEntry.builder(Items.SNOW_BLOCK).conditionally(WITH_SILK_TOUCH),
                                                ItemEntry.builder(Items.SNOWBALL)
                                                        .apply(
                                                                SetCountLootFunction
                                                                        .builder(ConstantLootNumberProvider.create(4))
                                                        ).apply(ExplosionDecayLootFunction.builder())
                                        ).build()
                                )
                )
        );
        addDrop(ModBlocks.COBBLED_PATH, Items.DIRT);
        addDrop(ModBlocks.CRACKED_BLACKSTONE_PATH, Items.SOUL_SAND);
        // skip cracked blue ice;
        addDrop(ModBlocks.CRACKED_DEEPSLATE_PATH, Items.DIRT);
        // skip cracked ice path;
        addDrop(ModBlocks.CRACKED_NETHER_BRICK_PATH, Items.SOUL_SAND);
        addDrop(ModBlocks.CRACKED_OBSIDIAN_PATH, Items.END_STONE);
        addDrop(ModBlocks.CRACKED_PURPUR_PATH, Items.END_STONE);
        addDrop(ModBlocks.CRACKED_STONE_PATH, Items.DIRT);
        addDrop(ModBlocks.DEEPSLATE_PATH, Items.DIRT);
        addDrop(ModBlocks.GILDED_BLACKSTONE_PATH, Items.SOUL_SAND);
        // skip ice path;
        addDrop(ModBlocks.MOSSY_COBBLED_PATH, Items.DIRT);
        addDrop(ModBlocks.NETHER_BRICK_PATH, Items.SOUL_SAND);
        addDrop(ModBlocks.OBSIDIAN_PATH, Items.END_STONE);
        addDrop(ModBlocks.PURPUR_PATH, Items.END_STONE);
        addDrop(ModBlocks.RED_NETHER_BRICK_PATH, Items.SOUL_SAND);
        addDrop(ModBlocks.STONE_PATH, Items.DIRT);
    }
}
