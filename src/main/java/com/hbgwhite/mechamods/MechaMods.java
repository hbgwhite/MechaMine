package com.hbgwhite.mechamods;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MechaMods.MOD_ID)
public class MechaMods {
    public static final String MOD_ID = "mechamods";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MechaMods() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("MechaMine loaded! Have fun, Paxton!");
    }
}
