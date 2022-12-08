package net.wdfeer.androidgame1;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;

public class Game {
    public static void initialize(){
        for (int i = 0; i < 100; i++) {
            gameObjects.add(new Circle((int) (Math.random() * 1000), (int) (Math.random() * 1000), 50, Color.GREEN));
        }
    }
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static Updatable[] getUpdatables(){
        return gameObjects.stream().filter(gameObject -> gameObject instanceof Updatable).toArray(Updatable[]::new);
    }
    public static Drawable[] getDrawables(){
        return gameObjects.stream().filter(gameObject -> gameObject instanceof Drawable).toArray(Drawable[]::new);
    }
    public static void update(){
        Updatable[] updatables = getUpdatables();
        for (Updatable updatable : updatables) {
            updatable.update();
        }
    }
    public static void draw(Canvas canvas){
        canvas.drawColor(Color.BLACK);

        Drawable[] drawables = getDrawables();
        for (Drawable drawable : drawables) {
            drawable.draw(canvas);
        }
    }
}
