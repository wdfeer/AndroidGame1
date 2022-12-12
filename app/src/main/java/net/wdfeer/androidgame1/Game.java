package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static void initialize(){
        restart();
    }
    public static void restart(){
        frameCount = 0;

        gameObjects = new ArrayList<>();

        player = new Player(new V2(600, 1600));
        boss = new Boss(new V2(540, 360));
    }
    public static Player player;
    public static Boss boss;
    public static List<GameObject> gameObjects;
    public static long frameCount = 0;
    public static void update(){
        frameCount++;

        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }

        gameObjects = gameObjects.stream().filter(x -> !x.toBeDeleted).collect(Collectors.toList());
    }


    public static void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(canvas);
        }
    }
    public static void onTouch(V2 position){
        player.position = position;
    }
}
