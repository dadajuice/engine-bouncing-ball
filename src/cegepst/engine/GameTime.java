package cegepst.engine;

public class GameTime {

    private static final int SLEEP = 25;

    private long syncTime;

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public GameTime() {
        sync();
    }

    public void sleep() {
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sync();
    }

    private void sync() {
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
