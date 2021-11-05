package cegepst.viking;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class VikingGame extends Game {

    private World world;
    private GamePad gamePad;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        world = new World();
        world.load();
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
    }

    @Override
    public void draw(Buffer buffer) {
        world.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
