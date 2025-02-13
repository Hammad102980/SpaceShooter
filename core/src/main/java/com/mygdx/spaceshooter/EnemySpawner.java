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
        if (TimeUtils.timeSinceMillis(lastSpawnTime) > 1000) {
            float x = random.nextInt(800 - 64);
            enemies.add(new Enemy(x, 600, 200));
            lastSpawnTime = TimeUtils.millis();
        }

        for (Iterator<Enemy> iter = enemies.iterator(); iter.hasNext(); ) {
            Enemy enemy = iter.next();
            enemy.update(deltaTime);
            if (enemy.isOffScreen()) {
                iter.remove();
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
}
