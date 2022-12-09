package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends GameObject {
    public Circle(V2f position, int radius, int fillColor){
        this.position = position;
        this.radius = radius;

        paint = new Paint();
        paint.setColor(fillColor);

        Game.gameObjects.add(this);
    }
    public V2f position;
    public int radius;
    public Paint paint;
    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(position.x, position.y, radius, paint);
    }
    public boolean intersecting(Circle other){
        return position.distance(other.position) <= radius + other.radius;
    }
}
