package com.ldts.pacman.commands.game;

import com.ldts.pacman.Game;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.elements.Dot;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.states.GameOverMenuState;
import com.ldts.pacman.states.GameState;
import com.ldts.pacman.states.WinMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class MazeCommandTest {
    private MazeCommand mazeCommand;
    private Maze maze;
    @BeforeEach
    public void setUp() {
        maze = new Maze(10,10);
        mazeCommand = new MazeCommand(maze);
    }
    @Test
    public void gameOver() throws Exception {
        Game game = new Game();
        maze.setPacMan(new PacMan(5,5));
        List<MazeWall> mazeWalls = new ArrayList<>();
        mazeWalls.add(new MazeWall(2,2));
        maze.setMazeWalls(mazeWalls);
        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ghost(3,3));
        maze.setGhosts(ghosts);
        List<Dot> dots = new ArrayList<>();
        dots.add(new Dot(1,1));
        maze.setDots(dots);
        game.setState(new GameState(maze));
        mazeCommand.step(game, Graphics.INPUT.QUIT, 0);
        assertTrue(game.getState() instanceof GameOverMenuState);
        //lose the 3 lifes
        maze.getPacMan().loseLife();
        maze.getPacMan().loseLife();
        maze.getPacMan().loseLife();
        mazeCommand.step(game, Graphics.INPUT.UP, 0);
        assertTrue(game.getState() instanceof GameOverMenuState);
    }
    @Test
    void win() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        maze.setPacMan(new PacMan(5,5));
        List<MazeWall> mazeWalls = new ArrayList<>();
        mazeWalls.add(new MazeWall(2,2));
        maze.setMazeWalls(mazeWalls);
        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ghost(3,3));
        maze.setGhosts(ghosts);
        List<Dot> dots = new ArrayList<>();
        dots.add(new Dot(1,1));
        maze.setDots(dots);
        game.setState(new GameState(maze));
        maze.getPacMan().setScore(1790);
        mazeCommand.step(game, Graphics.INPUT.UP, 0);
        assertTrue(game.getState() instanceof WinMenuState);
    }

}