package com.ldts.pacman.models.game.elements;

public class PacMan extends Element{
    private int lives;
    private int score;
    public PacMan(int x, int y){
        super(x,y);
        this.lives=3;
        this.score=0;
    }
    public void loseLife(){
        this.lives--;
    }

    public int getLife(){
        return lives;
    }
    public void addScore(){this.score+=10;}
    public int getScore(){return score;}
    public void setScore(int score){this.score=score;}
}
