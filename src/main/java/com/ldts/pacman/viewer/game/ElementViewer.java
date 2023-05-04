package com.ldts.pacman.viewer.game;

import com.ldts.pacman.models.game.elements.Element;
import com.ldts.pacman.graphics.Graphics;

public interface ElementViewer<T extends Element> {
    void draw(T element, Graphics graphics);
}
