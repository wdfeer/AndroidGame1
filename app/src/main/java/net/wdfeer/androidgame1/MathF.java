package net.wdfeer.androidgame1;

public final class MathF {
    public static boolean roll(float chance){
        return random() < chance;
    }
    public static float random(){
        return (float)Math.random();
    }
    public static final float PI = (float)Math.PI;
    public static final float PI_HALF = PI / 2f;
    public static final float PI_3HALF = PI + PI_HALF;
}
