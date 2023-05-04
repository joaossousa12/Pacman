package com.ldts.pacman.commands.menu;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.Command;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.maze.CreateMazeBuilder;
import com.ldts.pacman.models.menu.WinMenu;
import com.ldts.pacman.states.GameState;

import java.io.IOException;

public class WinMenuCommand extends Command<WinMenu> {
    public WinMenuCommand(WinMenu winMenu){super(winMenu);}


    @Override
    public void step(Game game, Graphics.INPUT input, long time) throws IOException {
        switch (input) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit())
                    game.setState(null);
                if (getModel().isSelectedPlayAgain())
                    game.setState(new GameState(new CreateMazeBuilder(1).createMaze()));
            }
        }
    }
}
