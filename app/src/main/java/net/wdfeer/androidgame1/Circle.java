package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends GameObject implements Drawable, Updatable {
    public Circle(int x, int y, int radius, int fillColor){
        this.x = x; this.y = y; this.radius = radius;
        paint = new Paint();
        paint.setColor(fillColor);
    }
    public int x;
    public int y;
    public int radius;
    public Paint paint;
    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }

    @Override
    public void update() {
        y++;
        if (y > 1920)
            y = 0;
    }
}
