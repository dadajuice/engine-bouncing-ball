package cegepst.viking;

import cegepst.engine.Buffer;
import cegepst.engine.entities.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticEntity {

    private static final String SPRITE_SHEET_PATH = "images/tree.png";
    private Image image;
    private Blockade blockade;

    public Tree(int x, int y) {
        teleport(x, y);
        blockade = new Blockade();
        blockade.setDimension(30, 16);
        blockade.teleport(x + 16, y + 64);
        load();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawImage(image, x, y);
        blockade.draw(buffer);
    }

    private void load() {
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(SPRITE_SHEET_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
