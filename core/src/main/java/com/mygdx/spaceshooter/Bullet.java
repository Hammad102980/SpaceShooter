package com.mygdx.spaceshooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    private Texture bulletTexture;
    private Rectangle bulletBounds;
    private float speed;

    public Bullet(float x, float y) {
        this.bulletTexture = new Texture("bullet.png");
        this.bulletBounds = new Rectangle(x, y, 8, 20);
        this.speed = 400;
    }

    public void update(float deltaTime) {
        bulletBounds.y += speed * deltaTime;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(bulletTexture, bulletBounds.x, bulletBounds.y);
    }

    public boolean isOffScreen() {
        return bulletBounds.y > 600;
    }

    public void dispose() {
        bulletTexture.dispose();
    }
}
