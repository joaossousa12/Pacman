package com.ldts.pacman.models.game.maze;

import com.ldts.pacman.models.game.elements.Dot;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;

import java.util.List;

public abstract class MazeBuilder {
    public Maze createMaze(){
        Maze maze = new Maze(getWidth(), getHeight());

        maze.setPacMan(createPacMan());
        maze.setGhosts(createGhosts());
        maze.setMazeWalls(createMazeWalls());
        maze.setDots(createDots());

        return maze;
    }

    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract List<MazeWall> createMazeWalls();
    protected abstract List<Ghost> createGhosts();
    protected abstract PacMan createPacMan();
    protected abstract List<Dot> createDots();

}
