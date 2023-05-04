package com.ldts.pacman;

import com.ldts.pacman.models.menu.CreateMenuBuilder;
import com.ldts.pacman.states.MainMenuState;
import com.ldts.pacman.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    @BeforeEach
    public void setUp() throws FontFormatException, IOException, URISyntaxException{
        game=new Game();
    }

    @Test
    void setState() throws IOException {
        State newState = new MainMenuState(new CreateMenuBuilder().createMenu());
        game.setState(newState);
        assertEquals(newState, game.getState());
    }

    @Test
    void start() {
        assertDoesNotThrow(()->game.startGame());
    }
}