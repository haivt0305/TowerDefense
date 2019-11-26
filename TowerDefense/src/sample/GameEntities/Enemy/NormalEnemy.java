package sample.GameEntities.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sample.*;
import javafx.scene.image.Image;

public class NormalEnemy extends BaseEnemy {
    Image enemy;

    public NormalEnemy(int x, int y) {
        this.x = x;
        this.y = y;
        enemy = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile245.png");
        i = x * Config.tileScale;
        j = y * Config.tileScale;
        widthImg = (int) enemy.getWidth();
        heightImg = (int) enemy.getHeight();
        iCenter = x * Config.tileScale + widthImg / 2;
        jCenter = y * Config.tileScale + heightImg / 2;
        enemyHealth = Config.NORMAL_ENEMY_HEALTH;
        coin = Config.NORMAL_ENEMY_REWARD_COINS;
        speed = Config.NORMAL_ENEMY_SPEED;
        direction = Direction.RIGHT;
    }

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView enemyImgView = new ImageView(enemy);

        enemyImgView.setRotate(this.direction.getDegree());

        Image enemy = enemyImgView.snapshot(snapshotParameters, null);

        gc.drawImage(enemy, i, j);

        gc.setFill(Color.RED);
        gc.fillRect(i, j - 5, widthImg, 5);
        gc.setFill(Color.GREEN);
        gc.fillRect(i, j - 5, (double) (widthImg) * this.enemyHealth / Config.NORMAL_ENEMY_HEALTH, 5);
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(i, j-5, widthImg, 5);
    }
}
