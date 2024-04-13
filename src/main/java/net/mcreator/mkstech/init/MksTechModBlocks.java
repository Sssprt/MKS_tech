
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mkstech.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.mkstech.block.RobotVacuumCleanerBlock;
import net.mcreator.mkstech.block.LaptopGamingBlockObjectBlock;
import net.mcreator.mkstech.block.KeyboardBlock;
import net.mcreator.mkstech.block.GamingMonitorBlock;
import net.mcreator.mkstech.MksTechMod;

public class MksTechModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MksTechMod.MODID);
	public static final RegistryObject<Block> LAPTOP_GAMING_BLOCK_OBJECT = REGISTRY.register("laptop_gaming_block_object", () -> new LaptopGamingBlockObjectBlock());
	public static final RegistryObject<Block> KEYBOARD = REGISTRY.register("keyboard", () -> new KeyboardBlock());
	public static final RegistryObject<Block> GAMING_MONITOR = REGISTRY.register("gaming_monitor", () -> new GamingMonitorBlock());
	public static final RegistryObject<Block> ROBOT_VACUUM_CLEANER = REGISTRY.register("robot_vacuum_cleaner", () -> new RobotVacuumCleanerBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			LaptopGamingBlockObjectBlock.registerRenderLayer();
			KeyboardBlock.registerRenderLayer();
			GamingMonitorBlock.registerRenderLayer();
			RobotVacuumCleanerBlock.registerRenderLayer();
		}
	}
}
