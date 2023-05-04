package com.ldts.pacman.viewer.game;


import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.elements.Ghost;

public class GhostViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost ghost, Graphics graphics) {
        graphics.drawGhost(ghost.getPosition());
    }
}
