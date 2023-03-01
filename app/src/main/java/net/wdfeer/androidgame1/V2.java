package net.wdfeer.androidgame1;

public class V2 {
    public float x;
    public float y;
    public V2(float x, float y){ this.x = x; this.y = y; }

    public static V2 Zero() { return new V2(0,0); }

    public V2 add(V2 other){
        return new V2(x + other.x, y + other.y);
    }
    public V2 sub(V2 other){
        return new V2(x - other.x, y - other.y);
    }
    public V2 mult(float mult){
        return new V2(x * mult, y * mult);
    }
    public V2 div(float div){
        return new V2(x / div, y / div);
    }
    public float length(){
        return (float)Math.sqrt(x * x + y * y);
    }
    public V2 normalize() { return div(length()); }
    public V2 rotate(float radians) {
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float newX = x * cos - y * sin;
        float newY = x * sin + y * cos;
        return new V2(newX, newY);
    }
    public float distance(V2 other){
        return other.sub(this).length();
    }
}
