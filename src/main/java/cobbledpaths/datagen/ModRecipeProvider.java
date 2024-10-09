package cobbledpaths.datagen;

import cobbledpaths.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.BLACKSTONE), RecipeCategory.MISC, ModItems.BLACKSTONE_SETT, 16)
                .criterion("has_blackstone", conditionsFromItem(Items.BLACKSTONE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.STONE), RecipeCategory.MISC, ModItems.STONE_SETT, 16)
                .criterion("has_stone", conditionsFromItem(Items.STONE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.BLUE_ICE), RecipeCategory.MISC, ModItems.BLUE_ICE_SETT, 16)
                .criterion("has_blue_ice", conditionsFromItem(Items.BLUE_ICE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.COBBLESTONE), RecipeCategory.MISC, ModItems.COBBLE, 16)
                .criterion("has_cobblestone", conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.DEEPSLATE), RecipeCategory.MISC, ModItems.DEEPSLATE_SETT, 16)
                .criterion("has_deepslate", conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.ICE), RecipeCategory.MISC, ModItems.ICE_SETT, 16)
                .criterion("has_ice", conditionsFromItem(Items.ICE))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.MOSS_BLOCK), RecipeCategory.MISC, ModItems.MOSS_BALL, 16)
                .criterion("has_moss_block", conditionsFromItem(Items.MOSS_BLOCK))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.NETHER_BRICK), RecipeCategory.MISC, ModItems.NETHER_BRICK_SETT, 16)
                .criterion("has_nether_brick", conditionsFromItem(Items.NETHER_BRICK))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.OBSIDIAN), RecipeCategory.MISC, ModItems.OBSIDIAN_SETT, 16)
                .criterion("has_obsidian", conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Items.PURPUR_BLOCK), RecipeCategory.MISC, ModItems.PURPUR_SETT, 16)
                .criterion("has_purpur_block", conditionsFromItem(Items.PURPUR_BLOCK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SPADE)
                .pattern(" CC")
                .pattern(" SC")
                .pattern("S  ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SLEDGEHAMMER)
                .pattern(" CS")
                .pattern(" SC")
                .pattern("S  ")
                .input('C', Items.COPPER_INGOT)
                .input('S', Items.STICK)
                .criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
                .criterion("has_stick", conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
}
