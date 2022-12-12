package net.wdfeer.androidgame1.main;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import net.wdfeer.androidgame1.Game;

public class MainThread extends Thread {


    public MainThread(SurfaceHolder surfaceHolder) {
        super();
        this.surfaceHolder = surfaceHolder;
        Game.initialize();
    }
    public static final int targetFPS = 120;
    long startTime;
    long timeMillis;
    long waitTime;
    long totalTime = 0;
    int frameCount = 0;
    long targetTime = 1000 / targetFPS;
    float averageFPS;
    private final SurfaceHolder surfaceHolder;
    public boolean running;
    public static Canvas canvas;
    @Override
    public void run() {
        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder) {
                    Game.update();
                    Game.draw(canvas);
                }
            } catch (Exception ignored) {}
            finally {
                    if (canvas != null)            {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;

            try {
                sleep(waitTime);
            } catch (Exception ignored) {}

            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == targetFPS)        {
                averageFPS = 1000f / ((totalTime / frameCount) / 1000000f);
                frameCount = 0;
                totalTime = 0;
                System.out.println("Average FPS: " + averageFPS);
            }
        }
    }
}