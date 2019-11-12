package sample.GameEntities.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.Config;
import javafx.scene.image.Image;
import sample.Direction;
import sample.GameEntities.Road;
import sample.GameEntities.Tower.AbstractTower;
import sample.GameObject;
import sample.Point;

import static sample.Main.gameObjects;

public class NormalEnemy extends AbstractEnemy {

    Image gun;
    Image pedestal;

    int wayPointIndex = 0;
    public sample.Point getNextWayPoint() {
        if (wayPointIndex < Road.wayPoints.length - 1)
            return Road.wayPoints[++wayPointIndex];
        return null;
    }

    public NormalEnemy(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.tileScale;
        j = y * Config.tileScale;
        iCenter = x * Config.tileScale - 28;
        jCenter = y * Config.tileScale - 28;
        armor = 1;
        gold = 2;
        speed = 3;
        direction = Direction.UP;
        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile292.png");
        pedestal = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile269.png") ;
    }


    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView gunImgView = new ImageView(gun);
        ImageView baseImgView = new ImageView(pedestal);


        gunImgView.setRotate(this.direction.getDegree());
        baseImgView.setRotate(this.direction.getDegree());

        Image base = baseImgView.snapshot(snapshotParameters,null);
        Image gun = gunImgView.snapshot(snapshotParameters,null);

        gc.drawImage(base, i, j);
        gc.drawImage(gun, i, j);


    }
    public boolean enemyInRange(AbstractTower tower) {
        if (Point.distance(this.iCenter, this.jCenter, tower.iCenter, tower.jCenter) <= tower.fireRange * Config.tileScale){
            return true;
        }
        return false;
    }


    void calculateDirection() {
        if (wayPointIndex >= Road.wayPoints.length) {
            return;
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

        for(GameObject a:gameObjects) {

            if(a.getClass().getName() == "sample.GameEntities.Tower.NormalTower") {
                if(this.enemyInRange((AbstractTower) a));
            }
        }

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
