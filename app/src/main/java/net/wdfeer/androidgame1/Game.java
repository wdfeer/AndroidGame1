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

        lastEnemyX = 0;
    }
    public static Player player;
    public static List<GameObject> gameObjects;
    public static long frameCount = 0;
    public static void update(){
        frameCount++;
        if (frameCount % 5 == 0)
            spawnEnemy();
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }

        gameObjects = gameObjects.stream().filter(x -> !x.toBeDeleted).collect(Collectors.toList());
    }
    static int lastEnemyX = 0;
    static void spawnEnemy(){
        int radius;
        int color;
        if (frameCount % 2 == 0) {
            radius = 24;
            color = Color.rgb(0.8f,0f,1f);
        } else {
            radius = 18;
            color = Color.rgb(1f,0f,1f);
        }
        Body body = new Body(new V2f(lastEnemyX, 0), radius, color);
        body.velocity = new V2f(0, 5f);

        lastEnemyX += 150;
        if (lastEnemyX > 1080)
            lastEnemyX %= 1080;
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
