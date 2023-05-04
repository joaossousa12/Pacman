package com.ldts.pacman.viewer.game;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.elements.PacMan;

public class PacManViewer implements ElementViewer<PacMan>{
    @Override
    public void draw(PacMan pacMan, Graphics graphics) {
        graphics.drawPacMan(pacMan.getPosition());
    }
}
