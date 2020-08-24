package dev.huytran.game.states;

import dev.huytran.game.gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    public MenuState() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1024, 1024);
        g.drawImage(Assets.title, 0, 0, null);
    }
}