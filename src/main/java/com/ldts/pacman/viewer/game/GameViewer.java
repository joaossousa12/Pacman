package com.ldts.pacman.viewer.game;

import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.elements.Element;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.graphics.Graphics;

import java.util.List;

public class GameViewer extends Viewer<Maze> {
    public GameViewer(Maze maze) {
        super(maze);
    }

    @Override
    public void drawElements(Graphics graphics) {
        drawElements(graphics, getModel().getMazeWalls(), new MazeWallViewer());
        drawElements(graphics, getModel().getDots(), new DotViewer());
        drawElements(graphics, getModel().getGhosts(), new GhostViewer());
        drawElement(graphics, getModel().getPacMan(), new PacManViewer());

        graphics.drawText(new Position(0, 0), "Lifes: " + getModel().getPacMan().getLife(), "#FFD700", "#000000");
        graphics.drawText(new Position(9,0), "Score:" + getModel().getPacMan().getScore(), "#3BB6CE", "#000000");
    }

    private <T extends Element> void drawElements(Graphics graphics, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(graphics, element, viewer);
    }

    private <T extends Element> void drawElement(Graphics graphics, T element, ElementViewer<T> viewer) {
        viewer.draw(element, graphics);
    }

}
