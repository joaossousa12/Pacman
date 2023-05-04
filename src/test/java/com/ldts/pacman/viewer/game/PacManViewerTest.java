package com.ldts.pacman.viewer.game;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.elements.PacMan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PacManViewerTest {
    private Graphics graphics;
    private PacMan pacMan;
    private PacManViewer pacManViewer;
    @BeforeEach
    void setUp(){
        pacMan=new PacMan(10,10);
        pacManViewer=new PacManViewer();
        graphics= Mockito.mock(Graphics.class);
    }
    @Test
    void drawElement(){
        pacManViewer.draw(pacMan,graphics);
        Mockito.verify(graphics, Mockito.times(1)).drawPacMan(pacMan.getPosition());
    }
}
