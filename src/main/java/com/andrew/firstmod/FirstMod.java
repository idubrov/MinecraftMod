package com.andrew.firstmod;

import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.block.entity.ModBlockEntities;
import com.andrew.firstmod.block.entity.renderer.ChargingStationBlockEntityRenderer;
import com.andrew.firstmod.entity.client.ModModelLayers;
import com.andrew.firstmod.component.ModDataComponents;
import com.andrew.firstmod.effect.ModEffects;
import com.andrew.firstmod.entity.ModEntities;
import com.andrew.firstmod.item.ModCreativeModeTabs;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.loot.ModLootModifiers;
import com.andrew.firstmod.particle.ModParticlesTypes;
import com.andrew.firstmod.particle.custom.SulfurParticles;
import com.andrew.firstmod.particle.custom.TeleportationParticles;
import com.andrew.firstmod.potion.ModPotions;
import com.andrew.firstmod.screen.ModMenuTypes;
import com.andrew.firstmod.screen.custom.ChargingStationScreen;
import com.andrew.firstmod.sound.ModSounds;
import com.andrew.firstmod.worldgen.tree.ModFoliagePlacers;
import com.andrew.firstmod.worldgen.tree.ModTrunkPlacerTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(FirstMod.MOD_ID)
public class FirstMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "firstmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public FirstMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

       // modEventBus.register(ModEventClientBusEvents.class);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModParticlesTypes.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacers.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PALM_SAPLING.getId(), ModBlocks.POTTED_PALM_SAPLING);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BANANA_BUSH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RICE_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALM_SAPLING.get(), RenderType.cutout());

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALM_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALM_TRAPDOOR.get(), RenderType.cutout());
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticlesTypes.SULFUR_PARTICLES.get(), SulfurParticles.SulfurParticlesProvider::new);
            event.registerSpriteSet(ModParticlesTypes.TELEPORTATION_PARTICLES.get(), TeleportationParticles.TeleportationParticlesProvider::new);
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.CHARGING_STATION_BE.get(), ChargingStationBlockEntityRenderer::new);
        }


        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.CHARGING_STATION_MENU.get(), ChargingStationScreen::new);
        }
    }


    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class LayersRegistry {

        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            EntityRenderers.register(ModEntities.PALM_BOAT.get(), pContext -> new BoatRenderer(pContext, ModModelLayers.PALM_BOAT_LAYER));
            EntityRenderers.register(ModEntities.PALM_ELECTRIC_BOAT.get(), pContext -> new BoatRenderer(pContext, ModModelLayers.PALM_ELECTRIC_BOAT_LAYER));

            event.registerLayerDefinition(ModModelLayers.PALM_BOAT_LAYER, BoatModel::createBoatModel);
            event.registerLayerDefinition(ModModelLayers.PALM_ELECTRIC_BOAT_LAYER, BoatModel::createChestBoatModel);
        }
    }
}
