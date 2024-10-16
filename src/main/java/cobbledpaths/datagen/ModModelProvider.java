package cobbledpaths.datagen;

import cobbledpaths.block.ModBlocks;
import cobbledpaths.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static cobbledpaths.CobbledPaths.id;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.COBBLED_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.MOSSY_COBBLED_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.STONE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_STONE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.DEEPSLATE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_DEEPSLATE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.ICE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_ICE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.BLUE_ICE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_BLUE_ICE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.NETHER_BRICK_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_NETHER_BRICK_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.RED_NETHER_BRICK_PATH, "red_nether_brick_path_1");
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.BLACKSTONE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_BLACKSTONE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.GILDED_BLACKSTONE_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.OBSIDIAN_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_OBSIDIAN_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.PURPUR_PATH);
        registerSimpleBlockItem(blockStateModelGenerator, ModBlocks.CRACKED_PURPUR_PATH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        registerGeneratedItem(itemModelGenerator, ModItems.MOSS_BALL);
        registerGeneratedItem(itemModelGenerator, ModItems.SPADE);
        registerGeneratedItem(itemModelGenerator, ModItems.SLEDGEHAMMER);

        registerGeneratedItem(itemModelGenerator, ModItems.COBBLE);
        registerGeneratedItem(itemModelGenerator, ModItems.STONE_SETT);
        registerGeneratedItem(itemModelGenerator, ModItems.DEEPSLATE_SETT);

        registerGeneratedItem(itemModelGenerator, ModItems.ICE_SETT);
        registerGeneratedItem(itemModelGenerator, ModItems.BLUE_ICE_SETT);

        registerGeneratedItem(itemModelGenerator, ModItems.NETHER_BRICK_SETT);
        registerGeneratedItem(itemModelGenerator, ModItems.BLACKSTONE_SETT);

        registerGeneratedItem(itemModelGenerator, ModItems.OBSIDIAN_SETT);
        registerGeneratedItem(itemModelGenerator, ModItems.PURPUR_SETT);
    }
    @SuppressWarnings("deprecation")
    private static void registerSimpleBlockItem(BlockStateModelGenerator generator, Block block) {
        Identifier parentIdentifier = block.getRegistryEntry().registryKey().getValue();
        generator.registerParentedItemModel(block, new Identifier(parentIdentifier.getNamespace(), "block/" + parentIdentifier.getPath()));
    }
    @SuppressWarnings("SameParameterValue")
    private static void registerSimpleBlockItem(BlockStateModelGenerator generator, Block block, String blockModel) {
        generator.registerParentedItemModel(block, id("block/" + blockModel));
    }
    private static void registerGeneratedItem(ItemModelGenerator generator, Item item) {
        generator.register(item, Models.GENERATED);
    }
}
