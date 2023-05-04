package com.ldts.pacman.viewer.game;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.elements.Dot;

public class DotViewer implements ElementViewer<Dot> {
    @Override
    public void draw(Dot dot, Graphics graphics) {
        graphics.drawDots(dot.getPosition());
    }
}
