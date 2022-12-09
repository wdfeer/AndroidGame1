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

        player = new Player(new V2f(600, 1600));
        for (int i = 0; i < 10; i++) {
            spawnEnemy();
        }
    }
    public static Player player;
    public static List<GameObject> gameObjects;
    public static long frameCount = 0;
    public static void update(){
        frameCount++;
        if (frameCount % 10 == 0)
            spawnEnemy();
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }

        gameObjects = gameObjects.stream().filter(x -> !x.toBeDeleted).collect(Collectors.toList());
    }
    static void spawnEnemy(){
        Body body = new Body(new V2f(((float)Math.random() * 1080f), 0), 20, Color.rgb(1f,0f,1f));
        body.velocity = new V2f(0, (float)((Math.random() + 1) * 5));
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
