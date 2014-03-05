package com.zwe.KickIt;

import com.badlogic.gdx.Game;
import com.zwe.KickIt.Screens.StartScreen;

public class MainGame extends Game {
	
	@Override
	public void create() {		
		setScreen(new StartScreen(this));
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {	
		super.render();
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
