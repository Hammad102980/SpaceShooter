package com.mygdx.spaceshooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private EnemySpawner enemySpawner;

    public GameScreen() {
        batch = new SpriteBatch();
        enemySpawner = new EnemySpawner(); // Initialize EnemySpawner
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update enemy movement
        enemySpawner.update(delta);

        // Draw everything
        batch.begin();
        enemySpawner.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        enemySpawner.dispose();
    }

    @Override
    public void show() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}
}
