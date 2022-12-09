package net.wdfeer.androidgame1;

public class Body extends Circle {
    public Body(V2f position, int radius, int fillColor) {
        super(position, radius, fillColor);
    }
    public V2f velocity = new V2f(0,0);
    @Override
    public void update() {
        position = position.add(velocity);
    }
}
