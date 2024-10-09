package cobbledpaths;

import cobbledpaths.block.ModBlocks;
import cobbledpaths.item.ModItems;
import cobbledpaths.itemgroup.ModItemGroups;
import cobbledpaths.tag.ModItemTags;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class CobbledPaths implements ModInitializer {
    public static final String MOD_ID = "cobbledpaths";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Identifier STICKY_SPEED_UUID = id("51c53134-f501-4d3b-897e-cc2af5b3bd26");

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModItemGroups.init();
        ModItemTags.init();
    }
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}