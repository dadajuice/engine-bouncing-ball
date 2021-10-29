package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.controls.MovementController;

public class MovingRectangleGame extends Game {

    private GamePad controllerOne;
    private Player playerOne;

    @Override
    public void initialize() {
        controllerOne = new GamePad();
        addKeyListener(controllerOne);
        playerOne = new Player(controllerOne);
    }

    @Override
    public void update() {
        if (controllerOne.isQuitPressed()) {
            stop();
        }
        playerOne.update();
    }

    @Override
    public void draw(Buffer buffer) {
        playerOne.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
