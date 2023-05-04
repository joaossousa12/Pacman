package com.ldts.pacman.states;

import com.ldts.pacman.commands.Command;
import com.ldts.pacman.commands.menu.MainMenuCommand;
import com.ldts.pacman.models.menu.MainMenu;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.viewer.menu.MainMenuViewer;


public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Command<MainMenu> getCommand() {
        return new MainMenuCommand(getModel());
    }
}

