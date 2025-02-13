package com.mygdx.spaceshooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;

public class GameScreen implements Screen {
    private SpaceShooterGame game;
    private Player player;
    private EnemySpawner enemySpawner;

    public GameScreen(SpaceShooterGame game) {
        this.game = game;
        this.player = new Player();
        this.enemySpawner = new EnemySpawner();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        player.update(delta);
        player.draw(game.batch);

        enemySpawner.update(delta);
        enemySpawner.draw(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        player.dispose();
        enemySpawner.dispose();
    }
}
