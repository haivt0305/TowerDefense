package sample.GameEntities.Bullet;

import sample.Config;
import sample.GameEntities.MovableObject;
import sample.GameEntities.Enemy.BaseEnemy;
import sample.GameEntities.Tower.BaseTower;
import sample.Point;

import static sample.Main.spawner;

public abstract class BaseBullet extends MovableObject {

    BaseTower owner;
    double damage;
    double speed;
    double rota;

    public boolean inRange(BaseEnemy enemy) {
        if((iCenter <= enemy.i + enemy.widthImg) && (iCenter >= enemy.i) && (jCenter <= enemy.j + enemy.heightImg) && (jCenter >= enemy.j)) {
            return true;
        }
        return false;
    }

    public boolean outRange() {
        if(Point.distance(i, j, owner.i, owner.j) + speed >= owner.getFireRange() * Config.tileScale) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {

        if(rota <= 90)   {
            i = (int) (i + speed * Math.sin(rota / 180 * Math.PI));
            j = (int) (j - speed * Math.cos(rota / 180 * Math.PI));
        }
        else if(rota <= 180) {
            i = (int) (i + speed * Math.cos((rota - 90) / 180 * Math.PI));
            j = (int) (j + speed * Math.sin((rota - 90) / 180 * Math.PI));
        }
        else if(rota <= 270) {
            i = (int) (i - speed * Math.sin((rota - 180) / 180 * Math.PI));
            j = (int) (j + speed * Math.cos((rota - 180) / 180 * Math.PI));
        }
        else {
            i = (int) (i - speed * Math.cos((rota - 270) / 180 * Math.PI));
            j = (int) (j - speed * Math.sin((rota - 270) / 180 *Math.PI));
        }
        iCenter = i + 32;
        jCenter = j + 32;

        for (BaseEnemy e: spawner.enemies) {
            if (this.inRange(e)) {
                e.enemyHealth = e.enemyHealth - this.damage;
                owner.bullets.remove(this);
                break;
            }
        }

        if(this.outRange()) {
            owner.bullets.remove(this);
        }
    }
}
