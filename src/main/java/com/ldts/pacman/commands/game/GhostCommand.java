package com.ldts.pacman.commands.game;

import com.ldts.pacman.Game;
import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.graphics.Graphics;
public class GhostCommand extends GameCommand{
    private long lastMove;

    public GhostCommand(Maze maze) {
        super(maze);
        this.lastMove = 0;
    }

    @Override
    public void step(Game game, Graphics.INPUT input, long time) {
        if (time - lastMove > 500) {
            for (Ghost ghost : getModel().getGhosts())
                moveGhost(ghost, ghost.getPosition().getRandomNeighbour());
            this.lastMove = time;
        }
    }

    private void moveGhost(Ghost ghost, Position position) {
        if (getModel().isEmpty(position)) {
            ghost.setPosition(position);
            if (getModel().getPacMan().getPosition().equals(position)) {
                getModel().getPacMan().loseLife(); // if pacman touches a Ghost it loses a life
            }
        }
    }
}
