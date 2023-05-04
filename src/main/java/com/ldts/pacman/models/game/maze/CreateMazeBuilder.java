package com.ldts.pacman.models.game.maze;

import com.ldts.pacman.models.game.elements.Dot;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CreateMazeBuilder extends MazeBuilder {
    private final List<String> lines;

    public CreateMazeBuilder(int level) throws IOException {

        URL resource = CreateMazeBuilder.class.getResource("/levels/level" + level + ".lvl");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines (BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null;) lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width  = 0;
        for (String line: lines) width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight () {
        return lines.size();
    }

    @Override
    protected List<MazeWall> createMazeWalls() {
        List<MazeWall> mazeWalls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') mazeWalls.add(new MazeWall(x, y));
            }
        } return mazeWalls;
    }
    @Override
    protected List<Dot> createDots(){
        List<Dot> dots = new ArrayList<>();

        for(int y=0; y < lines.size(); y++){
            String line = lines.get(y);
            for(int x = 0; x < line.length(); x++){
                if(line.charAt(x) == '.') dots.add(new Dot(x,y));
            }
        } return dots;
    }
    @Override
    protected List<Ghost> createGhosts() {
        List<Ghost> ghosts = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'G') ghosts.add(new Ghost(x, y));
            }
        } return ghosts;
    }

    @Override
    protected PacMan createPacMan() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'C') return new PacMan(x, y);
            }
        } return null;

    }
}
