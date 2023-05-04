package com.ldts.pacman.models.game.maze;

import com.ldts.pacman.models.game.elements.Dot;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMazeBuilder extends  MazeBuilder{

    private final Random rng;
    private final int width;
    private final int height;
    private final int numberOfGhosts;

    public RandomMazeBuilder(int width, int height, int numberOfGhosts) {
        this.rng = new Random();
        this.width = width;
        this.height = height;
        this.numberOfGhosts = numberOfGhosts;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<MazeWall> createMazeWalls() {
        List<MazeWall> mazeWalls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            mazeWalls.add(new MazeWall(x, 0));
            mazeWalls.add(new MazeWall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            mazeWalls.add(new MazeWall(0, y));
            mazeWalls.add(new MazeWall(width - 1, y));
        }

        return mazeWalls;
    }
    @Override
    protected List<Dot> createDots(){
        return new ArrayList<>();
    }
    @Override
    protected List<Ghost> createGhosts() {
        List<Ghost> ghosts = new ArrayList<>();

        while (ghosts.size() < numberOfGhosts) {
            ghosts.add(new Ghost(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
        }

        return ghosts;
    }

    @Override
    protected PacMan createPacMan() {
        return new PacMan(width / 2, height / 2);
    }

}
