package cegepst.tank;

import cegepst.engine.Buffer;
import cegepst.engine.CollidableRepository;
import cegepst.engine.Game;
import cegepst.engine.entities.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {

    private GamePad gamePad;
    private Tank tank;
    private ArrayList<Missile> missiles;
    private ArrayList<Brick> bricks;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 116));
        bricks.add(new Brick(500, 132));
        bricks.add(new Brick(484, 148));
        bricks.add(new Brick(500, 164));
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

        ArrayList<StaticEntity> killedEntities = new ArrayList<>();
        for (Missile missile : missiles) {
            missile.update();
            for (Brick brick : bricks) {
                if (missile.hitBoxIntersectWith(brick)) {
                    killedEntities.add(brick);
                    killedEntities.add(missile);
                }
            }
        }

        for (StaticEntity entity : killedEntities) {
            if (entity instanceof Brick) {
                bricks.remove(entity);
            }
            if (entity instanceof Missile) {
                missiles.remove(entity);
            }
            CollidableRepository.getInstance().unregisterEntity(entity);
        }
    }

    @Override
    public void draw(Buffer buffer) {
        tank.draw(buffer);
        for (Missile missile : missiles) {
            missile.draw(buffer);
        }
        for (Brick brick : bricks) {
            brick.draw(buffer);
        }
    }

    @Override
    public void conclude() {

    }
}
