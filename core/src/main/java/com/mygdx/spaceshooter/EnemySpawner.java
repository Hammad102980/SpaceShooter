package com.mygdx.spaceshooter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.Gdx;

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
        int spawnInterval = random.nextInt(1000) + 500; // Random interval between 500ms and 1500ms
        if (TimeUtils.timeSinceMillis(lastSpawnTime) > spawnInterval) {
            float x = random.nextInt(Gdx.graphics.getWidth() - 64); // Random X position
            enemies.add(new Enemy(x, Gdx.graphics.getHeight(), 200)); // Spawn at the top of the screen
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
