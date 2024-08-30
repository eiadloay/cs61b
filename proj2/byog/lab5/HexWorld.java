package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;

    private static int calcWidth(int s, int i) {
        int I = i;
        if (I >= s) {
            I = 2 * s - 1 - I;
        }
        return s + 2 * I;
    }

    private static void addRow(TETile[][] world, int x, int y, int width, TETile t) {
        int XI = x;
        for (int i = 0; i < width; i++) {
            world[XI++][y] = t;
        }
    }

    private static TETile randomTile() {
        Random r = new Random();
        int num = r.nextInt(6);
        return switch (num) {
            case 0 -> Tileset.WALL;
            case 1 -> Tileset.GRASS;
            case 2 -> Tileset.SAND;
            case 3 -> Tileset.WATER;
            case 4 -> Tileset.FLOWER;
            case 5 -> Tileset.TREE;
            default -> null;
        };
    }

    private static Point findTopRight(int x, int y, int s)  {
        int nx = x + calcWidth(s, s) - s + 1;
        int ny = y + s;
        if ((nx >= 0 && nx <= WIDTH) && (ny >= 0 && ny <= HEIGHT)) {
            return new Point(nx, ny);
        }
        return null;
    }
    private static Point findTopLeft(int x, int y, int s)  {
        int nx = x - (calcWidth(s, s) - s - 1);
        int ny = y + s;
        if ((nx >= 0 && nx <= WIDTH) && (ny >= 0 && ny <= HEIGHT)) {
            return new Point(nx, ny);
        }
        return null;
    }

    private static Point findBottomLeft(int x, int y, int s)  {
        int nx = x - calcWidth(s, s) + s - 1;
        int ny = y - s;
        if ((nx >= 0 && nx <= WIDTH) && (ny >= 0 && ny <= HEIGHT)) {
            return new Point(nx, ny);
        }
        return null;
    }

    private static Point findBottomRight(int x, int y, int s)  {
        int nx = x + (calcWidth(s, s) - s + 1);
        int ny = y - s;
        if ((nx >= 0 && nx <= WIDTH) && (ny >= 0 && ny <= HEIGHT)) {
            return new Point(nx, ny);
        }
        return null;
    }

    public static void addHexagon(TETile[][] w, int x, int y, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("Hexagon must be at least 2 in size.");
        }
        int currX = x;
        int currY = y;
        int currWidth;
        for (int i = 0; i < 2 * s; i++) {
            currWidth = calcWidth(s, i);
            addRow(w, currX, currY, currWidth, t);
            if (i < s - 1) {
                currX--;
            } else if (i >= s) {
                currX++;
            }
            currY++;
        }
    }

    private static void drawRandomHexagons(TETile[][] world, int s, int x, int y, int n) {

    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        int s = 3;
        int x = s - 1;
        int y = 5;
        addHexagon(world, x, y, s, randomTile());
        addHexagon(world, x, y + (s * 2), s, randomTile());
        addHexagon(world, x, y + 2 * (s * 2), s, randomTile());

        ter.renderFrame(world);
    }

}