package com.mygdx.spaceshooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceShooterGame extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));  // Start with GameScreen
    }

    @Override
    public void render() {
        super.render();  // Delegate rendering to the current screen
    }

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}
