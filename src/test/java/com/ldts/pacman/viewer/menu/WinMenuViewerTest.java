package com.ldts.pacman.viewer.menu;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.menu.WinMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WinMenuViewerTest {
    private WinMenuViewer winMenuViewer;
    private Graphics graphics;
    private WinMenu winMenu;
    @BeforeEach
    public void setUp(){
        winMenu = new WinMenu();
        winMenuViewer = new WinMenuViewer(winMenu);
        graphics = Mockito.mock(Graphics.class);
    }
    @Test
    void drawElements() {
        winMenuViewer.drawElements(graphics);
        Mockito.verify(graphics).drawBackground();
        Mockito.verify(graphics).drawText(new Position(3, 8), "     You     ", "#00FF00", "#0000FF");
        Mockito.verify(graphics).drawText(new Position(3, 9), "     Won!    ", "#00FF00", "#0000FF");
        for (int i = 0; i < winMenu.getNumberEntries(); i++)
            Mockito.verify(graphics).drawText(new Position(7, 19 + i), winMenu.getEntry(i), winMenu.isSelected(i) ? "#FFD700" : "#FFFFFF", "#0000FF");
    }
}