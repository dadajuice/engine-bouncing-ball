package cegepst.engine;

import java.awt.*;

public abstract class Game {

    private boolean playing = true;
    private RenderingEngine renderingEngine;
    private GameTime gameTime;

    public abstract void initialize();
    public abstract void update();
    public abstract void draw(Buffer buffer);
    public abstract void conclude();

    public Game() {
        renderingEngine = new RenderingEngine();
    }

    public final void start() {
        initialize();
        run();
        conclude();
    }

    public final void stop() {
        playing = false;
    }

    private void run() {
        renderingEngine.start();
        gameTime = new GameTime();
        while (playing) {
            update();
            draw(renderingEngine.getRenderingBuffer());
            renderingEngine.renderBufferOnScreen();
            gameTime.sleep();
        }
        renderingEngine.stop();
    }
}
