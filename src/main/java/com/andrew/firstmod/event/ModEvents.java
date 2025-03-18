package com.andrew.firstmod.event;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.item.custom.*;
import com.andrew.firstmod.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;


@EventBusSubscriber(modid = FirstMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
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
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : ElectricTool.getBlocksToBeDestroyed(2, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos) {
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
}