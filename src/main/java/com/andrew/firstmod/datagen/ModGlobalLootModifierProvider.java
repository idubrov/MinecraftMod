package com.andrew.firstmod.datagen;


import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, FirstMod.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("rice_seeds_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ModItems.RICE_SEEDS.get()));

        this.add("rice_seeds_from_shipwreck",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build()
                }, ModItems.RICE_SEEDS.get()));

        this.add("electric_horse_armour_from_simple_dungeons",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon")).build()
                }, ModItems.ELECTRIC_HORSE_ARMOR.get()));

        this.add("electric_horse_armour_from_abandoned_mineshaft",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build()
                }, ModItems.ELECTRIC_HORSE_ARMOR.get()));

        this.add("teleportation_device_from_stronghold_crossing",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_crossing")).build()
                }, ModItems.TELEPORTATION_DEVICE.get()));

        this.add("teleportation_stone_from_stronghold_crossing",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_crossing")).build(),
                }, ModBlocks.TELEPORTATION_STONE.asItem()));

    }
}
