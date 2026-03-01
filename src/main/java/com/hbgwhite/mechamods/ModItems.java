package com.hbgwhite.mechamods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MechaMods.MOD_ID);

    /**
     * Glow Candy — a sweet treat that lights you up and lets you see in the dark!
     * Eating it gives Night Vision, Glowing, and Jump Boost for 60 seconds.
     */
    public static final RegistryObject<Item> GLOW_CANDY = ITEMS.register("glow_candy",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationMod(0.5f)
                            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200, 0), 1.0f)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200, 2), 1.0f)
                            .alwaysEat()
                            .build())));

    public static final RegistryObject<Item> BOUNCE_BLOCK_ITEM = ITEMS.register("bounce_block",
            () -> new BlockItem(ModBlocks.BOUNCE_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> SPEED_BLOCK_ITEM = ITEMS.register("speed_block",
            () -> new BlockItem(ModBlocks.SPEED_BLOCK.get(), new Item.Properties()));
}
