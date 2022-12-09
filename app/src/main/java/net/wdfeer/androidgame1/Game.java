package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;

public class Game {
    public static void initialize(){
        for (int i = 0; i < 100; i++) {
            gameObjects.add(new Circle((int) (Math.random() * 1000), (int) (Math.random() * 1000), 50, Color.rgb(i % 3 / 3f, i % 4 / 4f, i % 6 / 6f)));
        }
    }
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
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
}
