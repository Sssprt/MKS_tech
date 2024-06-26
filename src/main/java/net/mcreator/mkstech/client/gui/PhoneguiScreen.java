
package net.mcreator.mkstech.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.mkstech.world.inventory.PhoneguiMenu;
import net.mcreator.mkstech.network.PhoneguiButtonMessage;
import net.mcreator.mkstech.MksTechMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneguiScreen extends AbstractContainerScreen<PhoneguiMenu> {
	private final static HashMap<String, Object> guistate = PhoneguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_home_button;
	ImageButton imagebutton_appiconyt;
	ImageButton imagebutton_appiconmessenger;
	ImageButton imagebutton_appiconweather;
	ImageButton imagebutton_appiconmusic;
	ImageButton imagebutton_appiconclock;
	ImageButton imagebutton_appiconset;

	public PhoneguiScreen(PhoneguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 350;
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

		RenderSystem.setShaderTexture(0, new ResourceLocation("mks_tech:textures/screens/smartphone_ui_backgr.png"));
		this.blit(ms, this.leftPos + 2, this.topPos + 23, 0, 0, 180, 300, 180, 300);

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
		imagebutton_home_button = new ImageButton(this.leftPos + 66, this.topPos + 311, 50, 9, 0, 0, 9, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_home_button.png"), 50, 18, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(0, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_button", imagebutton_home_button);
		this.addRenderableWidget(imagebutton_home_button);
		imagebutton_appiconyt = new ImageButton(this.leftPos + 10, this.topPos + 43, 32, 32, 0, 0, 32, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_appiconyt.png"), 32, 64, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(1, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_appiconyt", imagebutton_appiconyt);
		this.addRenderableWidget(imagebutton_appiconyt);
		imagebutton_appiconmessenger = new ImageButton(this.leftPos + 42, this.topPos + 43, 32, 32, 0, 0, 32, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_appiconmessenger.png"), 32, 64, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(2, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_appiconmessenger", imagebutton_appiconmessenger);
		this.addRenderableWidget(imagebutton_appiconmessenger);
		imagebutton_appiconweather = new ImageButton(this.leftPos + 74, this.topPos + 43, 32, 32, 0, 0, 32, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_appiconweather.png"), 32, 64, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(3, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_appiconweather", imagebutton_appiconweather);
		this.addRenderableWidget(imagebutton_appiconweather);
		imagebutton_appiconmusic = new ImageButton(this.leftPos + 106, this.topPos + 43, 32, 32, 0, 0, 32, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_appiconmusic.png"), 32, 64, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(4, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_appiconmusic", imagebutton_appiconmusic);
		this.addRenderableWidget(imagebutton_appiconmusic);
		imagebutton_appiconclock = new ImageButton(this.leftPos + 138, this.topPos + 43, 32, 32, 0, 0, 32, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_appiconclock.png"), 32, 64, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(5, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_appiconclock", imagebutton_appiconclock);
		this.addRenderableWidget(imagebutton_appiconclock);
		imagebutton_appiconset = new ImageButton(this.leftPos + 10, this.topPos + 75, 32, 32, 0, 0, 32, new ResourceLocation("mks_tech:textures/screens/atlas/imagebutton_appiconset.png"), 32, 64, e -> {
			if (true) {
				MksTechMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(6, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_appiconset", imagebutton_appiconset);
		this.addRenderableWidget(imagebutton_appiconset);
	}
}
