package cegepst.tank;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class TankGame extends Game {

    private GamePad gamePad;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        addKeyListener(gamePad); // TODO: Makes me puke
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
    }

    @Override
    public void draw(Buffer buffer) {

    }

    @Override
    public void conclude() {

    }
}
