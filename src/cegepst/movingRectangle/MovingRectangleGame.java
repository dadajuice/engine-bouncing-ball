package cegepst.movingRectangle;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class MovingRectangleGame extends Game {

    private InputHandler inputHandler;
    private Player player;

    @Override
    public void initialize() {
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        player = new Player(100, 100);
    }

    @Override
    public void update() {
        player.update(inputHandler);
    }

    @Override
    public void draw(Buffer buffer) {
        player.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
