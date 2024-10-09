package cobbledpaths.datagen;

import cobbledpaths.block.ModBlocks;
import cobbledpaths.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // itemgroup translations
        translationBuilder.add("cobbledpaths.itemgroup.cobbledpaths", "Cobbled Paths");
        // item translations
        translationBuilder.add(ModItems.COBBLE, "Cobble");
        translationBuilder.add(ModItems.STONE_SETT, "Stone Sett");
        translationBuilder.add(ModItems.DEEPSLATE_SETT, "Deepslate Sett");
        translationBuilder.add(ModItems.ICE_SETT, "Ice Sett");
        translationBuilder.add(ModItems.BLUE_ICE_SETT, "Blue Ice Sett");
        translationBuilder.add(ModItems.NETHER_BRICK_SETT, "Nether Brick Sett");
        translationBuilder.add(ModItems.BLACKSTONE_SETT, "Blackstone Sett");
        translationBuilder.add(ModItems.OBSIDIAN_SETT, "Obsidian Sett");
        translationBuilder.add(ModItems.PURPUR_SETT, "Purpur Sett");
        translationBuilder.add(ModItems.MOSS_BALL, "Moss Ball");
        translationBuilder.add(ModItems.SLEDGEHAMMER, "Sledgehammer");
        translationBuilder.add(ModItems.SPADE, "Spade");
        // block translations
        translationBuilder.add(ModBlocks.COBBLED_PATH, "Cobbled Path");
        translationBuilder.add(ModBlocks.MOSSY_COBBLED_PATH, "Mossy Cobbled Path");
        translationBuilder.add(ModBlocks.STONE_PATH, "Stone Paved Path");
        translationBuilder.add(ModBlocks.DEEPSLATE_PATH, "Deepslate Paved Path");
        translationBuilder.add(ModBlocks.ICE_PATH, "Ice Paved Path");
        translationBuilder.add(ModBlocks.BLUE_ICE_PATH, "Blue Ice Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_STONE_PATH, "Cracked Stone Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_DEEPSLATE_PATH, "Cracked Deepslate Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_ICE_PATH, "Cracked Ice Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_BLUE_ICE_PATH, "Cracked Blue Ice Paved Path");
        translationBuilder.add(ModBlocks.NETHER_BRICK_PATH, "Nether Brick Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_NETHER_BRICK_PATH, "Cracked Nether Brick Paved Path");
        translationBuilder.add(ModBlocks.RED_NETHER_BRICK_PATH, "Red Nether Brick Paved Path");
        translationBuilder.add(ModBlocks.BLACKSTONE_PATH, "Blackstone Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_BLACKSTONE_PATH, "Cracked Blackstone Paved Path");
        translationBuilder.add(ModBlocks.GILDED_BLACKSTONE_PATH, "Gilt Blackstone Paved Path");
        translationBuilder.add(ModBlocks.OBSIDIAN_PATH, "Obsidian Paved Path");
        translationBuilder.add(ModBlocks.PURPUR_PATH, "Purpur Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_OBSIDIAN_PATH, "Cracked Obsidian Paved Path");
        translationBuilder.add(ModBlocks.CRACKED_PURPUR_PATH, "Cracked Purpur Paved Path");
    }
}
