
package net.mcreator.mkstech.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.mkstech.world.inventory.PhoneguimusicMenu;
import net.mcreator.mkstech.network.PhoneguimusicButtonMessage;
import net.mcreator.mkstech.MksTechMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneguimusicScreen extends AbstractContainerScreen<PhoneguimusicMenu> {
	private final static HashMap<String, Object> guistate = PhoneguimusicMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_pigstep;
	Button button_stop;
	Button button_strad;
	Button button_wait;
	Button button_cat;
	Button button_blocks;
	Button button_mall;
	Button button_far;
	Button button_stal;
	Button button_13;
	Button button_11;
	ImageButton imagebutton_home_button;

	public PhoneguimusicScreen(PhoneguimusicMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 200;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, new ResourceLocation("mks_tech:textures/screens/smartphone_ui_bkgr.png"));
		this.blit(ms, this.leftPos + -4, this.topPos + -20, 0, 0, 160, 240, 160, 240);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.mks_tech.phoneguimusic.label_choose_music"), 43, -8, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_pigstep = new Button(this.leftPos + 7, this.topPos + 144, 61, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_pigstep"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(0, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_pigstep", button_pigstep);
		this.addRenderableWidget(button_pigstep);
		button_stop = new Button(this.leftPos + 99, this.topPos + 200, 46, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_stop"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(1, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_stop", button_stop);
		this.addRenderableWidget(button_stop);
		button_strad = new Button(this.leftPos + 7, this.topPos + 84, 51, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_strad"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(2, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_strad", button_strad);
		this.addRenderableWidget(button_strad);
		button_wait = new Button(this.leftPos + 7, this.topPos + 104, 46, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_wait"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(3, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_wait", button_wait);
		this.addRenderableWidget(button_wait);
		button_cat = new Button(this.leftPos + 7, this.topPos + 4, 40, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_cat"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(4, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_cat", button_cat);
		this.addRenderableWidget(button_cat);
		button_blocks = new Button(this.leftPos + 7, this.topPos + 24, 56, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_blocks"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(5, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_blocks", button_blocks);
		this.addRenderableWidget(button_blocks);
		button_mall = new Button(this.leftPos + 7, this.topPos + 64, 46, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_mall"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(6, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_mall", button_mall);
		this.addRenderableWidget(button_mall);
		button_far = new Button(this.leftPos + 7, this.topPos + 164, 40, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_far"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(7, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_far", button_far);
		this.addRenderableWidget(button_far);
		button_stal = new Button(this.leftPos + 7, this.topPos + 124, 46, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_stal"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(8, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_stal", button_stal);
		this.addRenderableWidget(button_stal);
		button_13 = new Button(this.leftPos + 7, this.topPos + 184, 35, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_13"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(9, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_13", button_13);
		this.addRenderableWidget(button_13);
		button_11 = new Button(this.leftPos + 7, this.topPos + 44, 35, 20, new TranslatableComponent("gui.mks_tech.phoneguimusic.button_11"), e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(10, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:button_11", button_11);
		this.addRenderableWidget(button_11);
		imagebutton_home_button = new ImageButton(this.leftPos + 55, this.topPos + 204, 44, 16, 0, 0, 16, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_home_button.png"), 44, 32, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguimusicButtonMessage(11, x, y, z));
				PhoneguimusicButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_button", imagebutton_home_button);
		this.addRenderableWidget(imagebutton_home_button);
	}
}
