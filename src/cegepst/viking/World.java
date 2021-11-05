package cegepst.viking;

import cegepst.engine.Buffer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class World {

    private static final String MAP_PATH = "images/demo.png";
    private Image background;

    public void draw(Buffer buffer) {
        buffer.drawImage(background, 0, -64);
    }

    public void load() {
        try {
            background = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(MAP_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
