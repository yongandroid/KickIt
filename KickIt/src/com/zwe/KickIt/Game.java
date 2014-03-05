package com.zwe.KickIt;

import com.badlogic.gdx.ApplicationListener;
import com.zwe.KickIt.Screens.StartScreen;

public class Game implements ApplicationListener {
	
	@Override
	public void create() {		
		new StartScreen(this);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
