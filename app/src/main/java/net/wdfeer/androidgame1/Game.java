package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;

public class Game {
    public static void initialize(){
        restart();
    }
    public static void restart(){
        gameObjects = new ArrayList<>();
        frameCount = 0;
        for (int i = 0; i < 100; i++) {
            Body body = new Body(new V2f((float) (Math.random() * 1000), (float) (Math.random() * 1000)), 50, Color.rgb(i % 3 / 3f, i % 4 / 4f, i % 6 / 6f));
            body.velocity = new V2f((float)Math.random() - 0.5f, (float)Math.random() - 0.5f);
            gameObjects.add(body);
        }
    }
    public static ArrayList<GameObject> gameObjects;
    public static int frameCount;
    public static void update(){
        frameCount++;
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
        if (frameCount >= 600)
            restart();
    }
    public static void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);

        for (GameObject gameObject : gameObjects) {
            gameObject.draw(canvas);
        }
    }
}
