package dev.huytran.game.states;

import dev.huytran.game.Game;
import dev.huytran.game.entities.creatures.Player;
import dev.huytran.game.levels.Level;

import java.awt.*;

public class GameState extends State {

    private Level level;
    private Player player;

    public GameState(Game game) {
        super(game);
        level = new Level(game, "res/levels/level1.txt");
        player = new Player(game, 512, 512);
    }

    @Override
    public void tick() {
        game.getGameCamera().move(0, 1);
        level.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        level.render(g);
        player.render(g);
    }
}
