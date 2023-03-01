package net.wdfeer.androidgame1;

import net.wdfeer.androidgame1.main.GameView;

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
        if (position.x < -10 || position.y < -10 || position.x > (GameView.width + 100) || position.y > (GameView.height + 100))
            toBeDeleted = true;
    }

    @Override
    public boolean canHitPlayer() {
        return true;
    }
}
