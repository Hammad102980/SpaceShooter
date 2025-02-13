package com.mygdx.spaceshooter.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.spaceshooter.SpaceShooterGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Space Shooter");
        config.setWindowedMode(800, 600);  // Set your game window size (width x height)
        config.useVsync(true);  // Enable vertical sync to reduce screen tearing
        config.setResizable(false);  // Set to true if you want a resizable window
        config.setForegroundFPS(60);  // Target frame rate

        new Lwjgl3Application(new SpaceShooterGame(), config);
    }
}
