package net.wdfeer.androidgame1;

import android.graphics.Color;

public class Boss extends Circle {
    public Boss(V2 position) {
        super(position, 64, Color.rgb(1f, 0.1f, 0.75f));
    }

    @Override
    public boolean canHitPlayer() {
        return true;
    }

    @Override
    public void update() {
        super.update();

        if (Game.frameCount % 3 == 0)
            spawnEnemy();
    }
    float shootAngle = 0;
    void spawnEnemy(){
        V2 velocity = new V2(9, 0).rotate(shootAngle);
        shootAngle += 3.14f * 0.45f;

        Body bullet = new Body(position, 15, Color.rgb(1f, 0f, 0.8f));
        bullet.velocity = velocity;
        bullet = new Body(position, 15, Color.rgb(0.8f, 0f, 1f));
        bullet.velocity = velocity.rotate(3.14f);
    }
}
