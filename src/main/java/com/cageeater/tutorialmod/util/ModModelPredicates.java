package com.cageeater.tutorialmod.util;

import com.cageeater.tutorialmod.KaupenjoeTutorial;
import com.cageeater.tutorialmod.component.ModDataComponentTypes;
import com.cageeater.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(KaupenjoeTutorial.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);

    }
}
