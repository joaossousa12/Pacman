package com.ldts.pacman.models.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinMenuTest {
    private WinMenu winMenu;
    @BeforeEach
    void setUp(){
        winMenu=new WinMenu();
    }
    @Test
    void selectUp(){
        winMenu.nextEntry();
        winMenu.previousEntry();
        assertTrue(winMenu.isSelectedPlayAgain());
        assertFalse(winMenu.isSelectedExit());
    }
    @Test
    void selectDown(){
        winMenu.nextEntry();
        assertFalse(winMenu.isSelectedPlayAgain());
        assertTrue(winMenu.isSelectedExit());
    }
    @Test
    void initialState(){
        assertEquals(winMenu.getNumberEntries(), 2);
        assertEquals(winMenu.getEntry(0), "Again");
        assertEquals(winMenu.getEntry(1), "Exit ");
        assertFalse(winMenu.isSelectedExit());
        assertTrue(winMenu.isSelectedPlayAgain());
    }
}