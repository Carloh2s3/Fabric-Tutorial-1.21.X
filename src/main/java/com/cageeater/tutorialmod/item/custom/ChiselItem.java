package com.cageeater.tutorialmod.item.custom;

import com.cageeater.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static Map<Block, Block> CHISEL_MAP = new HashMap<>();

    public static void addChiselAction(Block block1, Block block2) {
        if (!CHISEL_MAP.containsKey(block1)) {
            CHISEL_MAP.put(block1, block2);
        }
    }

    public static void initEntries() {
        addChiselAction(Blocks.STONE, Blocks.STONE_BRICKS);
        addChiselAction(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS);
        addChiselAction(Blocks.END_STONE, Blocks.END_STONE_BRICKS);
        addChiselAction(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS);
        addChiselAction(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE);
        addChiselAction(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS);
        addChiselAction(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE);
        addChiselAction(Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE);
        addChiselAction(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS);
        addChiselAction(Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES);
        addChiselAction(Blocks.DEEPSLATE_TILES, Blocks.CHISELED_DEEPSLATE);
        addChiselAction(Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE);
        addChiselAction(Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE);
        addChiselAction(Blocks.TUFF, Blocks.POLISHED_TUFF);
        addChiselAction(Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS);
        addChiselAction(Blocks.POLISHED_TUFF, Blocks.CHISELED_TUFF);
        addChiselAction(Blocks.CHISELED_TUFF, Blocks.TUFF_BRICKS);
        addChiselAction(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS);
        addChiselAction(Blocks.CUT_COPPER, Blocks.CHISELED_COPPER);
        addChiselAction(Blocks.CHISELED_COPPER, Blocks.COPPER_GRATE);
    }

    public ChiselItem(Settings settings) {
        super(settings);
        initEntries();
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.chisel_shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.tutorialmod.chisel"));
        }

        if (stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
