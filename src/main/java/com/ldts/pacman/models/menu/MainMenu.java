package com.ldts.pacman.models.menu;

import java.util.Arrays;

public class MainMenu extends Menu {
    public MainMenu() {
        super(Arrays.asList("Start", "Exit "));
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }
}
