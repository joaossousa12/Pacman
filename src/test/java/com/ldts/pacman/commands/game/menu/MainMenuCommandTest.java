package com.ldts.pacman.commands.game.menu;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.menu.MainMenuCommand;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuCommandTest {
    private MainMenu mainMenu;
    private Game game;
    private MainMenuCommand mainMenuCommand;
    @BeforeEach
    public void setup() {
        mainMenu = new MainMenu();
        mainMenuCommand = new MainMenuCommand(mainMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    public void stepUpInput() throws IOException {
        mainMenuCommand.step(game, Graphics.INPUT.UP, 0);
        assertTrue(mainMenu.isSelectedExit());
        assertFalse(mainMenu.isSelectedStart());
    }

    @Test
    public void stepDownInput()throws IOException {
        mainMenuCommand.step(game, Graphics.INPUT.DOWN, 0);
        assertTrue(mainMenu.isSelectedExit());
        assertFalse(mainMenu.isSelectedStart());
    }

    @Test
    public void stepSelectInputExit()throws IOException {
        mainMenu.isSelectedExit();
        mainMenuCommand.step(game, Graphics.INPUT.SELECT, 0);
    }
}