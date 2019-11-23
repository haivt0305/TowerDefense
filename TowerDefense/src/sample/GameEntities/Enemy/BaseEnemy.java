package sample.GameEntities.Enemy;

import sample.Config;
import sample.Direction;
import sample.GameEntities.MovableObject;
import sample.GameEntities.Road;
import sample.GameEntities.Tower.BaseTower;

import sample.*;

import static sample.Main.spawner;


public abstract class BaseEnemy extends MovableObject {
    public double enemyHealth;
    int coin;
    double speed;

    Direction direction;
    public int widthImg;
    public int heightImg;

    private int wayPointIndex = 0;

    private Point getNextWayPoint() {
        if (wayPointIndex < Road.wayPoints.length - 1) {
            return Road.wayPoints[++wayPointIndex];
        }
        return null;
    }

    private void calculateDirection() {
        if (wayPointIndex >= Road.wayPoints.length - 1) {
            // Enemy den way point cuoi
            Main.playerHealth.setPlayerHealth(Main.playerHealth.getPlayerHealth()-1);
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
            Main.coin.setCoin(Main.coin.getCoin() + this.coin);
            spawner.enemies.remove(this);
        }
        calculateDirection();

        switch (direction) {
            case UP:
                j -= speed;
                jCenter -= speed;
                break;
            case DOWN:
                j += speed;
                jCenter += speed;
                break;
            case LEFT:
                i -= speed;
                iCenter -= speed;
                break;
            case RIGHT:
                i += speed;
                iCenter += speed;
                break;
        }
    }
}
