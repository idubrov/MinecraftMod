package com.andrew.firstmod.item;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.entity.custom.ModBoatEntity;
import com.andrew.firstmod.item.custom.*;
import com.andrew.firstmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(FirstMod.MOD_ID);


    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut",
            () -> new CoconutItem(new Item.Properties().stacksTo(16)));
    public static final DeferredItem<Item> SULFUR_POWDER = ITEMS.register("sulfur_powder",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFUR_SHARD = ITEMS.register("sulfur_shard",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> FRUIT_SALAD = ITEMS.register("fruit_salad",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FRUIT_SALAD)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line1"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line2"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new ItemNameBlockItem(ModBlocks.BANANA_BUSH.get(), new Item.Properties().food(ModFoodProperties.BANANA)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.banana.tooltip.line1"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.banana.tooltip.line2"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.banana.tooltip.line3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> MILK_SHAKE = ITEMS.register("milk_shake",
            () -> new MilkShakeFoodItem(new Item.Properties().food(ModFoodProperties.MILK_SHAKE)));

    public static final DeferredItem<Item> MAKI_SUSHI = ITEMS.register("maki_sushi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.MAKI_SUSHI)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.sushi.tooltip.line1"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.sushi.tooltip.line2"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.maki_sushi.tooltip.line3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> NIGIRI_SUSHI = ITEMS.register("nigiri_sushi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NIGIRI_SUSHI)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.sushi.tooltip.line1"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.sushi.tooltip.line2"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.nigiri_sushi.tooltip.line3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.battery.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> ELECTRIC_PICKAXE = ITEMS.register("electric_pickaxe",
            () -> new ElectricPickaxeItem(ModToolTiers.ELECTRIC, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ELECTRIC, 1.0F, -2.8F))));
    public static final DeferredItem<Item> ELECTRIC_SHOVEL = ITEMS.register("electric_shovel",
            () -> new ElectricShovelItem(ModToolTiers.ELECTRIC, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ELECTRIC, 1.5F, -3.0F))));
    public static final DeferredItem<Item> ELECTRIC_AXE = ITEMS.register("electric_axe",
            () -> new ElectricAxeItem(ModToolTiers.ELECTRIC, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ELECTRIC, 6.0F, -3.1F))));
    public static final DeferredItem<Item> ELECTRIC_HOE = ITEMS.register("electric_hoe",
            () -> new ElectricHoeItem(ModToolTiers.ELECTRIC, new Item.Properties()
                    .attributes(ElectricHoeItem.createAttributes(ModToolTiers.ELECTRIC, -2F, -1F))));


    public static final DeferredItem<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new HammerItem(Tiers.WOOD, new Item.Properties()));
    public static final DeferredItem<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(Tiers.STONE, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, new Item.Properties()));


    public static final DeferredItem<ArmorItem> ELECTRIC_HELMET = ITEMS.register("electric_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(20))) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_helmet.tooltip.line1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<ArmorItem> ELECTRIC_CHESTPLATE = ITEMS.register("electric_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(20))) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_chestplate.tooltip.line1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<ArmorItem> ELECTRIC_LEGGINGS = ITEMS.register("electric_leggings",
            () -> new ModArmorItem(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(20))) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_leggings.tooltip.line1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<ArmorItem> ELECTRIC_BOOTS = ITEMS.register("electric_boots",
            () -> new ModArmorItem(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(20))) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_boots.tooltip.line1"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<ModHorseArmorItem> ELECTRIC_HORSE_ARMOR = ITEMS.register("electric_horse_armor",
            () -> new ModHorseArmorItem(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)
                    .durability(ArmorItem.Type.BODY.getDurability(20))));


    public static final DeferredItem<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> RICE_STEM = ITEMS.register("rice_stem",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> TELEPORTATION_DEVICE = ITEMS.register("teleportation_device",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TELEPORTATION_DEVICE).stacksTo(1)) {
                @Override
                public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
                    return UseAnim.DRINK;
                }
            });


    public static final DeferredItem<Item> MUSIC_DISC_BASSOON_SONGS = ITEMS.register("music_disc_bassoon_songs",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BASSOON_SONGS_KEY).stacksTo(1)));
    public static final DeferredItem<Item> MUSIC_DISC_BASSOON_SOLOS = ITEMS.register("music_disc_bassoon_solos",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BASSOON_SOLOS_KEY).stacksTo(1)));


    public static final DeferredItem<Item> PALM_BOAT = ITEMS.register("palm_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.PALM, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> PALM_CHEST_BOAT = ITEMS.register("palm_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.PALM, (new Item.Properties()).stacksTo(1)));
    public static final DeferredItem<Item> PALM_ELECTRIC_BOAT = ITEMS.register("palm_electric_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.PALM, (new Item.Properties()).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
