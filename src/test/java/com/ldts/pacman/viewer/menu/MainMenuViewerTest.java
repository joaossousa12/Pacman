package com.ldts.pacman.viewer.menu;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuViewerTest {
    private MainMenu mainMenu;
    private MainMenuViewer mainMenuViewer;
    private Graphics graphics;
    @BeforeEach
    public void setUp(){
        mainMenu = new MainMenu();
        mainMenuViewer = new MainMenuViewer(mainMenu);
        graphics = Mockito.mock(Graphics.class);
    }
    @Test
    void drawElements() {
        mainMenuViewer.drawElements(graphics);
        Mockito.verify(graphics).drawBackground();
        Mockito.verify(graphics).drawPacMenu(mainMenu.getYellow(), mainMenu.getBlack(), mainMenu.getWhite());
        Mockito.verify(graphics).drawText(new Position(3, 1), "PacMan:      ", "#FFFF00", "#0000FF");
        Mockito.verify(graphics).drawText(new Position(3, 2), "Lost In Java ", "#FFFF00", "#0000FF");
        for (int i = 0; i < mainMenu.getNumberEntries(); i++)
            Mockito.verify(graphics).drawText(new Position(7, 19 + i), mainMenu.getEntry(i), mainMenu.isSelected(i) ? "#FFD700" : "#FFFFFF", "#0000FF");
    }
}