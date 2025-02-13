package com.mygdx.spaceshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    private Texture bulletTexture;
    private Rectangle bulletBounds;
    private float speed;

    public Bullet(float x, float y) {
        this.bulletTexture = new Texture("bullet.png"); // Add bullet.png to assets
        this.bulletBounds = new Rectangle(x, y, 8, 20); // Adjust size
        this.speed = 400; // Bullet speed
    }

    public void update(float deltaTime) {
        bulletBounds.y += speed * deltaTime; // Move bullet upwards
    }

    public void draw(SpriteBatch batch) {
        batch.draw(bulletTexture, bulletBounds.x, bulletBounds.y);
    }

    public boolean isOffScreen() {
        return bulletBounds.y > 600; // Remove if off-screen
    }

    public Rectangle getBounds() {
        return bulletBounds;
    }

    public void dispose() {
        bulletTexture.dispose();
    }
}
