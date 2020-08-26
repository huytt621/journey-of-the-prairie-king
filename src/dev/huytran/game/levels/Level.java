package dev.huytran.game.levels;

import dev.huytran.game.tiles.Tile;
import dev.huytran.game.utils.Utils;

import java.awt.*;

public class Level {

    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    public Level(String path) {
        loadLevel(path);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile tile = Tile.tiles[this.tiles[x][y]];
        return tile != null ? tile : Tile.dirtTile;
    }

    private void loadLevel(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

}