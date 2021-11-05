package cegepst.viking;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

public class VikingGame extends Game {

    private World world;
    private GamePad gamePad;
    private Player player;
    private Tree tree;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        world = new World();
        world.load();

        tree = new Tree(300, 350);

        player = new Player(gamePad);
        player.teleport(200, 200);
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        player.update();
        if (player.getY() < tree.getY() + 52) {
            tree.blockadeFromTop();
        } else {
            tree.blockadeFromBottom();
        }
    }

    @Override
    public void draw(Buffer buffer) {
        world.draw(buffer);
        if (player.getY() < tree.getY() + 52) { // 80 - 28 (max pour behind)
            player.draw(buffer);
            tree.draw(buffer);
        } else {
            tree.draw(buffer);
            player.draw(buffer);
        }
    }

    @Override
    public void conclude() {

    }
}
