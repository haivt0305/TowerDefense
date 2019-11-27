package sample.GameEntities.Bullet;

import sample.Config;
import sample.GameEntities.MovableObject;
import sample.GameEntities.Enemy.BaseEnemy;
import sample.GameEntities.Tower.BaseTower;
import sample.Point;

import static sample.Main.spawner;

public abstract class BaseBullet extends MovableObject {
    BaseTower tower;
    double damage;
    double speed;
    double rotate;

    public boolean inRange(BaseEnemy enemy) {
        if((iCenter <= enemy.i + enemy.widthImg) && (iCenter >= enemy.i) && (jCenter <= enemy.j + enemy.heightImg) && (jCenter >= enemy.j)) {
            return true;
        }
        return false;
    }

    public boolean notInRange() {
        if(Point.distance(i, j, tower.i, tower.j) + speed >= tower.getFireRange() * Config.tileScale) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if(rotate <= 90) {
            i = (int) (i + speed * Math.sin(rotate / 180 * Math.PI));
            j = (int) (j - speed * Math.cos(rotate / 180 * Math.PI));
        }
        else if(rotate <= 180) {
            i = (int) (i + speed * Math.cos((rotate - 90) / 180 * Math.PI));
            j = (int) (j + speed * Math.sin((rotate - 90) / 180 * Math.PI));
        }
        else if(rotate <= 270) {
            i = (int) (i - speed * Math.sin((rotate - 180) / 180 * Math.PI));
            j = (int) (j + speed * Math.cos((rotate - 180) / 180 * Math.PI));
        }
        else {
            i = (int) (i - speed * Math.cos((rotate - 270) / 180 * Math.PI));
            j = (int) (j - speed * Math.sin((rotate - 270) / 180 * Math.PI));
        }
        iCenter = i + 32;
        jCenter = j + 32;

        if(this.notInRange()) {
            tower.bullets.remove(this);
        }

        for (BaseEnemy e: spawner.enemies) {
            if (this.inRange(e)) {
                e.enemyHealth = e.enemyHealth - this.damage;
                tower.bullets.remove(this);
                break;
            }
        }
    }
}
