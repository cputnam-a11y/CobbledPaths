package cobbledpaths.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static cobbledpaths.CobbledPaths.MOD_ID;

public class ModItemTags {
    public static final TagKey<Item> SPADE_COMPATIBLE_TAG =
            TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "spade_compatible"));
    public static final TagKey<Item> SPADE_REPAIR_TAG =
            TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "spade_repair"));
    public static final TagKey<Item> SLEDGEHAMMER_REPAIR_TAG =
            TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, "sledgehammer_repair"));
    public static void init() {

    }
}
