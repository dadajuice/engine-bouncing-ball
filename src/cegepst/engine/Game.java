package cegepst.engine;

import cegepst.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game {

    private static final int SLEEP = 25;
    private Ball ball;
    private boolean playing = true;
    private RenderingEngine renderingEngine;
    private long syncTime;
    private int score = 0;

    public Game() {
        renderingEngine = new RenderingEngine();
        ball = new Ball(20);
    }

    public void start() {
        renderingEngine.start();
        updateSyncTime();
        while (playing) {
            update();
            drawOnBuffer(renderingEngine.getRenderingBuffer());
            drawBufferOnScreen();
            sleep();
        }
        renderingEngine.stop();
    }

    public void update() {
        ball.update();
        if (ball.hasTouchBound()) {
            score += 10;
        }
    }

    public void drawOnBuffer(Graphics2D buffer) {
        ball.draw(buffer);

        buffer.setPaint(Color.WHITE);
        buffer.drawString("Score: " + score, 10, 20);
    }

    public void drawBufferOnScreen() {
        renderingEngine.renderBufferOnScreen();
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
