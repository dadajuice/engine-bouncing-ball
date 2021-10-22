package cegepst.bouncingBalls;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.GameTime;

import java.awt.*;

public class BouncingBallGame extends Game {

    private Ball ball;
    private int score = 0;

    @Override
    public void initialize() {
        ball = new Ball(20);
    }

    @Override
    public void update() {
        ball.update();
        if (ball.hasTouchBound()) {
            score += 10;
        }
    }

    @Override
    public void draw(Buffer buffer) {
        ball.draw(buffer);
        buffer.drawText("Score: " + score, 10, 20, Color.WHITE);
        buffer.drawText("FPS: " + GameTime.getCurrentFps(), 10, 40, Color.WHITE);
        buffer.drawText(GameTime.getElapsedFormattedTime(), 10, 60, Color.WHITE);
    }

    @Override
    public void conclude() {

    }
}
