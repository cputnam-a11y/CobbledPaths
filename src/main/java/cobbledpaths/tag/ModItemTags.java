package cobbledpaths.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static cobbledpaths.CobbledPaths.id;

public class ModItemTags {
    public static final TagKey<Item> SPADE_COMPATIBLE_TAG =
            TagKey.of(RegistryKeys.ITEM, id("spade_compatible"));
    public static final TagKey<Item> SPADE_REPAIR_TAG =
            TagKey.of(RegistryKeys.ITEM, id("spade_repair"));
    public static final TagKey<Item> SLEDGEHAMMER_REPAIR_TAG =
            TagKey.of(RegistryKeys.ITEM, id("sledgehammer_repair"));
    public static void init() {

    }
}
