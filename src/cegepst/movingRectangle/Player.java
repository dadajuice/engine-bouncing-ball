package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    private final Color color;

    public Player(MovementController controller, Color color) {
        super(controller);
        teleport(100, 100);
        setDimension(30, 60);
        setSpeed(4);
        this.color = color;
    }

    public Footprint layFootprint() {
        return new Footprint(x, y);
    }

    @Override
    public void update() {
        moveAccordingToController();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, color);
    }
}
