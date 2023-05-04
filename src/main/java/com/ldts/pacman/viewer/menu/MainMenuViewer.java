package com.ldts.pacman.viewer.menu;

import com.ldts.pacman.models.menu.MainMenu;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(Graphics graphics) {
        graphics.drawBackground();
        graphics.drawPacMenu(getModel().getYellow(), getModel().getBlack(), getModel().getWhite());


        graphics.drawText(new Position(3, 1), "PacMan:      ", "#FFFF00", "#0000FF");
        graphics.drawText(new Position(3, 2), "Lost In Java ", "#FFFF00", "#0000FF");


        for (int i = 0; i < getModel().getNumberEntries(); i++)
            graphics.drawText(
                    new Position(7, 19 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#0000FF");
    }
}

