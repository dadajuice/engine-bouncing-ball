package cegepst;

import cegepst.engine.Game;

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
    public void draw(Graphics2D buffer) {
        ball.draw(buffer);
        buffer.setPaint(Color.WHITE);
        buffer.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void conclude() {

    }
}
