package com.ldts.pacman.viewer;

import com.ldts.pacman.graphics.Graphics;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(Graphics graphics) throws IOException {
        graphics.clear();
        drawElements(graphics);
        graphics.refresh();
    }

    protected abstract void drawElements(Graphics graphics);
}

