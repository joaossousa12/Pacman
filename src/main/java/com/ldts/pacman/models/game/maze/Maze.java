package com.ldts.pacman.models.game.maze;

import com.ldts.pacman.models.Position;
import com.ldts.pacman.models.game.elements.Dot;
import com.ldts.pacman.models.game.elements.Ghost;
import com.ldts.pacman.models.game.elements.MazeWall;
import com.ldts.pacman.models.game.elements.PacMan;

import java.util.List;

public class Maze {
    private final int width;
    private final int height;
    private PacMan pacMan;

    private List<MazeWall> mazeWalls;
    private List<Ghost> ghosts;
    private List<Dot> dots;

    public Maze (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public List<Ghost> getGhosts(){
        return ghosts;
    }
    public void setGhosts(List<Ghost> ghosts){
        this.ghosts=ghosts;
    }
    public List<Dot> getDots(){return dots;}
    public void setDots(List<Dot> dots){this.dots=dots;}
    public List<MazeWall> getMazeWalls(){
        return mazeWalls;
    }

    public void setMazeWalls(List<MazeWall> mazeWalls){
        this.mazeWalls=mazeWalls;
    }

    public boolean isEmpty(Position position) {
        for (MazeWall mazeWall : mazeWalls) if (mazeWall.getPosition().equals(position)) return false;
        return true;
    }

    public boolean isGhost(Position position) {
        for (Ghost ghost: ghosts)
            if (ghost.getPosition().equals(position)) return true;
        return false;
    }

    public boolean isDot(Position position){
        for (Dot dot : dots)
            if (dot.getPosition().equals(position)) return true;
        return false;
    }

    public List<Dot> eatDot(Position position){
        for (Dot dot : dots){
            if(dot.getPosition().equals(position)) {
                dots.remove(dot);
                break;
            }
        } return dots;
    }
}
