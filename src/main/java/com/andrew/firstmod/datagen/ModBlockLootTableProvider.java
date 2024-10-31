package com.andrew.firstmod.datagen;

import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return HAS_SHEARS.or(this.hasSilkTouch());
    }
    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }


    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SULFUR_BLOCK.get());
        dropSelf(ModBlocks.PALM_WOOD.get());
        dropSelf(ModBlocks.PALM_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(ModBlocks.PALM_PLANKS.get());
        dropSelf(ModBlocks.PALM_STAIRS.get());
        dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PALM_BUTTON.get());
        dropSelf(ModBlocks.PALM_FENCE.get());
        dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        dropSelf(ModBlocks.PALM_TRAPDOOR.get());
        dropSelf(ModBlocks.DRY_PALM_LEAVES_BLOCK.get());
        dropSelf(ModBlocks.DRY_PALM_LEAVES_CARPET.get());
        dropSelf(ModBlocks.PALM_SAPLING.get());
        add(ModBlocks.POTTED_PALM_SAPLING.get(), createPotFlowerItemTable(ModBlocks.PALM_SAPLING.get()));

        add(ModBlocks.SULFUR_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SULFUR_ORE.get(), ModItems.SULFUR_SHARD.get(), 1, 3));
        add(ModBlocks.DEEPSLATE_SULFUR_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_SULFUR_ORE.get(), ModItems.SULFUR_SHARD.get(), 1, 3));

        add(ModBlocks.PALM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_SLAB.get()));
        add(ModBlocks.PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALM_DOOR.get()));
        add(ModBlocks.DRY_PALM_LEAVES_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DRY_PALM_LEAVES_SLAB.get()));

        add(ModBlocks.PALM_LEAVES.get(),
                block -> createPalmLeavesDrops(ModBlocks.PALM_LEAVES.get(), ModBlocks.PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }


    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }


    protected LootTable.Builder createPalmLeavesDrops(Block palmLeavesBlock, Block saplingBlock, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createLeavesDrops(palmLeavesBlock, saplingBlock, chances)
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F)).when(this.doesNotHaveShearsOrSilkTouch())
                        .add((this.applyExplosionCondition(palmLeavesBlock, LootItem.lootTableItem(ModItems.COCONUT.get())))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE),
                                        new float[]{0.05F, 0.055555557F, 0.0625F, 0.08333334F, 0.25F}))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
