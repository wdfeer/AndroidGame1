package net.wdfeer.androidgame1;

import android.graphics.Color;

public class Body extends Circle {
    public Body(V2f position, int radius, int fillColor) {
        super(position, radius, fillColor);
    }
    public V2f velocity = new V2f(0,0);

    @Override
    public void update() {
        position = position.add(velocity);
        int colliding = 0;
        for (GameObject gameObject : Game.gameObjects) {
            if (gameObject == this)
                continue;
            if (gameObject instanceof Circle && ((Circle) gameObject).intersecting(this)){
                colliding++;
            }
        }
        paint.setColor(Color.rgb(colliding / 5f, colliding / 5f, 0.25f));
    }
}
