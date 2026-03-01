package com.hbgwhite.mechamods;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MechaMods.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MECHAMODS_TAB =
            CREATIVE_MODE_TABS.register("mechamods_tab",
                    () -> CreativeModeTab.builder()
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .title(Component.translatable("itemGroup.mechamods.mechamods_tab"))
                            .icon(() -> ModItems.GLOW_CANDY.get().getDefaultInstance())
                            .displayItems((parameters, output) -> {
                                output.accept(ModItems.GLOW_CANDY.get());
                                output.accept(ModItems.BOUNCE_BLOCK_ITEM.get());
                                output.accept(ModItems.SPEED_BLOCK_ITEM.get());
                            })
                            .build());
}
