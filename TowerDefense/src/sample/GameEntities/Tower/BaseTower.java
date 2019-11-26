package sample.GameEntities.Tower;

import sample.Config;
import sample.GameEntities.Bullet.BaseBullet;
import sample.GameEntities.Enemy.BaseEnemy;
import sample.GameEntities.MovableObject;
import sample.Point;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTower extends MovableObject {
    double damage;
    double fireRate;
    double fireRange;
    double rota;
    double timeShot;
    int price;

    public List<BaseBullet> bullets = new ArrayList<>();

    public boolean shooting(BaseEnemy enemy) {
        if(Point.distance(this.iCenter, this.jCenter, enemy.iCenter, enemy.jCenter) <= this.fireRange * Config.tileScale){
            return true;
        }
        return false;
    }

    public void update() {
    }

    public double getFireRange() {
        return fireRange;
    }
}
