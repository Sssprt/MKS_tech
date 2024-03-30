package net.mcreator.mkstech.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.mkstech.init.MksTechModBlocks;

public class LaptopGamingShiftSndPkmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Screen.hasShiftDown()) {
			world.setBlock(new BlockPos(x, y + 1, z), MksTechModBlocks.LAPTOP_GAMING_BLOCK_OBJECT.get().defaultBlockState(), 3);
		}
	}
}
