package com.ldts.pacman.graphics;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.ldts.pacman.models.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaTest {
    private Screen screen;
    private Lanterna lanterna;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        lanterna = new Lanterna(screen);
    }

    @Test
    void drawPacMan(){
        lanterna.drawPacMan(new Position(1, 1));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,255,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1,2,"C");
    }

    @Test
    void drawText() {
        lanterna.drawText(new Position(5, 4), "PacMan: ","#FFFF00", "#FFFF00");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(5, 4, "PacMan: ");
    }
    @Test
    void refresh() throws IOException {
        lanterna.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
    @Test
    void drawBackground() {
        lanterna.drawBackground();
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        Mockito.verify(textGraphics, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(19, 22), ' ');
    }
}
