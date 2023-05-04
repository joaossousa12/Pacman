package com.ldts.pacman.states;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.Command;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.graphics.Graphics;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Command<T> command;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.command = getCommand();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Command<T> getCommand();

    public T getModel() {
        return model;
    }

    public void step(Game game, Graphics graphics, long time) throws IOException {
        Graphics.INPUT input = graphics.getNextInput();
        command.step(game, input, time);
        viewer.draw(graphics);
    }
}
