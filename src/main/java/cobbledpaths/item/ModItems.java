package cobbledpaths.item;

import cobbledpaths.block.BetterPathBlock;
import cobbledpaths.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

import static cobbledpaths.CobbledPaths.MOD_ID;
public class ModItems {
    public static final Item MOSS_BALL = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moss_ball"), new Item(new Item.Settings()));
    public static final SpadeItem SPADE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spade"), new SpadeItem(new Item.Settings().maxDamage(1000)));
    public static final SledgeHammerItem SLEDGEHAMMER = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sledgehammer"), new SledgeHammerItem(new Item.Settings().maxDamage(512)));

    public static final SettItem COBBLE = registerSett("cobble", () -> ModBlocks.COBBLED_PATH, () -> Blocks.DIRT_PATH);
    public static final SettItem STONE_SETT = registerSett("stone_sett", () -> ModBlocks.STONE_PATH, () -> Blocks.DIRT_PATH);
    public static final SettItem DEEPSLATE_SETT = registerSett("deepslate_sett", () -> ModBlocks.DEEPSLATE_PATH, () -> Blocks.DIRT_PATH);

    public static final SettItem ICE_SETT = registerSett("ice_sett", () -> ModBlocks.ICE_PATH, () -> Blocks.SNOW_BLOCK);
    public static final SettItem BLUE_ICE_SETT = registerSett("blue_ice_sett", () -> ModBlocks.BLUE_ICE_PATH, () -> Blocks.SNOW_BLOCK);

    public static final SettItem NETHER_BRICK_SETT = registerSett("nether_brick_sett", () -> ModBlocks.NETHER_BRICK_PATH, () -> Blocks.SOUL_SAND, () -> Blocks.SOUL_SOIL);
    public static final SettItem BLACKSTONE_SETT = registerSett("blackstone_sett", () -> ModBlocks.BLACKSTONE_PATH, () -> Blocks.SOUL_SAND, () -> Blocks.SOUL_SOIL);

    public static final SettItem OBSIDIAN_SETT = registerSett("obsidian_sett", () -> ModBlocks.OBSIDIAN_PATH, () -> Blocks.END_STONE);
    public static final SettItem PURPUR_SETT = registerSett("purpur_sett", () -> ModBlocks.PURPUR_PATH, () -> Blocks.END_STONE);

    public static void init() {
        setupTransforms();
    }
    @SafeVarargs
    static <T extends BetterPathBlock> SettItem registerSett(String name, Supplier<T> path, Supplier<? extends Block>... sources) {
        SettItem item = new SettItem(new Item.Settings(), path, sources);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
        return item;
    }
    static void setupTransforms() {
        SLEDGEHAMMER.transforms.put(ModBlocks.STONE_PATH, ModBlocks.CRACKED_STONE_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.DEEPSLATE_PATH, ModBlocks.CRACKED_DEEPSLATE_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.ICE_PATH, ModBlocks.CRACKED_ICE_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.BLUE_ICE_PATH, ModBlocks.CRACKED_BLUE_ICE_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.NETHER_BRICK_PATH, ModBlocks.CRACKED_NETHER_BRICK_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.BLACKSTONE_PATH, ModBlocks.CRACKED_BLACKSTONE_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.OBSIDIAN_PATH, ModBlocks.CRACKED_OBSIDIAN_PATH);
        SLEDGEHAMMER.transforms.put(ModBlocks.PURPUR_PATH, ModBlocks.CRACKED_PURPUR_PATH);
    }
}
