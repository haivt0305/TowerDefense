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

public class NormalEnemy extends AbstractEnemy {

    Image gun;
    Image pedestal;

    //int wayPointIndex = 0;

    public NormalEnemy(int x, int y) {
        this.x = x;
        this.y = y;

        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile291.png");
        pedestal = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile268.png");

        i = x * Config.tileScale;
        j = y * Config.tileScale;

        widthImg = (int) pedestal.getWidth();
        heightImg = (int) pedestal.getHeight();

        iCenter = x * Config.tileScale + 5 + widthImg / 2;
        jCenter = y * Config.tileScale + 5 + heightImg / 2;

        enemyHealth = 5;
        gold = 2;
        speed = 3;
        direction = Direction.UP;

    }


    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView gunImgView = new ImageView(gun);
        ImageView pedestalImgView = new ImageView(pedestal);


        gunImgView.setRotate(this.direction.getDegree());
        pedestalImgView.setRotate(this.direction.getDegree());

        Image pedestal = pedestalImgView.snapshot(snapshotParameters, null);
        Image gun = gunImgView.snapshot(snapshotParameters, null);

        gc.drawImage(pedestal, i, j);
        gc.drawImage(gun, i, j);

        gc.setFill(Color.BLACK);
        gc.fillOval(i - 5, j - 5, 10, 10);
        gc.setFill(Color.RED);
        gc.fillOval(iCenter - 5, jCenter - 5, 10, 10);
        gc.setFill(Color.BLACK);

        //gc.fillOval(i, j, 10, 10);


}
}