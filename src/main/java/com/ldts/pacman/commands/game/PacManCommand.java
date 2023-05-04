package com.ldts.pacman.commands.game;

import com.ldts.pacman.Game;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.graphics.Graphics;

public class PacManCommand extends GameCommand {
    public PacManCommand (Maze maze) {
        super(maze);
    }

    public void movePacManLeft() {
        movePacMan(getModel().getPacMan().getPosition().getLeft());
    }

    public void movePacManRight() {
        movePacMan(getModel().getPacMan().getPosition().getRight());
    }

    public void movePacManUp() {movePacMan(getModel().getPacMan().getPosition().getUp());}

    public void movePacManDown() {
        movePacMan(getModel().getPacMan().getPosition().getDown());
    }

    private void movePacMan (Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPacMan().setPosition(position);
            if (getModel().isGhost(position)) getModel().getPacMan().loseLife();
            if (getModel().isDot(position)){
                getModel().getPacMan().addScore();
                getModel().eatDot(position);
            }
        }
    }

    @Override
    public void step(Game game, Graphics.INPUT input, long time) {
        if (input == Graphics.INPUT.UP) movePacManUp();
        if (input == Graphics.INPUT.RIGHT) movePacManRight();
        if (input == Graphics.INPUT.DOWN) movePacManDown();
        if (input == Graphics.INPUT.LEFT) movePacManLeft();
    }
}
