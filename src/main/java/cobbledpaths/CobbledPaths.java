package cobbledpaths;

import cobbledpaths.block.BetterPathBlock;
import cobbledpaths.block.ModBlocks;
import cobbledpaths.item.ModItems;
import cobbledpaths.item.SettItem;
import cobbledpaths.item.SledgeHammerItem;
import cobbledpaths.item.SpadeItem;
import cobbledpaths.itemgroup.ModItemGroups;
import cobbledpaths.tag.ModItemTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
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
import net.minecraft.server.network.ServerPlayerEntity;
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
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final UUID STICKY_SPEED_UUID = UUID.fromString("51c53134-f501-4d3b-897e-cc2af5b3bd26");

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModItemGroups.init();
        ModItemTags.init();
    }
    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}