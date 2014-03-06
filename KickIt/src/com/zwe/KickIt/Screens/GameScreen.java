package com.zwe.KickIt.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.zwe.KickIt.MainGame;
import com.zwe.KickIt.Models.Ball;

public class GameScreen implements Screen{
	private MainGame game;
	private World world;
	
	private Ball ball;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Box2DDebugRenderer debug;
	
	public GameScreen(MainGame game) {
		super();
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		world.step(1/45f, 6, 2);		// Ist notwendig für die Box2D-Engine damit berechnet wird
		
		batch.begin();
		ball.render(batch);
		batch.end();
		
		debug.render(world, camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		this.world = new World(new Vector2(0f,10f), false);
		this.ball = new Ball(world);
		this.batch = new SpriteBatch();
		this.debug = new Box2DDebugRenderer();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(true);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
