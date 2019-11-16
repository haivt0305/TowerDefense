package sample.GameEntities.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import sample.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.GameEntities.Enemy.AbstractEnemy;

import sample.Point;


public class NormalTower extends AbstractTower {
    Image gun;
    Image pedestal;

    public NormalTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.tileScale;
        j = y * Config.tileScale;
        iCenter = x * Config.tileScale + 32;
        jCenter = y * Config.tileScale + 32;
        damage = 3;
        fireRate = 15;
        fireRange = 3;
        this.timeShot = 0;
        this.rota = 0;
        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        pedestal = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile180.png");
    }

    public void render(GraphicsContext gc) {
        ImageView gunImgView = new ImageView(gun);
        SnapshotParameters snapshotParameters = new SnapshotParameters();

        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.rota,32,32));
        snapshotParameters.setViewport(new Rectangle2D(0,0,64,64));

        Image gun=gunImgView.snapshot(snapshotParameters,null);

        //gc.fillOval(i - fireRange * Config.tileScale + 32,j - fireRange * Config.tileScale + 32,fireRange * Config.tileScale * 2,fireRange * Config.tileScale * 2);

        bullets.forEach(g->g.render(gc));
        gc.setStroke(Color.GREENYELLOW);
        gc.strokeOval(i-fireRange*Config.tileScale+32,j-fireRange*Config.tileScale+32,fireRange*Config.tileScale*2,fireRange*Config.tileScale*2);
        gc.drawImage(pedestal,i,j);
        gc.drawImage(gun,i,j);

        gc.setFill(Color.BLACK);
        gc.fillOval(i-5, j-5,10, 10);
        gc.setFill(Color.RED);
        gc.fillOval(iCenter-5,jCenter-5,10,10);
        gc.setFill(Color.BLACK);
    }


}
