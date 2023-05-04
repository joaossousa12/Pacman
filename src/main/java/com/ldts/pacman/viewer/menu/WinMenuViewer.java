package com.ldts.pacman.viewer.menu;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.menu.WinMenu;
import com.ldts.pacman.viewer.Viewer;

public class WinMenuViewer extends Viewer<WinMenu> {
    public WinMenuViewer(WinMenu winMenu){super(winMenu);}
    @Override
    public void drawElements(Graphics graphics) {
        graphics.drawBackground();
        graphics.drawText(new Position(3, 8), "     You     ", "#00FF00", "#0000FF");
        graphics.drawText(new Position(3, 9), "     Won!    ", "#00FF00", "#0000FF");


        for (int i = 0; i < getModel().getNumberEntries(); i++)
            graphics.drawText(
                    new Position(7, 19 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#0000FF");
    }
}
