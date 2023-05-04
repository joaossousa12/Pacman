package com.ldts.pacman.commands.game.menu;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.menu.GameOverMenuCommand;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.menu.GameOverMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverMenuCommandTest {
    private GameOverMenuCommand gameOverMenuCommand;
    private GameOverMenu gameOverMenu;
    private Game game;
    @BeforeEach
    void setUp(){
        gameOverMenu = new GameOverMenu();
        gameOverMenuCommand = new GameOverMenuCommand(gameOverMenu);
        game = Mockito.mock(Game.class);
    }
    @Test
    public void stepUpInput() throws IOException {
        gameOverMenuCommand.step(game, Graphics.INPUT.UP, 0);
        assertTrue(gameOverMenu.isSelectedExit());
        assertFalse(gameOverMenu.isSelectedRetry());
    }
    @Test
    public void stepDownInput()throws IOException {
        gameOverMenuCommand.step(game, Graphics.INPUT.DOWN, 0);
        assertTrue(gameOverMenu.isSelectedExit());
        assertFalse(gameOverMenu.isSelectedRetry());
    }
    @Test
    public void stepSelectInputExit()throws IOException {
        gameOverMenu.isSelectedExit();
        gameOverMenuCommand.step(game, Graphics.INPUT.SELECT, 0);
    }
}