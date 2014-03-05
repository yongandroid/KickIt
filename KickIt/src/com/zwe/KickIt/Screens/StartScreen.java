package com.zwe.KickIt.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.zwe.KickIt.MainGame;

public class StartScreen implements Screen{
	private MainGame game;
	private TextureAtlas atlas;
	private Skin skin;
	private BitmapFont font;
	
	// Scene2D elements
	private Stage stage;
	
	public StartScreen(MainGame game) {
		super();
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Table.drawDebug(stage);

		stage.act(delta);
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void show() {
		this.stage = new Stage();
		this.atlas = new TextureAtlas(Gdx.files.internal("data/textures/interface/interface.atlas"));
		this.skin = new Skin(atlas);
		this.font = new BitmapFont(Gdx.files.internal("data/fonts/mainFont.fnt"), false);
		
		Gdx.input.setInputProcessor(stage);
		
		// generation of the table
		Table table = new Table();
		table.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		
		// generation of the textbutton
		TextButtonStyle tbs = new TextButtonStyle();
		tbs.up = skin.getDrawable("button_normal");
		tbs.down = skin.getDrawable("button_clicked");
		tbs.font = font;
		
		TextButton tb = new TextButton("Start game", tbs);
		table.add(tb).minWidth(Gdx.graphics.getWidth()/2);
		table.debug();
		
		stage.addActor(table);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		this.stage.dispose();
	}

}
