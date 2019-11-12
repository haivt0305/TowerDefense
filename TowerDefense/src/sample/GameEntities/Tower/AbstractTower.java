package sample.GameEntities.Tower;

import sample.*;
import sample.GameEntities.Enemy.AbstractEnemy;
import sample.GameEntities.Bullet.NormalBullet;
import sample.Point;

import static sample.Main.*;
import static sample.Main.time;

public abstract class AbstractTower extends GameObject {

    public double damage;
    public double fireRate;
    public double fireRange;
    public double rota;
    public double timeShot;

    public boolean enemyInRange(AbstractEnemy enemy) {
        if(Point.distance(this.iCenter, this.jCenter, enemy.iCenter, enemy.jCenter) <= this.fireRange * Config.tileScale){
            return true;
        }
        return false;
    }
    public void update() {
        for(GameObject a:gameObjects) {

            if(a.getClass().getName() == "sample.GameEntities.Enemy.NormalEnemy") {
                if(this.enemyInRange((AbstractEnemy)a)) {
                    this.rota = Rotation.degree(this.iCenter, this.jCenter, a.iCenter, a.jCenter);
                    if(time.getTime() >= timeShot + fireRate) {
                        bullets.add(new NormalBullet(this.i, this.j, a.i, a.j, rota));
                        timeShot = time.getTime();
                    }
                    break;
                }
            }
        }
    }
}
