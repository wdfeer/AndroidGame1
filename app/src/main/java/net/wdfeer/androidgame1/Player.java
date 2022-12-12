package net.wdfeer.androidgame1;

import android.graphics.Color;

public class Player extends Circle {
    public Player(V2 position) {
        super(position, 20, Color.RED);
    }

    @Override
    public void update() {
        for (GameObject gameObject : Game.gameObjects) {
            if (gameObject instanceof Circle){
                Circle circle = (Circle)gameObject;
                if (circle.canHitPlayer() && circle.intersecting(this))
                    Game.restart();
            }
        }
    }
}
