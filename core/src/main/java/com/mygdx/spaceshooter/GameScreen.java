package com.mygdx.spaceshooter;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private EnemySpawner enemySpawner;
    private Array<Bullet> bullets;

    public GameScreen() {
        batch = new SpriteBatch();
        enemySpawner = new EnemySpawner();
        bullets = new Array<>();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Detect spacebar press to fire a bullet
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(400, 50)); // Adjust X & Y later
        }

        // Update bullets
        for (Iterator<Bullet> iter = bullets.iterator(); iter.hasNext(); ) {
            Bullet bullet = iter.next();
            bullet.update(delta);
            if (bullet.isOffScreen()) {
                iter.remove();
            }
        }

        // Update enemies
        enemySpawner.update(delta);

        // Check for bullet collisions with enemies
        checkCollisions();

        // Draw everything
        batch.begin();
        enemySpawner.draw(batch);
        for (Bullet bullet : bullets) {
            bullet.draw(batch);
        }
        batch.end();
    }

    // Collision detection: Remove bullets & enemies on impact
    private void checkCollisions() {
        Iterator<Bullet> bulletIter = bullets.iterator();
        while (bulletIter.hasNext()) {
            Bullet bullet = bulletIter.next();
            Iterator<Enemy> enemyIter = enemySpawner.getEnemies().iterator();

            while (enemyIter.hasNext()) {
                Enemy enemy = enemyIter.next();
                if (bullet.getBounds().overlaps(enemy.getBounds())) {
                    bulletIter.remove();
                    enemyIter.remove();
                    break;
                }
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        enemySpawner.dispose();
        for (Bullet bullet : bullets) {
            bullet.dispose();
        }
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
