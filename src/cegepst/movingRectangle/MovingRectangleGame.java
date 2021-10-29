package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.controls.MovementController;

import java.awt.*;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private GamePad controllerOne;
    private Player playerOne;
    private ArrayList<Footprint> footprints;

    @Override
    public void initialize() {
        controllerOne = new GamePad();
        playerOne = new Player(controllerOne, Color.PINK);
        footprints = new ArrayList<>();
        addKeyListener(controllerOne);
    }

    @Override
    public void update() {
        if (controllerOne.isQuitPressed()) {
            stop();
        }
        playerOne.update();
        if (controllerOne.isMoving()) {
            footprints.add(playerOne.layFootprint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        playerOne.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
