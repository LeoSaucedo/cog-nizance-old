package com.cgsphoto.cognizance.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cgsphoto.cognizance.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "cog-nizance";
		config.width = 1280;
		config.height = 720;
		config.fullscreen = false;
		config.resizable = false;
		config.forceExit = false;
		config.addIcon("graphics/icons/cog-nizance.png", Files.FileType.Internal);
		new LwjglApplication(new MainGame(), config);
	}
}