package net.wdfeer.androidgame1.main;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import net.wdfeer.androidgame1.Game;
import net.wdfeer.androidgame1.V2;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private final MainThread thread;

    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder());
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    public static int width;
    public static int height;
    void setDisplayMetrics(DisplayMetrics metrics){
        width = metrics.widthPixels;
        height = metrics.heightPixels;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setDisplayMetrics(Resources.getSystem().getDisplayMetrics());
        setOnTouchListener((view, event) -> {
            V2 touchPos = new V2(event.getX(), event.getY());
            Game.onTouch(touchPos);

            performClick();
            return true;
        });
        thread.running = true;
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.running = false;
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
    }
}