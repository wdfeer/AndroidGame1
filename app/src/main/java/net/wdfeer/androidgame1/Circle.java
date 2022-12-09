package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends GameObject {
    public Circle(V2i position, int radius, int fillColor){
        this.position = position;
        this.radius = radius;

        paint = new Paint();
        paint.setColor(fillColor);
    }
    public V2i position;
    public int radius;
    public Paint paint;
    @Override
    public void update() {
        position.y++;
        if (position.y > 1920)
            position.y = 0;
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(position.x, position.y, radius, paint);
    }
}
