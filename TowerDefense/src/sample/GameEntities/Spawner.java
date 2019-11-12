package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import sample.Config;
import sample.GameEntities.Enemy.NormalEnemy;
import sample.GameObject;

import java.util.*;

import static sample.Main.gameObjects;
import static sample.Main.time;

public class Spawner extends GameObject {

    int delay;
    int creatingTime;
    int number;

    public Spawner(int delay, int creatingTime, int number) {
        this.delay = delay;
        this.creatingTime = creatingTime;
        this.number = number;
        this.x = 1;
        this.y = 10;
        this.i = x * Config.tileScale;
        this.j = y * Config.tileScale;
    }

    @Override
    public void render(GraphicsContext gc) {

    }

    @Override
    public void update() {
        ListIterator<GameObject> listIterator= gameObjects.listIterator();

        for (int n = 0; n < number; n++) {
            if(time.getTime() == creatingTime + delay * n) {
                gameObjects.add(new NormalEnemy(1,10));
            }
        }
    }
}
