package com.ldts.pacman;

import com.ldts.pacman.models.menu.CreateMenuBuilder;
import com.ldts.pacman.states.MainMenuState;
import com.ldts.pacman.states.State;
import com.ldts.pacman.graphics.Lanterna;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final Lanterna graphics;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException{
        this.graphics = new Lanterna(19,21);
        this.state = new MainMenuState(new CreateMenuBuilder().createMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState(){return this.state;}

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, graphics, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        graphics.close();
    }
    public void startGame() throws IOException {
        start();
    }
}



