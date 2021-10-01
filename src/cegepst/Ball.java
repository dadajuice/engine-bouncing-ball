package cegepst;

import java.util.Random;

public class Ball {

    private Random rnd = new Random();
    private int radius = getRandomNumber(20, 50);
    private int x = getRandomNumber(0 + radius * 2, 800 - radius * 2);
    private int y = getRandomNumber(0 + radius * 2, 600 - radius * 2);
    private int dx = getRandomNumber(0, 1) == 0 ? 5 : -5;
    private int dy = getRandomNumber(0, 1) == 0 ? 5 : -5;

    public void update() {
        x += dx;
        y += dy;
        if (hasTouchVerticalBound()) {
            dy *= -1;
        }
        if (hasTouchHorizontalBound()) {
            dx *= -1;
        }
    }

    public boolean hasTouchHorizontalBound() {
        return x <= radius || x >= 800 - radius;
    }

    public boolean hasTouchVerticalBound() {
        return y <= radius || y >= 600 - radius;
    }

    public boolean hasTouchBound() {
        return hasTouchVerticalBound() || hasTouchHorizontalBound();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    private int getRandomNumber(int min, int max) {
        return rnd.nextInt((max - min) + 1) + min;
    }
}
