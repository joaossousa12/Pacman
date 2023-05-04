package com.ldts.pacman.models.menu;

import com.ldts.pacman.models.Position;

import java.util.List;

public abstract class Menu {
    private List<Position> Yellow;
    private List<Position> Black;
    private List<Position> White;
    private List<Position> Border;
    private final List<String> entries;
    private int currentEntry = 0;
    public Menu(List<String> entries) {this.entries = entries;}
    public int getNumberEntries() {return entries.size();}
    public String getEntry(int i) {return entries.get(i);}
    public List<Position> getYellow() {return Yellow;}
    public List<Position> getBlack() {return Black;}
    public List<Position> getWhite() {return White;}
    public List<Position> getBorder() {return Border;}
    public void setYellow(List<Position> Yellow) {this.Yellow = Yellow;}
    public void setBlack(List<Position> Black) {this.Black = Black;}
    public void setWhite(List<Position> White) {this.White = White;}
    public void setBorder(List<Position> Border) {this.Border = Border;}
    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public boolean isSelected(int i) {return currentEntry == i;}

}
