package com.hbgwhite.mechamods;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MechaMods.MOD_ID);

    /** Magenta trampoline block — bounces you way up into the sky! */
    public static final RegistryObject<Block> BOUNCE_BLOCK = BLOCKS.register("bounce_block",
            () -> new BounceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .strength(0.5f)
                    .sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    /** Cyan speed pad — zooms you forward at lightning speed! */
    public static final RegistryObject<Block> SPEED_BLOCK = BLOCKS.register("speed_block",
            () -> new SpeedBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .strength(0.5f)
                    .sound(SoundType.METAL)));
}
