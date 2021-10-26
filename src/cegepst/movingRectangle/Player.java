package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(int x, int y) {
        teleport(x, y);
        setDimension(30, 60);
    }

    @Override
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

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.RED);
    }
}
