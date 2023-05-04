package com.ldts.pacman.states;

import com.ldts.pacman.commands.Command;
import com.ldts.pacman.commands.game.MazeCommand;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.viewer.Viewer;
import com.ldts.pacman.viewer.game.GameViewer;

public class GameState extends State<Maze> {
    public GameState (Maze maze) {
        super(maze);
    }
    @Override
    protected Viewer<Maze> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Command<Maze> getCommand() {
        return new MazeCommand(getModel());
    }

}
