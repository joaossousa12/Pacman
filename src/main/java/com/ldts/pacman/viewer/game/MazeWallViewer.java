package com.ldts.pacman.viewer.game;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.elements.MazeWall;

public class MazeWallViewer implements ElementViewer<MazeWall> {
    @Override
    public void draw(MazeWall mazeWall, Graphics graphics) {
        graphics.drawMazeWall(mazeWall.getPosition());
    }
}
