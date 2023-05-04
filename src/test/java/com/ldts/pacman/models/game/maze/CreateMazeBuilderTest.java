package com.ldts.pacman.models.game.maze;

import com.ldts.pacman.models.game.elements.PacMan;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CreateMazeBuilderTest {
    @Test
    void test() throws IOException {
        CreateMazeBuilder createMazeBuilder = new CreateMazeBuilder(1);
        assertEquals(createMazeBuilder.getHeight(),21);
        assertEquals(createMazeBuilder.getWidth(),19);

        assertEquals(createMazeBuilder.createMazeWalls().size(), 200);
        assertEquals(createMazeBuilder.createDots().size(), 179);
        assertEquals(createMazeBuilder.createGhosts().size(), 4);

        PacMan pacMan = createMazeBuilder.createPacMan();
        assertNotNull(pacMan);
        assertEquals(pacMan.getPosition().getY(), 9);
        assertEquals(pacMan.getPosition().getX(), 9);
    }
}