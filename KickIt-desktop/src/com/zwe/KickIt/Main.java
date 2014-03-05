package com.zwe.KickIt;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "KickIt";
		cfg.useGL20 = true;
		cfg.width = 600;
		cfg.height = 800;
		
		new LwjglApplication(new MainGame(), cfg);
	}
}
