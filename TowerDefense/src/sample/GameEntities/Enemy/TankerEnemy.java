package sample.GameEntities.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.*;
import javafx.scene.image.Image;

public class TankerEnemy extends BaseEnemy {
    Image gun;
    Image pedestal;

    public TankerEnemy(int x, int y) {
        this.x = x;
        this.y = y;

        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile291.png");
        pedestal = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile268.png");

        i = x * Config.tileScale;
        j = y * Config.tileScale;

        widthImg = (int) pedestal.getWidth();
        heightImg = (int) pedestal.getHeight();

        iCenter = x * Config.tileScale + widthImg / 2;
        jCenter = y * Config.tileScale + heightImg / 2;

        enemyHealth = 5;
        coin = 50;
        speed = 5;
        direction = Direction.RIGHT;
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
        gc.fillOval(iCenter - 5, jCenter - 5,10, 10);
        gc.setFill(Color.RED);
        gc.fillRect(i, j - 5, widthImg, 5);
        gc.setFill(Color.GREEN);
        gc.fillRect(i, j - 5, (double) (widthImg) * this.enemyHealth / 5, 5);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(i,j-5,widthImg,5);
    }
}
