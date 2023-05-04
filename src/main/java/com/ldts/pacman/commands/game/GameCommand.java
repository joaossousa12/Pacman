package com.ldts.pacman.commands.game;

import com.ldts.pacman.commands.Command;
import com.ldts.pacman.models.game.maze.Maze;

public abstract class GameCommand extends Command<Maze> {
    public GameCommand(Maze maze) {
        super(maze);
    }
}
