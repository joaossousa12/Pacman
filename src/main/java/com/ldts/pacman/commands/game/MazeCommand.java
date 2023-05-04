package com.ldts.pacman.commands.game;

import com.ldts.pacman.Game;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.models.menu.CreateMenuBuilder;
import com.ldts.pacman.states.GameOverMenuState;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.states.WinMenuState;

import java.io.IOException;

public class MazeCommand extends GameCommand {
    private final PacManCommand pacManCommand;
    private final GhostCommand ghostCommand;

    public MazeCommand(Maze maze) {
        super(maze);
        this.pacManCommand = new PacManCommand(maze);
        this.ghostCommand = new GhostCommand(maze);
    }

    public void step (Game game, Graphics.INPUT input, long time) throws IOException {
        if (input == Graphics.INPUT.QUIT || getModel().getPacMan().getLife() == 0)
            game.setState(new GameOverMenuState(new CreateMenuBuilder().createGameOverMenu()));
        if(getModel().getPacMan().getScore()==1790){
            game.setState(new WinMenuState(new CreateMenuBuilder().createWinMenu()));
        }
        else {
            pacManCommand.step(game, input, time);
            ghostCommand.step(game, input, time);
        }
    }

}
