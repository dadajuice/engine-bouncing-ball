package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.controls.MovementController;

public class MovingRectangleGame extends Game {

    private MovementController inputHandler;
    private Player player;

    @Override
    public void initialize() {
        inputHandler = new MovementController();
        addKeyListener(inputHandler);
        player = new Player(inputHandler);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void draw(Buffer buffer) {
        player.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
