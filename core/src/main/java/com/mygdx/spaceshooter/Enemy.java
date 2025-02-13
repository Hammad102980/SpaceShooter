package com.mygdx.spaceshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Enemy {
    private Texture enemyTexture;
    private Rectangle enemyBounds;
    private float speed;

    public Enemy(float x, float y, float speed) {
        this.enemyTexture = new Texture("enemy.png"); // Make sure to add an enemy.png in assets
        this.enemyBounds = new Rectangle(x, y, 64, 64); // Adjust size as needed
        this.speed = speed;
    }

    public void update(float deltaTime) {
        enemyBounds.y -= speed * deltaTime; // Move down the screen
    }

    public void draw(SpriteBatch batch) {
        batch.draw(enemyTexture, enemyBounds.x, enemyBounds.y);
    }

    public boolean isOffScreen() {
        return enemyBounds.y + enemyBounds.height < 0;
    }

    public Rectangle getBounds() {
        return enemyBounds;
    }

    public void dispose() {
        enemyTexture.dispose();
    }
}
