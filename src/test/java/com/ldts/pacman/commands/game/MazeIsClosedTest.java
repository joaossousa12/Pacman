package com.ldts.pacman.commands.game;

import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.models.game.maze.Maze;
import com.ldts.pacman.models.game.maze.RandomMazeBuilder;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.util.List;

public class MazeIsClosedTest {
    @Property
    void allMazesClosed(@ForAll @IntRange(min = 3, max = 50) int width, @ForAll @IntRange(min = 3, max = 50) int height, @ForAll List<Graphics.@From("moveInputs") INPUT> inputs) {
        RandomMazeBuilder randomMazeBuilder = new RandomMazeBuilder(width,height,0);
        Maze maze = randomMazeBuilder.createMaze();
        PacManCommand pacManCommand = new PacManCommand(maze);

        for (Graphics.INPUT input : inputs){
            pacManCommand.step(null,input,100);
            assert (pacManCommand.getModel().getPacMan().getPosition().getX() > 0);
            assert (pacManCommand.getModel().getPacMan().getPosition().getY() > 0);
            assert (pacManCommand.getModel().getPacMan().getPosition().getX() < width-1);
            assert (pacManCommand.getModel().getPacMan().getPosition().getY() < height-1);
        }
    }
    @Provide
    Arbitrary<Graphics.INPUT> moveInputs(){
        return Arbitraries.of(Graphics.INPUT.UP,Graphics.INPUT.RIGHT,Graphics.INPUT.DOWN,Graphics.INPUT.LEFT);
    }
}
