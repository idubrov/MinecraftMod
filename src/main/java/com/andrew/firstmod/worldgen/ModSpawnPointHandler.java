package com.andrew.firstmod.worldgen;

import com.andrew.firstmod.FirstMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.List;

@EventBusSubscriber(modid = FirstMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModSpawnPointHandler {

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.CreateSpawnPosition event) {
        if (!(event.getLevel() instanceof ServerLevel serverLevel)) return;

        // List of biomes to search for
        List<ResourceKey<Biome>> desiredBiomes = List.of(
            //    Biomes.BEACH,             // need palms on the sand
                Biomes.SPARSE_JUNGLE,
                Biomes.BAMBOO_JUNGLE,
             //   Biomes.DESERT,            // need palms on the sand
                Biomes.CHERRY_GROVE,
                Biomes.STONY_SHORE
        );

        BlockPos newSpawn = findBiomeSpawn(serverLevel, desiredBiomes, 5000); // Set to desired biome
        if (newSpawn != null) {
            event.setCanceled(true); // Cancel default spawn
            serverLevel.setDefaultSpawnPos(newSpawn, 0); // Set new spawn point
            System.out.println("Spawn point set in desired biome: " + serverLevel.getBiome(newSpawn).unwrapKey().get());
        } else {
            System.out.println("No desired biome found within search range.");
        }
    }

    private static BlockPos findBiomeSpawn(ServerLevel level, List<ResourceKey<Biome>> biomesToFind, int searchRadius) {
        BlockPos spawn = level.getSharedSpawnPos(); // Default spawn location
        int centerX = spawn.getX();
        int centerZ = spawn.getZ();

        for (int x = -searchRadius; x <= searchRadius; x += 128) {
            for (int z = -searchRadius; z <= searchRadius; z += 128) {
                BlockPos checkPos = new BlockPos(centerX + x, level.getHeight(), centerZ + z);

                for (ResourceKey<Biome> biomeKey : biomesToFind) {
                    if (level.getBiome(checkPos).is(biomeKey)) {
                        return checkPos; // Return the first valid biome found
                    }
                }
            }
        }

        return null; // If no biome found, fallback to default
    }
}
