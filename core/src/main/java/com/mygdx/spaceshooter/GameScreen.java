package com.mygdx.spaceshooter;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Player player;
    private EnemySpawner enemySpawner;
    private List<Bullet> bullets;

    @Override
    public void show() {
        batch = new SpriteBatch();
        player = new Player();
        enemySpawner = new EnemySpawner();
        bullets = new ArrayList<>();
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update player
        player.update(delta);

        // Begin drawing
        batch.begin();
        player.draw(batch);
        enemySpawner.draw(batch);

        for (Bullet bullet : bullets) {
            bullet.draw(batch);
        }

        batch.end();

        // Check collisions and update game state
        checkCollisions();
    }

    private void checkCollisions() {
        // Add collision logic (e.g., player and enemies, bullets and enemies)
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        enemySpawner.dispose();
    }
}
