package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;

import static com.mygdx.game.utilities.General.FPS;
import static com.mygdx.game.utilities.General.HEIGHT;
import static com.mygdx.game.utilities.General.TITLE;
import static com.mygdx.game.utilities.General.WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = FPS;
		config.backgroundFPS = FPS;
//		config.vSyncEnabled = true;
		config.title = TITLE;
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = true;
		new LwjglApplication(new Game(), config);
	}
}
