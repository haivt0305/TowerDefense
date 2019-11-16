package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import sample.Config;
import sample.GameEntities.Bullet.AbstractBullet;
import sample.GameEntities.Enemy.AbstractEnemy;
import sample.GameEntities.Enemy.NormalEnemy;
import sample.GameObject;
import java.util.Random;

import java.util.*;

import static sample.Main.*;

public class Spawner extends MovableObject {

    int delay;
    int creatingTime;
    int number;
    Random random = new Random();
    public List<AbstractEnemy> enemies = new ArrayList<>();

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
        enemies.forEach(g->g.render(gc));
    }

    @Override
    public void update() {
        for (int n = 0; n < number; n++) {
            if(time.getTime() == creatingTime + delay * n) {
                int rand = random.nextInt(4);
                if(rand == 1) {
                    enemies.add(new NormalEnemy(1, 10));
                }
            }
        }
        enemies.forEach(AbstractEnemy::update);

    }
}
