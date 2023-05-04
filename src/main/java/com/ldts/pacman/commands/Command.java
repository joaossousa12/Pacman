package com.ldts.pacman.commands;

import com.ldts.pacman.Game;
import com.ldts.pacman.graphics.Graphics;

import java.io.IOException;

public abstract class Command<T> {
    private final T model;

    public Command(T model){
        this.model=model;
    }

    public T getModel(){
        return model;
    }

    public abstract void step(Game game, Graphics.INPUT input, long time) throws IOException;
}
