package com.ldts.pacman.graphics;

import com.ldts.pacman.models.Position;

import java.io.IOException;
import java.util.List;

public interface Graphics {
    INPUT getNextInput() throws IOException;

    void drawBackground();

    void drawPacMenu(List<Position> yellow, List<Position> black, List<Position> white);

    void drawBorder(List<Position> border);

    void drawPacMan(Position position);

    void drawMazeWall(Position position);

    void drawDots(Position position);

    void drawGhost(Position position);

    void drawText(Position position, String text, String color, String background);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum INPUT {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
