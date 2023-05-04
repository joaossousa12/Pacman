package com.ldts.pacman.states;

import com.ldts.pacman.commands.Command;
import com.ldts.pacman.commands.menu.GameOverMenuCommand;
import com.ldts.pacman.models.menu.GameOverMenu;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends State<GameOverMenu>{
    public GameOverMenuState(GameOverMenu gameOverMenu){super(gameOverMenu);}
    @Override
    protected Viewer<GameOverMenu> getViewer(){return new GameOverMenuViewer(getModel());}
    @Override
    protected Command<GameOverMenu> getCommand() {return new GameOverMenuCommand(getModel());}
}
