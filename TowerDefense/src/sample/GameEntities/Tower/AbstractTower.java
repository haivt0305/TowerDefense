package sample.GameEntities.Tower;

import sample.*;
import sample.GameEntities.Bullet.AbstractBullet;
import sample.GameEntities.Enemy.AbstractEnemy;
import sample.GameEntities.Bullet.NormalBullet;
import sample.GameEntities.MovableObject;
import sample.Point;

import java.util.ArrayList;
import java.util.List;

import static sample.Main.*;
import static sample.Main.time;

public abstract class AbstractTower extends MovableObject {

    public double damage;
    public double fireRate;
    public double fireRange;
    public double rota;
    public double timeShot;
    public List<AbstractBullet> bullets = new ArrayList<>();


    public boolean haveTarget(AbstractEnemy enemy) {
        if(Point.distance(this.iCenter, this.jCenter, enemy.iCenter, enemy.jCenter) <= this.fireRange * Config.tileScale){
            return true;
        }
        return false;
    }
    public void update() {
        for(AbstractEnemy e: spawner.enemies) {
            if (this.haveTarget(e)) {
                this.rota = Rotation.degree(this.iCenter, this.jCenter, e.iCenter, e.jCenter );
                if (time.getTime() >= timeShot + fireRange) {
                    bullets.add(new NormalBullet(this.i, this.j, this.rota, this));
                    timeShot = time.getTime();
                }
            break;
            }
        }
        bullets.forEach(AbstractBullet::update);
    }

    public double getFireRange() {
        return fireRange;
    }

}
