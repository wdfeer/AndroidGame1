package net.wdfeer.androidgame1;

public class Body extends Circle {
    public Body(V2 position, int radius, int fillColor) {
        super(position, radius, fillColor);
    }
    public V2 velocity = V2.Zero();
    public V2 acceleration = V2.Zero();
    @Override
    public void update() {
        velocity = velocity.add(acceleration);
        position = position.add(velocity);
        if (position.x < -120 || position.y < -120 || position.x > 1200 || position.y > 2400)
            toBeDeleted = true;
    }

    @Override
    public boolean canHitPlayer() {
        return true;
    }
}
