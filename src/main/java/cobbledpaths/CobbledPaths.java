package cobbledpaths;

import cobbledpaths.block.BetterPathBlock;
import cobbledpaths.item.SettItem;
import cobbledpaths.item.SledgeHammerItem;
import cobbledpaths.item.SpadeItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.function.Supplier;

public class CobbledPaths implements ModInitializer {
	public static final String MOD_ID = "cobbledpaths";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TagKey<Item> SPADE_COMPATIBLE_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "spade_compatible"));
	public static final TagKey<Item> SPADE_REPAIR_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "spade_repair"));
	public static final TagKey<Item> SLEDGEHAMMER_REPAIR_TAG = TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "sledgehammer_repair"));

	public static final UUID STICKY_SPEED_UUID = UUID.fromString("51c53134-f501-4d3b-897e-cc2af5b3bd26");

	public static final AbstractBlock.Settings COBBLED_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).sounds(BlockSoundGroup.GRASS).strength(0.70f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings STONE_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.STONE).strength(0.70f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings DEEPSLATE_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).sounds(BlockSoundGroup.STONE).strength(0.75f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings ICE_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).sounds(BlockSoundGroup.GLASS).strength(0.50f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings BLUE_ICE_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.PALE_PURPLE).sounds(BlockSoundGroup.GLASS).strength(0.50f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings NETHER_BRICK_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).strength(0.70f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings BLACKSTONE_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).strength(0.75f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings OBSIDIAN_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).strength(1.00f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);
	public static final AbstractBlock.Settings PURPUR_PROPERTIES = AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).strength(0.75f)
			.blockVision(CobbledPaths::always).suffocates(CobbledPaths::always);

	public static final BetterPathBlock COBBLED_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cobbled_path"), new BetterPathBlock(COBBLED_PROPERTIES, () -> Blocks.DIRT, 1.15F));
	public static final BetterPathBlock MOSSY_COBBLED_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "mossy_cobbled_path"), new BetterPathBlock(COBBLED_PROPERTIES, () -> Blocks.DIRT, 1.15F));

	public static final BetterPathBlock STONE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "stone_path"), new BetterPathBlock(STONE_PROPERTIES, () -> Blocks.DIRT, 1.30F));
	public static final BetterPathBlock CRACKED_STONE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_stone_path"), new BetterPathBlock(STONE_PROPERTIES, () -> Blocks.DIRT, 1.30F));

	public static final BetterPathBlock DEEPSLATE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "deepslate_path"), new BetterPathBlock(DEEPSLATE_PROPERTIES, () -> Blocks.DIRT, 1.45F));
	public static final BetterPathBlock CRACKED_DEEPSLATE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_deepslate_path"), new BetterPathBlock(DEEPSLATE_PROPERTIES, () -> Blocks.DIRT, 1.45F));

	public static final BetterPathBlock ICE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ice_path"), new BetterPathBlock(ICE_PROPERTIES, () -> Blocks.SNOW_BLOCK, 1.35F));
	public static final BetterPathBlock CRACKED_ICE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_ice_path"), new BetterPathBlock(ICE_PROPERTIES, () -> Blocks.SNOW_BLOCK, 1.35F));

	public static final BetterPathBlock BLUE_ICE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "blue_ice_path"), new BetterPathBlock(BLUE_ICE_PROPERTIES, () -> Blocks.SNOW_BLOCK, 1.55F));
	public static final BetterPathBlock CRACKED_BLUE_ICE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_blue_ice_path"), new BetterPathBlock(BLUE_ICE_PROPERTIES, () -> Blocks.SNOW_BLOCK, 1.55F));

	public static final BetterPathBlock NETHER_BRICK_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "nether_brick_path"), new BetterPathBlock(NETHER_BRICK_PROPERTIES, () -> Blocks.SOUL_SAND, 1.10F));
	public static final BetterPathBlock CRACKED_NETHER_BRICK_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_nether_brick_path"), new BetterPathBlock(NETHER_BRICK_PROPERTIES, () -> Blocks.SOUL_SAND, 1.10F));
	public static final BetterPathBlock RED_NETHER_BRICK_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "red_nether_brick_path"), new BetterPathBlock(NETHER_BRICK_PROPERTIES, () -> Blocks.SOUL_SAND, 1.10F));

	public static final BetterPathBlock BLACKSTONE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "blackstone_path"), new BetterPathBlock(BLACKSTONE_PROPERTIES, () -> Blocks.SOUL_SAND, 1.50F));
	public static final BetterPathBlock CRACKED_BLACKSTONE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_blackstone_path"), new BetterPathBlock(BLACKSTONE_PROPERTIES, () -> Blocks.SOUL_SAND, 1.50F));
	public static final BetterPathBlock GILDED_BLACKSTONE_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "gilded_blackstone_path"), new BetterPathBlock(BLACKSTONE_PROPERTIES, () -> Blocks.SOUL_SAND, 1.50F));

	public static final BetterPathBlock OBSIDIAN_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "obsidian_path"), new BetterPathBlock(OBSIDIAN_PROPERTIES, () -> Blocks.END_STONE, 1.30F));
	public static final BetterPathBlock CRACKED_OBSIDIAN_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_obsidian_path"), new BetterPathBlock(OBSIDIAN_PROPERTIES, () -> Blocks.END_STONE, 1.30F));

	public static final BetterPathBlock PURPUR_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "purpur_path"), new BetterPathBlock(PURPUR_PROPERTIES, () -> Blocks.END_STONE, 1.50F));
	public static final BetterPathBlock CRACKED_PURPUR_PATH = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cracked_purpur_path"), new BetterPathBlock(PURPUR_PROPERTIES, () -> Blocks.END_STONE, 1.50F));


	public static final Item MOSS_BALL = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "moss_ball"), new Item(new Item.Settings()));
	public static final SpadeItem SPADE = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spade"), new SpadeItem(new Item.Settings().maxDamage(1000)));
	public static final SledgeHammerItem SLEDGEHAMMER = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sledgehammer"), new SledgeHammerItem(new Item.Settings().maxDamage(512)));

	public static final SettItem COBBLE = registerSett("cobble", () -> COBBLED_PATH, () -> Blocks.DIRT_PATH);
	public static final SettItem STONE_SETT = registerSett("stone_sett", () -> STONE_PATH, () -> Blocks.DIRT_PATH);
	public static final SettItem DEEPSLATE_SETT = registerSett("deepslate_sett", () -> DEEPSLATE_PATH, () -> Blocks.DIRT_PATH);

	public static final SettItem ICE_SETT = registerSett("ice_sett", () -> ICE_PATH, () -> Blocks.SNOW_BLOCK);
	public static final SettItem BLUE_ICE_SETT = registerSett("blue_ice_sett", () -> BLUE_ICE_PATH, () -> Blocks.SNOW_BLOCK);

	public static final SettItem NETHER_BRICK_SETT = registerSett("nether_brick_sett", () -> NETHER_BRICK_PATH, () -> Blocks.SOUL_SAND, () -> Blocks.SOUL_SOIL);
	public static final SettItem BLACKSTONE_SETT = registerSett("blackstone_sett", () -> BLACKSTONE_PATH, () -> Blocks.SOUL_SAND, () -> Blocks.SOUL_SOIL);

	public static final SettItem OBSIDIAN_SETT = registerSett("obsidian_sett", () -> OBSIDIAN_PATH, () -> Blocks.END_STONE);
	public static final SettItem PURPUR_SETT = registerSett("purpur_sett", () -> PURPUR_PATH, () -> Blocks.END_STONE);


	static void init() {
		register();
	}

	static void register() {
	}

	static boolean always(BlockState state, BlockView getter, BlockPos pos) {
		return true;
	}

	static void setupTransforms() {
		COBBLED_PATH.transforms.put(MOSS_BALL, MOSSY_COBBLED_PATH);
		NETHER_BRICK_PATH.transforms.put(Items.NETHER_WART, RED_NETHER_BRICK_PATH);
		BLACKSTONE_PATH.transforms.put(Items.GOLD_NUGGET, GILDED_BLACKSTONE_PATH);

		SLEDGEHAMMER.transforms.put(STONE_PATH, CRACKED_STONE_PATH);
		SLEDGEHAMMER.transforms.put(DEEPSLATE_PATH, CRACKED_DEEPSLATE_PATH);
		SLEDGEHAMMER.transforms.put(ICE_PATH, CRACKED_ICE_PATH);
		SLEDGEHAMMER.transforms.put(BLUE_ICE_PATH, CRACKED_BLUE_ICE_PATH);
		SLEDGEHAMMER.transforms.put(NETHER_BRICK_PATH, CRACKED_NETHER_BRICK_PATH);
		SLEDGEHAMMER.transforms.put(BLACKSTONE_PATH, CRACKED_BLACKSTONE_PATH);
		SLEDGEHAMMER.transforms.put(OBSIDIAN_PATH, CRACKED_OBSIDIAN_PATH);
		SLEDGEHAMMER.transforms.put(PURPUR_PATH, CRACKED_PURPUR_PATH);
	}

	@SafeVarargs
    static <T extends BetterPathBlock> SettItem registerSett(String name, Supplier<T> path, Supplier<? extends Block>... sources) {
		SettItem item = new SettItem(new Item.Settings(), path, sources);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
        return item;
	}
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		setupTransforms();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
				entries.add(COBBLE, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				entries.add(STONE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				entries.add(DEEPSLATE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

				entries.add(ICE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				entries.add(BLUE_ICE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

				entries.add(NETHER_BRICK_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				entries.add(BLACKSTONE_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

				entries.add(OBSIDIAN_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				entries.add(PURPUR_SETT, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);

				entries.add(MOSS_BALL, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
				entries.add(SPADE, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
				entries.add(SLEDGEHAMMER, ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
		});
		LOGGER.info("Hello Fabric world!");
	}
}