package com.cageeater.tutorialmod.block;

import com.cageeater.tutorialmod.KaupenjoeTutorial;
import com.cageeater.tutorialmod.block.custom.MagicBlock;
import com.cageeater.tutorialmod.block.custom.PinkGarnetLampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create()
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .noCollision()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA,AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));
    public static final Block STEEL_STAIRS = registerBlock("steel_stairs",
            new StairsBlock(ModBlocks.STEEL_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));
    public static final Block STEEL_SLAB = registerBlock("steel_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));
    public static final Block STEEL_WALL = registerBlock("steel_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)));
    //for some reason it's impossible to add sounds to doors without also making a new blockSoundGroup.
    public static final Block STEEL_DOOR = registerBlock("steel_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .nonOpaque()));
    public static final Block STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KaupenjoeTutorial.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(KaupenjoeTutorial.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        KaupenjoeTutorial.LOGGER.info("Registering Mod Blocks for " + KaupenjoeTutorial.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
            entries.add(ModBlocks.PINK_GARNET_ORE);
            entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

            entries.add(ModBlocks.STEEL_BLOCK);

            entries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
