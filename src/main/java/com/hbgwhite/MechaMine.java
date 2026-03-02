package com.hbgwhite;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MechaMine implements ModInitializer {
	public static final String MOD_ID = "mechamine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<Item> BOOM_SWORD_KEY = RegistryKey.of(
		Registries.ITEM.getKey(),
		Identifier.of(MOD_ID, "boom_sword")
	);

	public static final BoomSword BOOM_SWORD = new BoomSword();

	@Override
	public void onInitialize() {
		LOGGER.info("MechaMine loaded!");
		Registry.register(Registries.ITEM, BOOM_SWORD_KEY, BOOM_SWORD);
	}
}