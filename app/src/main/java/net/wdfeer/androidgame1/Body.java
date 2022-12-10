package net.wdfeer.androidgame1;

public class Body extends Circle {
    public Body(V2f position, int radius, int fillColor) {
        super(position, radius, fillColor);
    }
    public V2f velocity = new V2f(0,0);
    @Override
    public void update() {
        position = position.add(velocity);
        if (position.x < -100 || position.y < -100 || position.x > 1200 || position.y > 2400)
            toBeDeleted = true;
    }
}
