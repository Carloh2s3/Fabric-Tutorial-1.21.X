package com.cageeater.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PinkGarnetLampBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public PinkGarnetLampBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(CLICKED, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        float f = state.get(CLICKED) ? 0.5F : 0.6F;
        world.playSound(player,pos, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.BLOCKS, 0.3f,f);
        if (!world.isClient()) {
            //if (state.get(CLICKED).booleanValue()) {
            world.setBlockState(pos, state.cycle(CLICKED));
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}
