package com.cageeater.tutorialmod;

import com.cageeater.tutorialmod.block.ModBlocks;
import com.cageeater.tutorialmod.component.ModDataComponentTypes;
import com.cageeater.tutorialmod.item.ModItemGroups;
import com.cageeater.tutorialmod.item.ModItems;
import com.cageeater.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KaupenjoeTutorial implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//very important comment lol
	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}