package com.ldts.pacman.commands.game.menu;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.menu.WinMenuCommand;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.menu.WinMenu;
import com.ldts.pacman.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WinMenuCommandTest {
    private WinMenuCommand winMenuCommand;
    private Game game;
    private WinMenu winMenu;
    @BeforeEach
    public void setUp(){
        winMenu=new WinMenu();
        winMenuCommand=new WinMenuCommand(winMenu);
        game= Mockito.mock(Game.class);
    }
    @Test
    void stepUpInput() throws IOException {
        winMenuCommand.step(game, Graphics.INPUT.UP, 0);
        assertTrue(winMenu.isSelectedExit());
        assertFalse(winMenu.isSelectedPlayAgain());
    }

    @Test
    void stepDownInput() throws IOException{
        winMenuCommand.step(game, Graphics.INPUT.DOWN, 0);
        assertTrue(winMenu.isSelectedExit());
        assertFalse(winMenu.isSelectedPlayAgain());
    }

    @Test
    void stepSelectInput() throws IOException{
        winMenu.isSelectedPlayAgain();
        winMenuCommand.step(game, Graphics.INPUT.SELECT, 0);
        Mockito.verify(game).setState(Mockito.argThat(gameState -> gameState instanceof GameState && gameState.getModel() != null));
    }
}