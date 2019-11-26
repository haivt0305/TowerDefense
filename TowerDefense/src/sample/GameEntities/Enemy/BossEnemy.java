package sample.GameEntities.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.*;
import javafx.scene.image.Image;

public class BossEnemy extends BaseEnemy {

    Image gun;
    Image base;

    public BossEnemy(int x, int y) {
        this.x = x;
        this.y = y;

        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile292.png");
        base = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile269.png");

        i = x * Config.tileScale;
        j = y * Config.tileScale;

        widthImg = (int) base.getWidth();
        heightImg = (int) base.getHeight();

        iCenter = x * Config.tileScale + widthImg / 2;
        jCenter = y * Config.tileScale + heightImg / 2;

        enemyHealth = Config.BOSS_ENEMY_HEALTH;
        coin = Config.BOSS_ENEMY_REWARD_COINS;
        speed = Config.BOSS_ENEMY_SPEED;
        direction = Direction.RIGHT;
    }

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView gunImgView = new ImageView(gun);
        ImageView baseImgView = new ImageView(base);


        gunImgView.setRotate(this.direction.getDegree());
        baseImgView.setRotate(this.direction.getDegree());

        Image base = baseImgView.snapshot(snapshotParameters, null);
        Image gun = gunImgView.snapshot(snapshotParameters, null);

        gc.drawImage(base, i, j);
        gc.drawImage(gun, i, j);

        gc.setFill(Color.RED);
        gc.fillRect(i, j - 5, widthImg, 5);
        gc.setFill(Color.GREEN);
        gc.fillRect(i, j - 5, (double) (widthImg) * this.enemyHealth / Config.BOSS_ENEMY_HEALTH, 5);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(i, j-5, widthImg, 5);
    }
}
