package com.andrew.firstmod.util;

import com.andrew.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_ELECTRIC_TOOL = createTag("needs_electric_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELECTRIC_TOOL = createTag("incorrect_for_electric_tool");

        public static final TagKey<Block> SULFUR_BLOCKS = createTag("sulfur");
        public static final TagKey<Block> SULFUR_ORES_BLOCKS = createTag("sulfur_ores");
        public static final TagKey<Block> PALM_LOGS_BLOCKS = createTag("palm_logs");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SULFUR_ITEMS = createTag("sulfur");
        public static final TagKey<Item> SULFUR_ORES_ITEMS = createTag("sulfur_ores");
        public static final TagKey<Item> PALM_LOGS_ITEMS = createTag("palm_logs");
        public static final TagKey<Item> HAMMERS_ITEMS = createTag("hammers");
        public static final TagKey<Item> BATTERY_REPAIR = createTag("battery_repair");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }
}
