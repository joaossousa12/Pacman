package com.ldts.pacman.models.menu;

import java.util.Arrays;

public class GameOverMenu extends Menu{
    public GameOverMenu(){super(Arrays.asList("Retry","Exit "));}
    public boolean isSelectedRetry(){return isSelected(0);}
    public boolean isSelectedExit(){return isSelected(1);}
}
