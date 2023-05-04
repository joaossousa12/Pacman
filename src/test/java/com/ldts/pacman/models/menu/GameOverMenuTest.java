package com.ldts.pacman.models.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverMenuTest {
    private GameOverMenu gameOverMenu;
    @BeforeEach
    void setUp(){
        gameOverMenu=new GameOverMenu();
    }
    @Test
    void selectDown(){
        gameOverMenu.nextEntry();
        assertFalse(gameOverMenu.isSelectedRetry());
        assertTrue(gameOverMenu.isSelectedExit());
    }
    @Test
    void selectUp(){
        gameOverMenu.nextEntry();
        gameOverMenu.previousEntry();
        assertTrue(gameOverMenu.isSelectedRetry());
        assertFalse(gameOverMenu.isSelectedExit());
    }
    @Test
    void initialState(){
        assertEquals(gameOverMenu.getNumberEntries(), 2);
        assertEquals(gameOverMenu.getEntry(0), "Retry");
        assertEquals(gameOverMenu.getEntry(1), "Exit ");
        assertFalse(gameOverMenu.isSelectedExit());
        assertTrue(gameOverMenu.isSelectedRetry());
    }
}