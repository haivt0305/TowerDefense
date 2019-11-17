package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import sample.Config;
import sample.GameEntities.Enemy.*;
import sample.GameEntities.MovableObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static sample.Main.*;

public class Spawner extends MovableObject {
    int delay;
    int creatingTime;
    int number;
    String enemyClass;
    Random random = new Random();
    public List<BaseEnemy> enemies = new ArrayList<>();
    int index = 1;
    int subindex;
    boolean check;

    public Spawner(int delay, int creatingTime, int number) {
        this.delay = delay;
        this.creatingTime = creatingTime;
        this.number = number;
        this.enemyClass = enemyClass;
        this.x = 1;
        this.y = 10;
        this.i = x * Config.tileScale;
        this.j = y * Config.tileScale;
    }

    @Override
    public void render(GraphicsContext gc) {
        enemies.forEach(g -> g.render(gc));
    }

    void LV(int level) {
        if (level == 1) {
            number = 7;
            creatingTime = 30;
            delay = 20;
            for (int n = 0; n < number; n++) {
                if (time.getTime() == creatingTime + delay * n) {
                    enemies.add(new NormalEnemy(1, 10));
                }
            }
        }
    }

    @Override
    public void update() {
        LV(index);

        if(enemies.isEmpty() && time.getTime() >= creatingTime) {
            creatingTime = time.getTime() + 1;
            index ++;
        }
        enemies.forEach(BaseEnemy::update);

    }
}

