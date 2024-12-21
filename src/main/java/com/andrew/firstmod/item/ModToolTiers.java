package com.andrew.firstmod.item;

import com.andrew.firstmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;


public class ModToolTiers {
public static final Tier ELECTRIC = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ELECTRIC_TOOL,
        300, 8f, 3f, 1, () -> Ingredient.of(ModItems.BATTERY));
}