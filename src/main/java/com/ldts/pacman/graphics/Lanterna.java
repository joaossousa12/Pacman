package com.ldts.pacman.graphics;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.ldts.pacman.models.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Lanterna implements Graphics {
    private final Screen screen;
    private int colorIndex=0;

    public Lanterna(Screen screen){
        this.screen=screen;
    }

    public Lanterna(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfiguration = loadpacfont();
        Terminal terminal=createTerminal(width,height,fontConfiguration);
        this.screen=createScreen(terminal);
    }



    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen= new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height+1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadpacfont() throws URISyntaxException, FontFormatException, IOException{
        URL resource= getClass().getClassLoader().getResource("gameFonts/pac.TTF");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsEnvironment.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 30);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    public Graphics.INPUT getNextInput() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null) return INPUT.NONE;

        if(keyStroke.getKeyType() == KeyType.EOF) return INPUT.QUIT;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return INPUT.QUIT;

        if(keyStroke.getKeyType() == KeyType.ArrowUp) return INPUT.UP;
        if(keyStroke.getKeyType() == KeyType.ArrowDown) return INPUT.DOWN;
        if(keyStroke.getKeyType() == KeyType.ArrowLeft) return INPUT.LEFT;
        if(keyStroke.getKeyType() == KeyType.ArrowRight) return INPUT.RIGHT;

        if(keyStroke.getKeyType() == KeyType.Enter) return INPUT.SELECT;

        return INPUT.NONE;
    }

    @Override
    public void drawBackground() {
        TextGraphics tg = screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        tg.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(19, 22), ' ');
    }

    @Override
    public void drawPacMenu(List<Position> yellow, List<Position> black, List<Position> white) {
        for (Position position: yellow)
            drawText(position, "o", "#FFFF00", "#FFFF00");
        for (Position position: black)
            drawText(position, "B", "#000000", "#000000");
        for (Position position: white)
            drawText(position, "W", "#FFFFFF", "#FFFFFF");
    }

    @Override
    public void drawBorder(List<Position> border) {
        for (Position position: border) {
            drawMazeWall(position);
        }
    }

    @Override
    public void drawPacMan(Position position){
        drawImage(position.getX(),position.getY(), 'C', "#FFFF00", "#000000");
    }

    @Override
    public void drawMazeWall(Position position){
        drawImage(position.getX(),position.getY(), '#', "#0000FF", "#0000FF");
    }
    ArrayList<String> color1 = new ArrayList<>(Arrays.asList("#FFA500","#FFB6C1","#FF0000","#ADD8E6"));
    @Override
    public void drawDots(Position position){drawImage(position.getX(),position.getY(), '.', "#FFFFFF", "#000000");}

    @Override
    public void drawGhost(Position position){drawImage(position.getX(),position.getY(), color1);}



    @Override
    public void drawText(Position position, String text, String color, String background) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.setBackgroundColor(TextColor.Factory.fromString(background));
        textGraphics.putString(position.getX(), position.getY(), text);
    }

    private void drawImage (int x, int y, char c, String color, String background) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
        tg.setBackgroundColor(TextColor.Factory.fromString(background));
    }

    private void drawImage (int x, int y, ArrayList<String> color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color.get(colorIndex)));
        colorIndex++;
        if(colorIndex==color.size()) colorIndex=0;
        tg.putString(x,y+1,""+ 'G');
    }

    @Override
    public void clear(){
        screen.clear();
    }

    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }

    @Override
    public void close() throws IOException{
        screen.close();
    }
}
