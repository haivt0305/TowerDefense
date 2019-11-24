package sample.GameEntities.Tower;

import sample.Config;
import sample.GameEntities.Bullet.BaseBullet;
import sample.GameEntities.Bullet.NormalBullet;
import sample.GameEntities.Enemy.BaseEnemy;
import sample.GameEntities.MovableObject;
import sample.Point;
import sample.Rotation;

import java.util.ArrayList;
import java.util.List;

import static sample.Main.spawner;
import static sample.Main.tick;

public abstract class BaseTower extends MovableObject {
    double damage;
    double fireRate;
    double fireRange;
    double rota;
    double timeShot;
    int price;

    public List<BaseBullet> bullets = new ArrayList<>();

    public boolean haveTarget(BaseEnemy enemy) {
        if(Point.distance(this.iCenter, this.jCenter, enemy.iCenter, enemy.jCenter) <= this.fireRange * Config.tileScale){
            return true;
        }
        return false;
    }

    public void update() {
        for(BaseEnemy a: spawner.enemies) {
            if(this.haveTarget(a)) {
                this.rota = Rotation.degree(this.iCenter,this.jCenter,((BaseEnemy) a).iCenter,((BaseEnemy) a).jCenter);
                if(tick.getTick() >= timeShot + fireRate) {
                    bullets.add(new NormalBullet(this.i, this.j, this.rota, this));
                    timeShot= tick.getTick();

                }
                break;
                //       }
            }
        }
        bullets.forEach(BaseBullet::update);

    }

    public double getFireRange() {
        return fireRange;
    }
}
