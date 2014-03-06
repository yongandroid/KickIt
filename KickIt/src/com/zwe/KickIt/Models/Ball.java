package com.zwe.KickIt.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Ball {
	private World world; 	// Kapselt alles der Physik-Engine
	private Body body; 		// Physik-Objekt des Ghosts
	private int height,width;
	private float posX, posY;
	
	private Texture texture;

	public Ball(World world) {
		this.width = 100;
		this.height = 100;
		this.posX = Gdx.graphics.getWidth() / 2;
		this.posY = Gdx.graphics.getHeight() / 2;
		this.world = world;
		this.texture = new Texture(Gdx.files.internal("data/ball.png"));
		
		// Anlegen der Physik-Objekte
		BodyDef def = new BodyDef();
		def.type = BodyType.DynamicBody;
		def.position.set(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);

		body = world.createBody(def);
		body.setUserData("ball");

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(50, 50);

		FixtureDef fixture = new FixtureDef();
		fixture.density = 1f;
		fixture.friction = 0f;
		fixture.shape = shape;

		body.createFixture(fixture);
		body.setTransform(this.posX, this.posY, 0);
	}
	
	public void render(SpriteBatch batch){
		Vector2 pos = new Vector2(body.getPosition().x, body.getPosition().y);
		batch.draw(texture, pos.x - width / 2, toDrawCoord(pos.y) - height / 2, width, height);
	}
	
	/**
	 * converts the physics position to the real texture position
	 * @param y physic position
	 * @return render position
	 */
	public float toDrawCoord(float y){
		return 400 - (y-400);
	}
}
