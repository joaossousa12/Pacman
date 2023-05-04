package com.ldts.pacman.states;

import com.ldts.pacman.commands.menu.GameOverMenuCommand;
import com.ldts.pacman.models.menu.GameOverMenu;
import com.ldts.pacman.viewer.menu.GameOverMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverMenuStateTest {
    private GameOverMenu gameOverMenu;
    private GameOverMenuState gameOverMenuState;
    @BeforeEach
    void setUp(){
        gameOverMenu=new GameOverMenu();
        gameOverMenuState=new GameOverMenuState(gameOverMenu);
    }
    @Test
    void getViewer() {
        assertTrue(gameOverMenuState.getViewer() instanceof GameOverMenuViewer);
    }

    @Test
    void getCommand() {
        assertTrue(gameOverMenuState.getCommand() instanceof GameOverMenuCommand);
    }
    @Test
    void getModel() {
        assertEquals(gameOverMenu, gameOverMenuState.getModel());
    }
}