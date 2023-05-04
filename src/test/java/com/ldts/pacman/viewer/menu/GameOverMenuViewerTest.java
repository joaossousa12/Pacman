package com.ldts.pacman.viewer.menu;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameOverMenuViewerTest {
    private GameOverMenu gameOverMenu;
    private Graphics graphics;
    private GameOverMenuViewer gameOverMenuViewer;
    @BeforeEach
    public void setUp(){
        gameOverMenu = new GameOverMenu();
        gameOverMenuViewer=new GameOverMenuViewer(gameOverMenu);
        graphics = Mockito.mock(Graphics.class);
    }
    @Test
    void drawElements() {
        gameOverMenuViewer.drawElements(graphics);
        Mockito.verify(graphics).drawBackground();
        Mockito.verify(graphics).drawText(new Position(2, 7), "     Game     ", "#FF0000", "#000000");
        Mockito.verify(graphics).drawText(new Position(2, 8), "     Over!    ", "#FF0000", "#000000");
        for (int i = 0; i < gameOverMenu.getNumberEntries(); i++)
            Mockito.verify(graphics).drawText(new Position(7, 19 + i), gameOverMenu.getEntry(i), gameOverMenu.isSelected(i) ? "#FFD700" : "#FFFFFF", "#0000FF");
    }
}