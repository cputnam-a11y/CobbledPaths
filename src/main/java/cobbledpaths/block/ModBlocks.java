package cobbledpaths.block;

import cobbledpaths.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

import static cobbledpaths.CobbledPaths.id;

public class ModBlocks {
    // @FORMATTER:OFF
    public static final BetterPathBlock COBBLED_PATH =
            registerCobble(
                "cobbled",
                (s) -> new BetterPathBlock(s, () -> Blocks.DIRT, 1.15F)
            );

    public static final BetterPathBlock MOSSY_COBBLED_PATH =
            registerCobble(
                    "mossy_cobbled",
                    (s) -> new BetterPathBlock(s, () -> Blocks.DIRT, 1.15F)
            );



    public static final BetterPathBlock STONE_PATH =
            registerStone(
                    "stone",
                    (s) -> new BetterPathBlock(s, () -> Blocks.DIRT, 1.30F)
            );

    public static final BetterPathBlock CRACKED_STONE_PATH =
            registerStone(
                    "cracked_stone",
                    (s) -> new BetterPathBlock(s, () -> Blocks.DIRT, 1.30F)
            );



    public static final BetterPathBlock DEEPSLATE_PATH =
            registerDeepslate(
                    "deepslate",
                    (s) -> new BetterPathBlock(s, () -> Blocks.DIRT, 1.45F)
            );

    public static final BetterPathBlock CRACKED_DEEPSLATE_PATH =
            registerDeepslate(
                    "cracked_deepslate",
                    (s) ->  new BetterPathBlock(s, () -> Blocks.DIRT, 1.45F)
            );



    public static final BetterPathBlock ICE_PATH =
            registerIce(
                    "ice",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SNOW_BLOCK, 1.35F)
            );

    public static final BetterPathBlock CRACKED_ICE_PATH =
            registerIce(
                    "cracked_ice",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SNOW_BLOCK, 1.35F)
            );



    public static final BetterPathBlock BLUE_ICE_PATH =
            registerBlueIce(
                    "blue_ice",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SNOW_BLOCK, 1.55F)
            );
    public static final BetterPathBlock CRACKED_BLUE_ICE_PATH =
            registerBlueIce(
                    "cracked_blue_ice",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SNOW_BLOCK, 1.55F)
            );



    public static final BetterPathBlock NETHER_BRICK_PATH =
            registerNetherBrick(
                    "nether_brick",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SOUL_SAND, 1.10F)
            );

    public static final BetterPathBlock CRACKED_NETHER_BRICK_PATH =
            registerNetherBrick(
                    "cracked_nether_brick",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SOUL_SAND, 1.10F)
            );

    public static final BetterPathBlock RED_NETHER_BRICK_PATH =
            registerNetherBrick(
                    "red_nether_brick",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SOUL_SAND, 1.10F)
            );



    public static final BetterPathBlock BLACKSTONE_PATH =
            registerBlackstone(
                    "blackstone",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SOUL_SAND, 1.50F)
            );
    public static final BetterPathBlock CRACKED_BLACKSTONE_PATH =
            registerBlackstone(
                    "cracked_blackstone",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SOUL_SAND, 1.50F)
            );
    public static final BetterPathBlock GILDED_BLACKSTONE_PATH =
            registerBlackstone(
                    "gilded_blackstone",
                    (s) -> new BetterPathBlock(s, () -> Blocks.SOUL_SAND, 1.50F)
            );



    public static final BetterPathBlock OBSIDIAN_PATH =
            registerObsidian(
                    "obsidian",
                    (s) -> new BetterPathBlock(s, () -> Blocks.END_STONE, 1.30F)
            );
    public static final BetterPathBlock CRACKED_OBSIDIAN_PATH =
            registerObsidian(
                    "cracked_obsidian",
                    (s) -> new BetterPathBlock(s, () -> Blocks.END_STONE, 1.30F)
            );



    public static final BetterPathBlock PURPUR_PATH =
            registerPurpur(
                    "purpur",
                    (s) -> new BetterPathBlock(s, () -> Blocks.END_STONE, 1.50F)
            );
    public static final BetterPathBlock CRACKED_PURPUR_PATH =
            registerPurpur(
                    "cracked_purpur",
                    (s) -> new BetterPathBlock(s, () -> Blocks.END_STONE, 1.50F)
            );
    // @FORMATTER:ON

    static void setupTransforms() {
        COBBLED_PATH.transforms.put(ModItems.MOSS_BALL, MOSSY_COBBLED_PATH);
        NETHER_BRICK_PATH.transforms.put(Items.NETHER_WART, RED_NETHER_BRICK_PATH);
        BLACKSTONE_PATH.transforms.put(Items.GOLD_NUGGET, GILDED_BLACKSTONE_PATH);
    }

    public static void init() {
        setupTransforms();
    }

    private static <T extends Block> T registerCobble(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.DIRT_BROWN)
                                .sounds(BlockSoundGroup.GRASS)
                                .strength(0.70f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerStone(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.STONE_GRAY)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .sounds(BlockSoundGroup.STONE)
                                .strength(0.70f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerDeepslate(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.STONE_GRAY)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .sounds(BlockSoundGroup.STONE)
                                .strength(0.75f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerIce(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.PALE_PURPLE)
                                .sounds(BlockSoundGroup.GLASS)
                                .strength(0.50f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerBlueIce(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.PALE_PURPLE)
                                .sounds(BlockSoundGroup.GLASS)
                                .strength(0.50f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerNetherBrick(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.STONE_GRAY)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .strength(0.70f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerBlackstone(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.STONE_GRAY)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .strength(0.75f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerObsidian(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.STONE_GRAY)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .strength(1.00f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerPurpur(String name, Function<AbstractBlock.Settings, T> t) {
        // @FORMATTER:OFF
        return registerPath(
                name,
                t.apply(
                        AbstractBlock
                                .Settings
                                .create()
                                .mapColor(MapColor.STONE_GRAY)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .strength(0.75f)
                                .blockVision(Blocks::always)
                                .suffocates(Blocks::always)
                )
        );
        // @FORMATTER:ON
    }

    private static <T extends Block> T registerPath(String name, T path) {
        return registerBlock(name + "_path", true, path);
    }

    private static <T extends Block> T registerBlock(String name, boolean registerBlockItem, T block) {
        if (registerBlockItem) Registry.register(Registries.ITEM, id(name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, id(name), block);
    }
}
