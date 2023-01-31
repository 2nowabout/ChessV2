package com.now.chessv2;

import starter.ChessV2;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setMaximized(false);
		config.setWindowedMode(1920,1080);
		config.setForegroundFPS(30);
		config.setTitle("ChessV2");
		new Lwjgl3Application(new ChessV2(), config);
	}
}
