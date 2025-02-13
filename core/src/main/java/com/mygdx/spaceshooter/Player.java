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
        this.playerTexture = new Texture("player.png"); // Add player.png to assets
        this.playerBounds = new Rectangle(400, 50, 64, 64); // Initial position and size
        this.speed = 300; // Movement speed
    }

    public void update(float delta) {
        // Move left
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            playerBounds.x -= speed * delta;
        }
        // Move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            playerBounds.x += speed * delta;
        }

        // Keep the player within screen bounds
        if (playerBounds.x < 0) {
            playerBounds.x = 0;
        }
        if (playerBounds.x > 800 - playerBounds.width) { // Assuming screen width is 800
            playerBounds.x = 800 - playerBounds.width;
        }
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
