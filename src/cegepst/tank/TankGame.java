package cegepst.tank;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.util.ArrayList;

public class TankGame extends Game {

    private GamePad gamePad;
    private Tank tank;
    private ArrayList<Missile> missiles;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            stop();
        }
        tank.update();
        if (gamePad.isFirePressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }
        for (Missile missile : missiles) {
            missile.update();
        }
    }

    @Override
    public void draw(Buffer buffer) {
        tank.draw(buffer);
        for (Missile missile : missiles) {
            missile.draw(buffer);
        }
    }

    @Override
    public void conclude() {

    }
}
