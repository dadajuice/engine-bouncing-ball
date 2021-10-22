package cegepst.movingRectangle;

import cegepst.engine.Buffer;

import java.awt.*;

public class Player {

    private int x;
    private int y;
    private int width;
    private int height;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        width = 30;
        height = 60;
    }

    public void update(InputHandler inputHandler) {
        if (inputHandler.isDownPressed()) {
            y += 4;
        } else if (inputHandler.isUpPressed()) {
            y -= 4;
        } else if (inputHandler.isLeftPressed()) {
            x -= 4;
        } else if (inputHandler.isRightPressed()) {
            x += 4;
        }
    }

    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.RED);
    }
}
