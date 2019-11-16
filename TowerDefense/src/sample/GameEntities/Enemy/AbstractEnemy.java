package sample.GameEntities.Enemy;

import sample.*;
import sample.GameEntities.MovableObject;
import sample.GameEntities.Road;
import sample.GameEntities.Tower.AbstractTower;

import static sample.Main.movableObjects;
import static sample.Main.spawner;

public abstract class AbstractEnemy extends MovableObject {
    public int enemyHealth;
    public int gold;
    public int speed;
    public Direction direction;
    public int widthImg;
    public int heightImg;

    public int wayPointIndex = 0;
    public Point getNextWayPoint() {
        if (wayPointIndex < Road.wayPoints.length - 1)
            return Road.wayPoints[++wayPointIndex];
        return null;
    }

    public boolean enemyInRange(AbstractTower tower) {
        if(Point.distance(this.iCenter, this.jCenter, tower.iCenter, tower.jCenter) <= tower.getFireRange() * Config.tileScale) {
            return true;
        }
        return false;
    }

    void calculateDirection() {
        if (wayPointIndex >= Road.wayPoints.length-1) {
            Main.playerHealth.setPlayerHealth(Main.playerHealth.getPlayerHealth() - 1);

            spawner.enemies.remove(this);

        }

        Point currentWP = Road.wayPoints[wayPointIndex];
        if (Point.distance(i, j, currentWP.getX(), currentWP.getY()) <= speed) {
            i = currentWP.getX();
            j = currentWP.getY();
            Point nextWayPoint = getNextWayPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.getX() - i;
            double deltaY = nextWayPoint.getY() - j;
            if (deltaX > speed) direction = Direction.RIGHT;
            else if (deltaX < -speed) direction = Direction.LEFT;
            else if (deltaY > speed) direction = Direction.DOWN;
            else if (deltaY <= -speed) direction = Direction.UP;
        }
    }

    @Override
    public void update() {
        if(this.enemyHealth <= 0) {
            Main.gold.setGold(Main.gold.getGold() + this.gold);
            spawner.enemies.remove(this);
        }
/*
        for(MovableObject a : movableObjects) {

                if(a.getClass().getName() == "sample.GameEntities.Tower.NormalTower") {
                    if(this.enemyInRange((AbstractTower) a));
                }
        }*/

        calculateDirection();

        switch (direction) {
            case UP:
                j -= speed;
                jCenter -=speed;
                break;
            case DOWN:
                j += speed;
                jCenter +=speed;
                break;
            case LEFT:
                i -= speed;
                iCenter -=speed;
                break;
            case RIGHT:
                i += speed;
                iCenter +=speed;
                break;
            }
        }
    }


