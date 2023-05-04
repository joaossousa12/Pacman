package com.ldts.pacman.states;

import com.ldts.pacman.commands.menu.MainMenuCommand;
import com.ldts.pacman.models.menu.MainMenu;
import com.ldts.pacman.viewer.menu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuStateTest {
    private MainMenu mainMenu;
    private MainMenuState mainMenuState;
    @BeforeEach
    void setUp(){
        mainMenu=new MainMenu();
        mainMenuState= new MainMenuState(mainMenu);
    }
    @Test
    void getViewer() {
        assertTrue(mainMenuState.getViewer() instanceof MainMenuViewer);
    }

    @Test
    void getCommand() {
        assertTrue(mainMenuState.getCommand() instanceof MainMenuCommand);
    }
    @Test
    void getModel() {
        assertEquals(mainMenu, mainMenuState.getModel());
    }
}