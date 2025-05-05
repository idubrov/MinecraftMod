# Sulfur

Sulfur Ore is best mined by a hammer, because you don't need to smelt the Shards.
Sulfur Ore, Nether Sulfur Ore, and End Sulfur Ore have a hardness of 3, 
while Deepslate has a hardness of 4.5.
Also, Sulfur Ore,  Deepslate Sulfur Ore, Nether Sulfur Ore, End Sulfur Ore, 
and Sulfur Block glow in the dark with a light level of 10 and emit particles.
Lastly, sulfur ore barely spawns in the Overworld, spawns a decent amount in the Nether, and a ton in the End.

<br>

| Sulfur Ore                                                               | Deepslate <br>Sulfur Ore                                                                     | Nether <br>Sulfur Ore                                                                  | End <br>Sulfur Ore                                                               | Sulfur Block                                                                 | Sulfur Shard                                                                  | Sulfur Powder                                                                   |
|--------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------|------------------------------------------------------------------------------|-------------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| <img src="./img/sulfur_ore.png" alt="Sulfur Ore" height="50" width="50"> | <img src="./img/deepslate_sulfur_ore.png" alt="Deepslate Sulfur Ore" height="50" width="50"> | <img src="./img/nether_sulfur_ore.png" alt="Nether Sulfur Ore" height="50" width="50"> | <img src="./img/end_sulfur_ore.png" alt="End Sulfur Ore" height="50" width="50"> | <img src="./img/sulfur_block.png" alt="Sulfur Block" height="50" width="50"> | <img src="./img/sulfur_shard1.png" alt="Sulfur Shard" height="50" width="50"> | <img src="./img/sulfur_powder1.png" alt="Sulfur Powder" height="50" width="50"> |


```mermaid
flowchart TD
    A(Sulfur Ore<br>Deepslate Sulfur Ore<br>Nether Sulfur Ore<br>End Sulfur Ore) -->|Pickaxe| B{{Sulfur Shard}}
    B <-.->|Crafting Table| C[Sulfur Block]
    B -.->|Furnace<br>Blast Furnace| D[/Sulfur Powder\]
    A -->|Hammer| D
    A -..->|Furnace<br>Blast Furnace| D
```

### Damage 

All Sulfur Ores damage most living entities standing on top, dealing 1 damage every tick.

<br>

### Sulfur Ore Drops

| Tool Tier | Pickaxe           | Hammer                       | Silk Touch Pickaxe  | Other |
|-----------|-------------------|------------------------------|---------------------|-------|
| Wooden    | None              | None                         | None                | None  |
| Stone     | None              | None                         | None                | None  |
| Iron      | 1-3 Sulfur Shards | 1-3 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Diamond   | 1-3 Sulfur Shards | 1-3 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Netherite | 1-3 Sulfur Shards | 1-3 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Golden    | None              | None                         | None                | None  |

<br>

### Deepslate, Nether, and End Sulfur Ore Drops

| Tool Tier | Pickaxe           | Hammer                       | Silk Touch Pickaxe  | Other |
|-----------|-------------------|------------------------------|---------------------|-------|
| Wooden    | None              | None                         | None                | None  |
| Stone     | None              | None                         | None                | None  |
| Iron      | 2-4 Sulfur Shards | 2-4 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Diamond   | 2-4 Sulfur Shards | 2-4 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Netherite | 2-4 Sulfur Shards | 2-4 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Golden    | None              | None                         | None                | None  |

<br>

### Usage

| Name          | Ingredients                                                     | Crafting Recipe                                                        | Advancements           |
|---------------|-----------------------------------------------------------------|------------------------------------------------------------------------|------------------------|
| Sulfur Shards | Sulfur Block                                                    | <img src="./img/recipe_sulfur_2.png" alt="Sulfur Recipe" height="100"> | Obtain Sulfur Block    |
| Sulfur Block  | Sulfur Shards (9)                                               | <img src="./img/recipe_sulfur_1.png" alt="Sulfur Recipe" height="100"> | Obtain Sulfur Shard    |
| Battery       | Iron Ingots (3),<br/> Sulfur Powder (3),<br/> Copper Ingots (3) | <img src="./img/recipe_sulfur_3.png" alt="Sulfur Recipe" height="100"> | Obtain Sulfur Powder   |

<br>

| Name          | Ingredients                        | Smelting Recipe                                                        | Cooking Time       | Exp | Advancements                |
|---------------|------------------------------------|------------------------------------------------------------------------|:-------------------|:----|-----------------------------|
| Sulfur Powder | Sulfur Shard, <br>any fuel         | <img src="./img/recipe_sulfur_4.png" alt="Sulfur Recipe" height="100"> | 100 ticks<br>5 sec | 0.5 | Obtain Sulfur Shard         |
| Sulfur Powder | Sulfur Ore, <br>any fuel           | <img src="./img/recipe_sulfur_5.png" alt="Sulfur Recipe" height="100"> | 100 ticks<br>5 sec | 0.5 | Obtain Sulfur Ore           |
| Sulfur Powder | Deepslate Sulfur Ore, <br>any fuel | <img src="./img/recipe_sulfur_6.png" alt="Sulfur Recipe" height="100"> | 100 ticks<br>5 sec | 0.5 | Obtain Deepslate Sulfur Ore |
| Sulfur Powder | Nether Sulfur Ore, <br>any fuel    | <img src="./img/recipe_sulfur_7.png" alt="Sulfur Recipe" height="100"> | 100 ticks<br>5 sec | 0.5 | Obtain Nether Sulfur Ore    |
| Sulfur Powder | End Sulfur Ore, <br>any fuel       | <img src="./img/recipe_sulfur_8.png" alt="Sulfur Recipe" height="100"> | 100 ticks<br>5 sec | 0.5 | Obtain End Sulfur Ore       |

<br>

| Name          | Ingredients                        | Blasting Recipe                                                        | Cooking Time      | Exp | Advancements                |
|---------------|------------------------------------|------------------------------------------------------------------------|:------------------|:----|-----------------------------|
| Sulfur Powder | Sulfur Shard, <br>any fuel         | <img src="./img/recipe_sulfur_4.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Sulfur Shard         |
| Sulfur Powder | Sulfur Ore, <br>any fuel           | <img src="./img/recipe_sulfur_5.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Sulfur Ore           |
| Sulfur Powder | Deepslate Sulfur Ore, <br>any fuel | <img src="./img/recipe_sulfur_6.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Deepslate Sulfur Ore |
| Sulfur Powder | Nether Sulfur Ore, <br>any fuel    | <img src="./img/recipe_sulfur_7.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Nether Sulfur Ore    |
| Sulfur Powder | End Sulfur Ore, <br>any fuel       | <img src="./img/recipe_sulfur_8.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain End Sulfur Ore       |
