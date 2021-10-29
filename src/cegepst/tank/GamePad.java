package cegepst.tank;

import cegepst.engine.controls.MovementController;

import java.awt.event.KeyEvent;

public class GamePad extends MovementController {

    private int quitKey = KeyEvent.VK_Q;
    private int fireKey = KeyEvent.VK_SPACE;

    public GamePad() {
        bindKey(quitKey);
        bindKey(fireKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }

    public boolean isFirePressed() {
        return isKeyPressed(fireKey);
    }
}
