package cegepst.viking;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class VikingGame extends Game {

    private World world;
    private GamePad gamePad;
    private Player player;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        world = new World();
        world.load();
        player = new Player(gamePad);
        player.teleport(100, 300);
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
    }

    @Override
    public void draw(Buffer buffer) {
        world.draw(buffer);
        player.draw(buffer);
    }

    @Override
    public void conclude() {

    }
}
