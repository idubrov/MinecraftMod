package com.andrew.firstmod.client;

import com.andrew.firstmod.FirstMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation PALM_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "boat/palm"), "main");
    public static final ModelLayerLocation PALM_ELECTRIC_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "chest_boat/palm"), "main");
}