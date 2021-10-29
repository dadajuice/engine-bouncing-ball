package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.controls.MovementController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private GamePad controllerOne;
    private GamePad controllerTwo;
    private Player playerOne;
    private Player playerTwo;
    private ArrayList<Footprint> footprints;

    @Override
    public void initialize() {
        controllerOne = new GamePad();
        controllerTwo = new GamePad();
        controllerTwo.setUpKey(KeyEvent.VK_W);
        controllerTwo.setDownKey(KeyEvent.VK_S);
        controllerTwo.setLeftKey(KeyEvent.VK_A);
        controllerTwo.setRightKey(KeyEvent.VK_D);

        playerOne = new Player(controllerOne, Color.PINK);
        playerTwo = new Player(controllerTwo, Color.GREEN);

        footprints = new ArrayList<>();
        addKeyListener(controllerOne);
        addKeyListener(controllerTwo);
    }

    @Override
    public void update() {
        if (controllerOne.isQuitPressed()) {
            stop();
        }
        playerOne.update();
        playerTwo.update();
        if (controllerOne.isMoving()) {
            footprints.add(playerOne.layFootprint());
        }
        if (controllerTwo.isMoving()) {
            footprints.add(playerTwo.layFootprint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        playerOne.draw(buffer);
        playerTwo.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
