package com.ldts.pacman.viewer.menu;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.menu.GameOverMenu;
import com.ldts.pacman.viewer.Viewer;

public class GameOverMenuViewer extends Viewer<GameOverMenu> {
    public GameOverMenuViewer(GameOverMenu gameOverMenu){super(gameOverMenu);}
    @Override
    public void drawElements(Graphics graphics) {

        graphics.drawBackground();
        graphics.drawText(new Position(2, 7), "     Game     ", "#FF0000", "#000000");
        graphics.drawText(new Position(2, 8), "     Over!    ", "#FF0000", "#000000");


        for (int i = 0; i < getModel().getNumberEntries(); i++)
            graphics.drawText(
                    new Position(7, 19 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#0000FF");
    }
}
