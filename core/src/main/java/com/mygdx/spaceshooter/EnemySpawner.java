package com.mygdx.spaceshooter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;
import java.util.Random;

public class EnemySpawner {
    private Array<Enemy> enemies;
    private long lastSpawnTime;
    private Random random;

    public EnemySpawner() {
        enemies = new Array<>();
        lastSpawnTime = TimeUtils.millis();
        random = new Random();
    }

    public void update(float deltaTime) {
        if (TimeUtils.timeSinceMillis(lastSpawnTime) > 1000) { // Spawn every 1 second
            float x = random.nextInt(800 - 64); // Random X position
            enemies.add(new Enemy(x, 600, 200)); // Spawn at top of screen
            lastSpawnTime = TimeUtils.millis();
        }

        for (Iterator<Enemy> iter = enemies.iterator(); iter.hasNext(); ) {
            Enemy enemy = iter.next();
            enemy.update(deltaTime);
            if (enemy.isOffScreen()) {
                iter.remove(); // Remove off-screen enemies
            }
        }
    }

    public void draw(SpriteBatch batch) {
        for (Enemy enemy : enemies) {
            enemy.draw(batch);
        }
    }

    public void dispose() {
        for (Enemy enemy : enemies) {
            enemy.dispose();
        }
    }

    public Array<Enemy> getEnemies() {
        return enemies;
    }
}
