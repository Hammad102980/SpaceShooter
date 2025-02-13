package com.mygdx.spaceshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player {
    private Texture playerTexture;
    private Rectangle playerBounds;
    private float speed;

    public Player() {
        playerTexture = new Texture("player.png");  // Ensure this is in assets
        playerBounds = new Rectangle(400, 50, 64, 64);
        speed = 300;
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) playerBounds.x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) playerBounds.x += speed * delta;

        // Keep within screen bounds
        playerBounds.x = Math.max(0, Math.min(800 - playerBounds.width, playerBounds.x));
    }

    public void draw(SpriteBatch batch) {
        batch.draw(playerTexture, playerBounds.x, playerBounds.y);
    }

    public Rectangle getBounds() {
        return playerBounds;
    }

    public void dispose() {
        playerTexture.dispose();
    }
}
