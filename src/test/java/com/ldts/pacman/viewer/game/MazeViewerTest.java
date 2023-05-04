package com.ldts.pacman.viewer.game;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.elements.Dot;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;
import com.ldts.pacman.models.game.maze.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class MazeViewerTest {
    private Graphics graphics;
    private GameViewer gameViewer;

    @BeforeEach
    void setUp(){
        Maze maze = new Maze(10, 10);
        graphics= Mockito.mock(Graphics.class);
        gameViewer=new GameViewer(maze);
        maze.setMazeWalls(Arrays.asList(new MazeWall(1,2), new MazeWall(2,3), new MazeWall(3,4)));
        maze.setGhosts(Arrays.asList(new Ghost(4,5), new Ghost(5,6), new Ghost(7,8), new Ghost(8,9)));
        maze.setPacMan(new PacMan(5,8));
        maze.setDots(Arrays.asList(new Dot(5,5), new Dot(6,6)));
    }
    @Test
    void drawMazeWalls() throws IOException{
        gameViewer.draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).drawMazeWall(new Position(1,2));
        Mockito.verify(graphics, Mockito.times(1)).drawMazeWall(new Position(2,3));
        Mockito.verify(graphics, Mockito.times(1)).drawMazeWall(new Position(3,4));
        Mockito.verify(graphics, Mockito.times(3)).drawMazeWall(Mockito.any(Position.class));
    }
    @Test
    void drawGhosts() throws IOException{
        gameViewer.draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).drawGhost(new Position(4,5));
        Mockito.verify(graphics, Mockito.times(1)).drawGhost(new Position(5,6));
        Mockito.verify(graphics, Mockito.times(1)).drawGhost(new Position(7,8));
        Mockito.verify(graphics, Mockito.times(1)).drawGhost(new Position(8,9));
        Mockito.verify(graphics, Mockito.times(4)).drawGhost(Mockito.any(Position.class));
    }
    @Test
    void drawPacMan() throws IOException{
        gameViewer.draw(graphics);
        Mockito.verify(graphics,Mockito.times(1)).drawPacMan(new Position(5,8));
        Mockito.verify(graphics, Mockito.times(1)).drawPacMan(Mockito.any(Position.class));
    }
    @Test
    void drawDots() throws IOException{
        gameViewer.draw(graphics);
        Mockito.verify(graphics,Mockito.times(1)).drawDots(new Position(5,5));
        Mockito.verify(graphics,Mockito.times(1)).drawDots(new Position(6,6));
        Mockito.verify(graphics,Mockito.times(2)).drawDots(Mockito.any(Position.class));
    }
    @Test
    void refreshAndClear() throws IOException{
        gameViewer.draw(graphics);
        Mockito.verify(graphics, Mockito.times(1)).clear();
        Mockito.verify(graphics,Mockito.times(1)).refresh();
    }
}
