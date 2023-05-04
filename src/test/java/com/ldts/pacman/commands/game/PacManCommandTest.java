package com.ldts.pacman.commands.game;

import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;
import com.ldts.pacman.models.game.maze.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacManCommandTest {
    private PacManCommand pacManCommand;
    private PacMan pacMan;
    private Maze maze;
    @BeforeEach
    void setUp(){
        maze=new Maze(10,10);
        pacMan=new PacMan(5,5);
        maze.setPacMan(pacMan);
        maze.setMazeWalls(List.of());
        maze.setGhosts(List.of());
        maze.setDots(List.of());
        pacManCommand=new PacManCommand(maze);
    }
    @Test
    void movePacManUpEmpty(){
        pacManCommand.movePacManUp();
        assertEquals(new Position(5,4), pacMan.getPosition());
    }
    @Test
    void movePacManUpNotEmpty(){
        maze.setMazeWalls(List.of(new MazeWall(5, 4)));
        pacManCommand.movePacManUp();
        assertEquals(new Position(5,5), pacMan.getPosition());
    }
}
