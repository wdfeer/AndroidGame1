package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public static void initialize(){
        restart();
    }
    public static void restart(){
        player = new Circle(new V2f(750, 1200), 25, Color.WHITE);
        gameObjects = new ArrayList<>(Collections.singleton(player));
        for (int i = 0; i < 100; i++) {
            Body body = new Body(new V2f((float) (Math.random() * 1000), (float) (Math.random() * 1000)), 50, Color.rgb(i % 3 / 3f, i % 4 / 4f, i % 6 / 6f));
            body.velocity = new V2f((float)Math.random() - 0.5f, (float)Math.random() - 0.5f);
            body.velocity = body.velocity.mult(10f);
            gameObjects.add(body);
        }
    }
    public static Circle player;
    public static ArrayList<GameObject> gameObjects;
    public static void update(){
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }
    public static void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);

        for (GameObject gameObject : gameObjects) {
            gameObject.draw(canvas);
        }
    }
    public static void onTouch(V2f position){
        player.position = position;
    }
}
