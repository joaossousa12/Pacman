package com.ldts.pacman.states;

import com.ldts.pacman.Game;
import com.ldts.pacman.commands.Command;
import com.ldts.pacman.graphics.Graphics;
import com.ldts.pacman.viewer.Viewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class StateTest {
    private static final Graphics.INPUT INPUT = Graphics.INPUT.UP;
    @Test
    void step() throws IOException {
        Game game = mock(Game.class);
        Graphics graphics = mock(Graphics.class);
        Command command = mock(Command.class);

        when(graphics.getNextInput()).thenReturn(INPUT);

        TestState testState = new TestState(command);

        testState.step(game,graphics,100);

        verify(command).step(game, INPUT, 100);
    }
    private static class TestState extends State<Command> {

        public TestState(Command command) {
            super(command);
        }

        @Override
        protected Viewer<Command> getViewer() {
            return mock(Viewer.class);
        }

        @Override
        protected Command getCommand() {
            return getModel();
        }
    }
}