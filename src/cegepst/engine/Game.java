package cegepst.engine;

import java.awt.*;

public abstract class Game {

    private static final int SLEEP = 25;
    private boolean playing = true;
    private RenderingEngine renderingEngine;
    private long syncTime;

    public abstract void initialize();
    public abstract void update();
    public abstract void draw(Graphics2D buffer);
    public abstract void conclude();

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public void start() {
        initialize();
        run();
        conclude();
    }

    public void drawBufferOnScreen() {
        renderingEngine.renderBufferOnScreen();
    }

    private void run() {
        renderingEngine.start();
        updateSyncTime();
        while (playing) {
            update();
            draw(renderingEngine.getRenderingBuffer());
            drawBufferOnScreen();
            sleep();
        }
        renderingEngine.stop();
    }

    private void sleep() {
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }

    private void updateSyncTime() {
        syncTime = System.currentTimeMillis();
    }

    private long getSleepTime() {
        long sleep = SLEEP - (System.currentTimeMillis() - syncTime);
        if (sleep < 0) {
            sleep = 4;
        }
        return sleep;
    }
}
