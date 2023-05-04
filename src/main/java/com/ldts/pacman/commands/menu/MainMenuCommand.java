package com.ldts.pacman.commands.menu;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.Command;
import com.ldts.pacman.models.game.maze.CreateMazeBuilder;
import com.ldts.pacman.models.menu.MainMenu;
import com.ldts.pacman.states.GameState;
import com.ldts.pacman.graphics.Graphics;

import java.io.IOException;

public class MainMenuCommand extends Command<MainMenu> {
    public MainMenuCommand(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Game game, Graphics.INPUT input, long time) throws IOException {
        switch (input) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit())
                    game.setState(null);
                if (getModel().isSelectedStart())
                    game.setState(new GameState(new CreateMazeBuilder(1).createMaze()));
            }
        }
    }
}