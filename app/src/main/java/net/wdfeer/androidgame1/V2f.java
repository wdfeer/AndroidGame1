package net.wdfeer.androidgame1;

public class V2f {
    public float x;
    public float y;
    public V2f(float x, float y){ this.x = x; this.y = y; }
    public V2f add(V2f other){
        return new V2f(x + other.x, y + other.y);
    }
    public V2f sub(V2f other){
        return new V2f(x - other.x, y - other.y);
    }
    public V2f mult(V2f other){
        return new V2f(x * other.x, y * other.y);
    }
    public V2f mult(float mult){
        return new V2f(x * mult, y * mult);
    }
    public V2i toV2i(){
        return new V2i((int)x, (int)y);
    }
}
