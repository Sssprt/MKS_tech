package net.mcreator.mkstech.procedures;

import net.minecraft.world.level.LevelAccessor;

public class PhoneguiZnachieniieProcedure {
	public static String execute(LevelAccessor world) {
		return world.dayTime() + "";
	}
}
