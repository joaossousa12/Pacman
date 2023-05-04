package com.ldts.pacman.models.menu;

import java.util.Arrays;

public class WinMenu extends Menu{
    public WinMenu(){super(Arrays.asList("Again","Exit "));}
    public boolean isSelectedPlayAgain(){return isSelected(0);}
    public boolean isSelectedExit(){return isSelected(1);}
}
