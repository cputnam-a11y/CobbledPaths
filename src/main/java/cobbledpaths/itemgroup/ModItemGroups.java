package cobbledpaths.itemgroup;

import cobbledpaths.block.BetterPathBlock;
import cobbledpaths.block.ModBlocks;
import cobbledpaths.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import static cobbledpaths.CobbledPaths.id;

public class ModItemGroups {
    public static final ItemGroup MAIN =
            Registry.register(
                    Registries.ITEM_GROUP,
                    id("main"),
                    new ItemGroup
                            .Builder(ItemGroup.Row.TOP, 11)
                            .displayName(Text.translatable("cobbledpaths.itemgroup.cobbledpaths"))
                            .icon(ModItems.BLACKSTONE_SETT::getDefaultStack)
                            .entries(((context, entries) -> {

                                entries.add(ModItems.COBBLE, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                                entries.add(ModItems.STONE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                                entries.add(ModItems.DEEPSLATE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

                                entries.add(ModItems.ICE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                                entries.add(ModItems.BLUE_ICE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

                                entries.add(ModItems.NETHER_BRICK_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                                entries.add(ModItems.BLACKSTONE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

                                entries.add(ModItems.OBSIDIAN_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                                entries.add(ModItems.PURPUR_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

                                entries.add(ModItems.MOSS_BALL, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

                                entries.add(ModBlocks.COBBLED_PATH);
                                entries.add(ModBlocks.MOSSY_COBBLED_PATH);
                                entries.add(ModBlocks.STONE_PATH);
                                entries.add(ModBlocks.CRACKED_STONE_PATH);
                                entries.add(ModBlocks.DEEPSLATE_PATH);
                                entries.add(ModBlocks.CRACKED_DEEPSLATE_PATH);
                                entries.add(ModBlocks.ICE_PATH);
                                entries.add(ModBlocks.CRACKED_ICE_PATH);
                                entries.add(ModBlocks.BLUE_ICE_PATH);
                                entries.add(ModBlocks.CRACKED_BLUE_ICE_PATH);
                                entries.add(ModBlocks.NETHER_BRICK_PATH);
                                entries.add(ModBlocks.CRACKED_NETHER_BRICK_PATH);
                                entries.add(ModBlocks.RED_NETHER_BRICK_PATH);
                                entries.add(ModBlocks.BLACKSTONE_PATH);
                                entries.add(ModBlocks.CRACKED_BLACKSTONE_PATH);
                                entries.add(ModBlocks.GILDED_BLACKSTONE_PATH);
                                entries.add(ModBlocks.OBSIDIAN_PATH);
                                entries.add(ModBlocks.CRACKED_OBSIDIAN_PATH);
                                entries.add(ModBlocks.PURPUR_PATH);
                                entries.add(ModBlocks.CRACKED_PURPUR_PATH);

                                entries.add(ModItems.SPADE, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                                entries.add(ModItems.SLEDGEHAMMER, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

                            }))
                            .build()
            );
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModItems.COBBLE, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            entries.add(ModItems.STONE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            entries.add(ModItems.DEEPSLATE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

            entries.add(ModItems.ICE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            entries.add(ModItems.BLUE_ICE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

            entries.add(ModItems.NETHER_BRICK_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            entries.add(ModItems.BLACKSTONE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

            entries.add(ModItems.OBSIDIAN_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            entries.add(ModItems.PURPUR_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

            entries.add(ModItems.MOSS_BALL, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.COBBLED_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.MOSSY_COBBLED_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.STONE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_STONE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.DEEPSLATE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_DEEPSLATE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.ICE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_ICE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.BLUE_ICE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_BLUE_ICE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.NETHER_BRICK_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_NETHER_BRICK_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.RED_NETHER_BRICK_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.BLACKSTONE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_BLACKSTONE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.GILDED_BLACKSTONE_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.OBSIDIAN_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_OBSIDIAN_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.PURPUR_PATH);
            entries.addAfter(Blocks.DIRT_PATH, ModBlocks.CRACKED_PURPUR_PATH);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.SPADE, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            entries.add(ModItems.SLEDGEHAMMER, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
        });
    }
}
