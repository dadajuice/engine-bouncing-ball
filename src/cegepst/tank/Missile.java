package cegepst.tank;

import cegepst.engine.Buffer;
import cegepst.engine.controls.Direction;
import cegepst.engine.entities.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {

    private final Direction tankDirection;

    public Missile(Tank tank) {
        tankDirection = tank.getDirection();
        setSpeed(5);
        switch (tankDirection) {
            case RIGHT:
                teleport(tank.getX() + tank.getWidth() + 1,
                        tank.getY() + 15 - 2);
                setDimension(8, 4);
                break;

            case LEFT:
                teleport(tank.getX() - 9,
                        tank.getY() + 15 - 2);
                setDimension(8, 4);
                break;

            case UP:
                teleport(tank.getX() + 15 - 2,
                        tank.getY() - 9);
                setDimension(4, 8);
                break;

            case DOWN:
                teleport(tank.getX() + 15 - 2,
                        tank.getY() + tank.getHeight() + 1);
                setDimension(4, 8);
                break;
        }
    }

    @Override
    public void update() {
        move(tankDirection);
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.YELLOW);
    }
}
