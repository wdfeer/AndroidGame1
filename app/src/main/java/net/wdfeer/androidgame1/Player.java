package net.wdfeer.androidgame1;

import android.graphics.Color;

public class Player extends Circle {
    public Player(V2f position) {
        super(position, 20, Color.RED);
    }

    @Override
    public void update() {
        for (GameObject gameObject : Game.gameObjects) {
            if (gameObject == this)
                continue;
            if (gameObject instanceof Body && ((Circle) gameObject).intersecting(this)){
                Game.restart();
            }
        }
    }
}
