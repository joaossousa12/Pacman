package com.ldts.pacman.models.menu;

import com.ldts.pacman.models.Position;

import java.util.List;


public abstract class MenuBuilder {
    public MainMenu createMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setYellow(createYellow());
        mainMenu.setBlack(createBlack());
        mainMenu.setWhite(createWhite());
        mainMenu.setBorder(createBorder());
        return mainMenu;
    }

    public GameOverMenu createGameOverMenu() {
        GameOverMenu gameOverMenu = new GameOverMenu();
        gameOverMenu.setBorder(createBorder());
        return gameOverMenu;
    }

    public WinMenu createWinMenu(){
        WinMenu winMenu = new WinMenu();
        winMenu.setBorder(createBorder());
        return winMenu;
    }

    protected abstract List<Position> createYellow();
    protected abstract List<Position> createBlack();
    protected abstract List<Position> createWhite();
    protected abstract List<Position> createBorder();
}
