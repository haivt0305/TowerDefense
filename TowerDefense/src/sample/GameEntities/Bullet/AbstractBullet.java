package sample.GameEntities.Bullet;

import sample.GameEntities.Enemy.NormalEnemy;
import sample.GameEntities.Tower.AbstractTower;
import sample.GameEntities.Tower.NormalTower;
import sample.GameObject;

public abstract class AbstractBullet extends AbstractTower {

    public double speed;

    public int iBullet;
    public int jBullet;
    public int iLocated;
    public int jLocated;

}
