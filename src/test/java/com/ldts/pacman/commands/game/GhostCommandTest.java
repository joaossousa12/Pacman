package com.ldts.pacman.commands.game;

import com.ldts.pacman.Game;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;
import com.ldts.pacman.models.game.maze.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GhostCommandTest {
    private GhostCommand ghostCommand;
    private Maze maze;
    private Game game;
    @BeforeEach
    void setUp(){
        maze = new Maze(10,10);
        PacMan pacMan = new PacMan(5, 5);
        maze.setPacMan(pacMan);
        maze.setMazeWalls(List.of());
        maze.setGhosts(List.of());
        maze.setDots(List.of());
        ghostCommand= new GhostCommand(maze);
        game= Mockito.mock(Game.class);
    }
    @Test
    void moveGhosts() {
        Ghost ghost = new Ghost(5,5);
        maze.setGhosts(List.of(ghost));
        ghostCommand.step(game, Graphics.INPUT.NONE, 1000);
        assertNotEquals(new Position(5,5),ghost.getPosition());
    }

    @Test
    void moveGhostsClosed(){
        Ghost ghost = new Ghost(5, 5);
        maze.setGhosts(List.of(ghost));
        maze.setMazeWalls(Arrays.asList(new MazeWall(4, 5), new MazeWall(6, 5), new MazeWall(5, 4), new MazeWall(5, 6)));

        for (int i = 0; i < 10; i++)
            ghostCommand.step(game, Graphics.INPUT.NONE, 1000);

        assertEquals(new Position(5, 5), ghost.getPosition());
    }
    @Test
    void moveGhostsGap() {
        Ghost ghost = new Ghost(5, 5);
        maze.setGhosts(List.of(ghost));
        maze.setMazeWalls(Arrays.asList(new MazeWall(4, 5), new MazeWall(6, 5), new MazeWall(5, 4)));

        long time = 0;

        while (ghost.getPosition().equals(new Position(5, 5))) {
            time += 500;
            ghostCommand.step(game, Graphics.INPUT.NONE, time);
        }

        assertEquals(new Position(5, 6), ghost.getPosition());
    }

}
