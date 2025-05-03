package com.andrew.firstmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class ElectricPickaxeItem extends Item {
    public ElectricPickaxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(properties.pickaxe(material, attackDamage, attackSpeed));
    }
}
