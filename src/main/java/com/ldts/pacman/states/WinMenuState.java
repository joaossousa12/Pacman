package com.ldts.pacman.states;

import com.ldts.pacman.commands.Command;
import com.ldts.pacman.commands.menu.WinMenuCommand;
import com.ldts.pacman.models.menu.WinMenu;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.viewer.menu.WinMenuViewer;

public class WinMenuState extends State<WinMenu> {
    public WinMenuState(WinMenu winMenu){super(winMenu);}

    @Override
    protected Viewer<WinMenu> getViewer(){return new WinMenuViewer(getModel());}

    @Override
    protected Command<WinMenu> getCommand(){return new WinMenuCommand(getModel());}
}
