package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(int x, int y) {
        teleport(x, y);
        setDimension(30, 60);
        setSpeed(4);
    }

    @Override
    public void update(InputHandler inputHandler) {
        if (inputHandler.isDownPressed()) {
            moveDown();
        } else if (inputHandler.isUpPressed()) {
            moveUp();
        } else if (inputHandler.isLeftPressed()) {
            moveLeft();
        } else if (inputHandler.isRightPressed()) {
            moveRight();
        }
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.RED);
    }
}
