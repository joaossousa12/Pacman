package com.ldts.pacman.states;

import com.ldts.pacman.commands.menu.WinMenuCommand;
import com.ldts.pacman.models.menu.WinMenu;
import com.ldts.pacman.viewer.menu.WinMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinMenuStateTest {
    private WinMenuState winMenuState;
    private WinMenu winMenu;
    @BeforeEach
    void setUp(){
        winMenu=new WinMenu();
        winMenuState=new WinMenuState(winMenu);
    }

    @Test
    void getCommand() {
        assertTrue(winMenuState.getCommand() instanceof WinMenuCommand);
    }

    @Test
    void getModel() {
        assertEquals(winMenu, winMenuState.getModel());
    }

    @Test
    void getViewer() {
        assertTrue(winMenuState.getViewer() instanceof WinMenuViewer);
    }
}