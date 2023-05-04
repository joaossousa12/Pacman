package com.ldts.pacman.models.menu;

import com.ldts.pacman.models.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CreateMenuBuilder extends MenuBuilder {
    private final List<String> lines = new ArrayList<>();
    public CreateMenuBuilder() throws IOException {
        URL resource = CreateMenuBuilder.class.getResource("/menu/Menu.txt");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        for (String line; (line = br.readLine()) != null;) {
            lines.add(line);
        }
    }

    public List<Position> createYellow() {
        List<Position> Yellow = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'o')
                    Yellow.add(new Position(x, y));
        }
        return Yellow;
    }

    public List<Position> createBlack() {
        List<Position> Black = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B')
                    Black.add(new Position(x, y));
        }
        return Black;
    }

    public List<Position> createWhite() {
        List<Position> White = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'W')
                    White.add(new Position(x, y));
        }
        return White;
    }

    public List<Position> createBorder() {
        List<Position> Border = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') Border.add(new Position(x, y));
        }
        return Border;
    }
}
