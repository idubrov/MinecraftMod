# Sulfur

Sulfur Ore is best mined by a hammer, because you don't need to smelt the Shards.
Sulfur Ore has a hardness of 3, while Deepslate has a hardness of 4.5.
Also, Sulfur Ore,  Deepslate Sulfur Ore, and Sulfur Block glow in the dark with a light level of 10 and emits particles.

<br>

| Sulfur Ore                                                                 | Deepslate Sulfur Ore                                                                           | Sulfur Block                                                                   | Sulfur Shard                                                                   | Sulfur Powder                                                                    |
|----------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------|--------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| <img src="./img/sulfur_ore.png" alt="Sulfur Ore" height="100" width="100"> | <img src="./img/deepslate_sulfur_ore.png" alt="Deepslate Sulfur Ore" height="100" width="100"> | <img src="./img/sulfur_block.png" alt="Sulfur Block" height="100" width="100"> | <img src="./img/sulfur_shard.png" alt="Sulfur Shard" height="100" width="100"> | <img src="./img/sulfur_powder.png" alt="Sulfur Powder" height="100" width="100"> |


```mermaid
flowchart TD
    A(Sulfur Ore<br>Deepslate Sulfur Ore) -->|Pickaxe| B{{Sulfur Shard}}
    B <-.->|Crafting Table| C[Sulfur Block]
    B -.->|Furnace<br>Blast Furnace| D[/Sulfur Powder\]
    A -->|Hammer| D
    A -..->|Furnace<br>Blast Furnace| D
```

### Damage 

Sulfur Ore damages most living entities standing on top of it, dealing 1 damage every tick.

<br>

### Sulfur Ore and Deepslate Sulfur Ore Drops

| Tool Tier | Pickaxe           | Hammer                       | Silk Touch Pickaxe  | Other |
|-----------|-------------------|------------------------------|---------------------|-------|
| Wooden    | None              | None                         | None                | None  |
| Stone     | None              | None                         | None                | None  |
| Iron      | 1-3 Sulfur Shards | 1-3 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
| Diamond   | 1-3 Sulfur Shards | 1-3 Sulfur Powder<br/>2-5 xp | 1 Sulfur Ore Block  | None  |
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

<br>

| Name          | Ingredients                        | Blasting Recipe                                                        | Cooking Time      | Exp | Advancements                |
|---------------|------------------------------------|------------------------------------------------------------------------|:------------------|:----|-----------------------------|
| Sulfur Powder | Sulfur Shard, <br>any fuel         | <img src="./img/recipe_sulfur_4.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Sulfur Shard         |
| Sulfur Powder | Sulfur Ore, <br>any fuel           | <img src="./img/recipe_sulfur_5.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Sulfur Ore           |
| Sulfur Powder | Deepslate Sulfur Ore, <br>any fuel | <img src="./img/recipe_sulfur_6.png" alt="Sulfur Recipe" height="100"> | 80 ticks<br>4 sec | 0.7 | Obtain Deepslate Sulfur Ore |
