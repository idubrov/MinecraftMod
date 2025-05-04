package com.andrew.firstmod.event;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.block.custom.SulfurOreBlock;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.item.custom.*;
import com.andrew.firstmod.potion.ModPotions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EventBusSubscriber(modid = FirstMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();

        if (stack.getItem() == ModItems.BATTERY.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.battery.tooltip"));
        } else if (stack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof SulfurOreBlock) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.sulfur_ore.tooltip"));
        } else if (stack.getItem() == ModItems.BANANA.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.banana.tooltip.line1"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.banana.tooltip.line2"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.banana.tooltip.line3"));
        } else if (stack.getItem() == ModItems.MILK_SHAKE.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line1"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line2"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line3"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line4"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line5"));
        } else if (stack.getItem() == ModItems.FRUIT_SALAD.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line1"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line2"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line3"));
        } else if (stack.getItem() == ModItems.MAKI_SUSHI.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.sushi.tooltip.line1"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.sushi.tooltip.line2"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.maki_sushi.tooltip.line3"));
        } else if (stack.getItem() == ModItems.NIGIRI_SUSHI.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.sushi.tooltip.line1"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.sushi.tooltip.line2"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.nigiri_sushi.tooltip.line3"));
        } else if (stack.getItem() == ModItems.ELECTRIC_HELMET.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric_helmet.tooltip.line1"));
        } else if (stack.getItem() == ModItems.ELECTRIC_CHESTPLATE.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric_chestplate.tooltip.line1"));
        } else if (stack.getItem() == ModItems.ELECTRIC_LEGGINGS.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric_leggings.tooltip.line1"));
        } else if (stack.getItem() == ModItems.ELECTRIC_BOOTS.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric_boots.tooltip.line1"));
        } else if (stack.getItem() == ModItems.ELECTRIC_HORSE_ARMOR.get()) {
            event.getToolTip().add(Component.translatable("tooltip.firstmod.empty_line"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
            event.getToolTip().add(Component.translatable("tooltip.firstmod.electric_horse_armor.tooltip.line1"));
        }
    }


    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onElectricToolUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();
        Item mainItem = mainHandItem.getItem();

        boolean isElectricTool =
                mainItem instanceof ElectricHoeItem ||
                        mainItem instanceof ElectricShovelItem ||
                        mainItem instanceof ElectricAxeItem ||
                        mainItem instanceof ElectricPickaxeItem;

        if (isElectricTool && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : ElectricTool.getBlocksToBeDestroyed(2, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }


    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.BATTERY.get(), ModPotions.ELECTRIFIED_POTION);
    }


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(ModItems.RICE_SEEDS.get(), 2), 8, 4, 0.5f
            ));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(ModItems.RICE_SEEDS.get(), 2), 8, 4, 0.5f
        ));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 3),
                new ItemStack(ModItems.BANANA.get(), 2), 8, 4, 0.5f
        ));
        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 4),
                new ItemStack(ModBlocks.PALM_SAPLING.get(), 1), 8, 4, 0.5f
        ));

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 7),
                new ItemStack(ModItems.TELEPORTATION_DEVICE.get(), 1), 2, 4, 0.5f
        ));
        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 20),
                new ItemStack(ModBlocks.TELEPORTATION_STONE.get(), 1), 1, 4, 0.5f
        ));
    }
}