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

        spawnEnemy();
    }
    float shootAngleIncrement = (MathF.random() * 0.025f + 0.435f) * MathF.PI;
    float shootSpeed = MathF.random() * 3 + 5;
    float rayChance = MathF.random() / 2;
    float shootAngle = 0;
    void spawnEnemy(){
        if (MathF.roll(rayChance))
            shootRay(shootAngle + MathF.PI_3HALF);
        else
            shoot(2f, shootAngle + MathF.PI);
        shoot(1f, shootAngle);
        shootAngle += shootAngleIncrement;
    }
    void shootRay(float angle){
        for (int i = 0; i < 15; i++){
            shoot(shootSpeed * 2f * (1f - i / 60f), angle, Color.rgb(0f, 1f, 0.6f));
        }
    }
    void shoot(float speedMult, float angle){
        shoot(shootSpeed * speedMult, angle, Color.rgb(0.6f + speedMult / 5f, 0f, 1.2f - speedMult / 5f));
    }
    void shoot(float speed, float angle, int color){
        V2 velocity = new V2(speed, 0).rotate(angle);
        Body bullet = new Body(position, 15, color);
        bullet.velocity = velocity;
    }
}
