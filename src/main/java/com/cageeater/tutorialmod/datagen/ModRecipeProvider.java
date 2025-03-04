package com.cageeater.tutorialmod.datagen;

import com.cageeater.tutorialmod.KaupenjoeTutorial;
import com.cageeater.tutorialmod.block.ModBlocks;
import com.cageeater.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        //pink garnet processing
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(
                ModItems.RAW_PINK_GARNET,
                ModBlocks.PINK_GARNET_ORE,
                ModBlocks.PINK_GARNET_DEEPSLATE_ORE
        );

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC,
                ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC,
                ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(KaupenjoeTutorial.MOD_ID,"raw_pink_garnet_from_magic_block"));

        //steel processing
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_BLEND)
                .input(ItemTags.COALS)
                .input(ItemTags.COALS)
                .input(Items.RAW_IRON, 2)
                .criterion(hasItem(Items.RAW_IRON), conditionsFromItem(Items.RAW_IRON))
                .offerTo(recipeExporter);

        List<ItemConvertible> STEEL_INGOT_BLASTABLES = List.of(
                ModItems.STEEL_BLEND
        );

        offerBlasting(recipeExporter, STEEL_INGOT_BLASTABLES, RecipeCategory.MISC,
                ModItems.STEEL_INGOT, 0.4f, 200, "steel_ingot");

        //building blocks
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.STEEL_INGOT, RecipeCategory.DECORATIONS, ModBlocks.STEEL_BLOCK);

        //pink garnet items
        createToolRecipe("sword", RecipeCategory.COMBAT, ModItems.PINK_GARNET_SWORD, ModItems.PINK_GARNET, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("shovel", RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL, ModItems.PINK_GARNET, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("pickaxe", RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE, ModItems.PINK_GARNET, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("axe", RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE, ModItems.PINK_GARNET, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("hoe", RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE, ModItems.PINK_GARNET, Items.STICK).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern(" B ")
                        .input('A', ModItems.PINK_GARNET)
                        .input('B', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(recipeExporter);

        createArmorRecipe("helmet", RecipeCategory.COMBAT, ModItems.PINK_GARNET_HELMET, ModItems.PINK_GARNET).offerTo(recipeExporter);
        createArmorRecipe("chestplate", RecipeCategory.COMBAT, ModItems.PINK_GARNET_CHESTPLATE, ModItems.PINK_GARNET).offerTo(recipeExporter);
        createArmorRecipe("leggings", RecipeCategory.COMBAT, ModItems.PINK_GARNET_LEGGINGS, ModItems.PINK_GARNET).offerTo(recipeExporter);
        createArmorRecipe("boots", RecipeCategory.COMBAT, ModItems.PINK_GARNET_BOOTS, ModItems.PINK_GARNET).offerTo(recipeExporter);

        //steel items
        createToolRecipe("sword", RecipeCategory.COMBAT, ModItems.STEEL_SWORD, ModItems.STEEL_INGOT, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("shovel", RecipeCategory.TOOLS, ModItems.STEEL_SHOVEL, ModItems.STEEL_INGOT, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("pickaxe", RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE, ModItems.STEEL_INGOT, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("axe", RecipeCategory.TOOLS, ModItems.STEEL_AXE, ModItems.STEEL_INGOT, Items.STICK).offerTo(recipeExporter);
        createToolRecipe("hoe", RecipeCategory.TOOLS, ModItems.STEEL_HOE, ModItems.STEEL_INGOT, Items.STICK).offerTo(recipeExporter);

        createArmorRecipe("helmet", RecipeCategory.COMBAT, ModItems.STEEL_HELMET, ModItems.STEEL_INGOT).offerTo(recipeExporter);
        createArmorRecipe("chestplate", RecipeCategory.COMBAT, ModItems.STEEL_CHESTPLATE, ModItems.STEEL_INGOT).offerTo(recipeExporter);
        createArmorRecipe("leggings", RecipeCategory.COMBAT, ModItems.STEEL_LEGGINGS, ModItems.STEEL_INGOT).offerTo(recipeExporter);
        createArmorRecipe("boots", RecipeCategory.COMBAT, ModItems.STEEL_BOOTS, ModItems.STEEL_INGOT).offerTo(recipeExporter);
    }

    private ShapedRecipeJsonBuilder createToolRecipe(String toolType, RecipeCategory category, Item result, Item material, Item stick) {
        ShapedRecipeJsonBuilder recipe = ShapedRecipeJsonBuilder.create(category, result)
                .input('A', material)
                .input('B', stick)
                .criterion(hasItem(material), conditionsFromItem(material));
        switch (toolType) {
            case "sword":
                recipe
                        .pattern(" A ")
                        .pattern(" A ")
                        .pattern(" B ");
                break;
            case "shovel":
                recipe
                        .pattern(" A ")
                        .pattern(" B ")
                        .pattern(" B ");
                break;
            case "pickaxe":
                recipe
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ");
                break;
            case "axe":
                recipe
                        .pattern("AA ")
                        .pattern("AB ")
                        .pattern(" B ");
                break;
            case "hoe":
                recipe
                        .pattern("AA ")
                        .pattern(" B ")
                        .pattern(" B ");
                break;
            default:
                recipe
                        .pattern(" A ")
                        .pattern(" B ")
                        .pattern(" A ");
                break;
        }
        return recipe;
    }

    private ShapedRecipeJsonBuilder createArmorRecipe(String toolType, RecipeCategory category, Item result, Item material) {
        ShapedRecipeJsonBuilder recipe = ShapedRecipeJsonBuilder.create(category, result)
                .input('A', material)
                .criterion(hasItem(material), conditionsFromItem(material));
        switch (toolType) {
            case "helmet":
                recipe
                        .pattern("AAA")
                        .pattern("A A");
                break;
            case "chestplate":
                recipe
                        .pattern("A A")
                        .pattern("AAA")
                        .pattern("AAA");
                break;
            case "leggings":
                recipe
                        .pattern("AAA")
                        .pattern("A A")
                        .pattern("A A");
                break;
            case "boots":
                recipe
                        .pattern("A A")
                        .pattern("A A");
                break;
            default:
                recipe
                        .pattern("   ")
                        .pattern("ABA")
                        .pattern("   ");
                break;
        }
        return recipe;
    }
}
