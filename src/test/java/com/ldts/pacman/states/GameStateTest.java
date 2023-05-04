package com.ldts.pacman.states;

import com.ldts.pacman.commands.game.MazeCommand;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {
    private GameState gameState;
    private Maze maze;

    @BeforeEach
    void setUp() {
        maze= new Maze(10,10);
        gameState= new GameState(maze);
    }

    @Test
    void getViewer() {
        assertTrue(gameState.getViewer() instanceof GameViewer);
    }

    @Test
    void getCommand() {
        assertTrue(gameState.getCommand() instanceof MazeCommand);
    }

    @Test
    public void getModel() {
        assertEquals(maze, gameState.getModel());
    }
}