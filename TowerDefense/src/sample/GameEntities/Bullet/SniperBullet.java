package sample.GameEntities.Bullet;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import sample.Config;
import sample.GameEntities.Tower.BaseTower;

public class SniperBullet extends BaseBullet {
    Image bullet;

    public SniperBullet(int i, int j, double rota, BaseTower owner){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        this.owner = owner;
        damage = Config.SNIPER_BULLET_DAMAGE;
        speed = Config.SNIPER_BULLET_SPEED;
        this.rota = rota;


        bullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile274.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        /*ImageView imageView = new ImageView(bullet);
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.rota, 32, 32));
        snapshotParameters.setViewport(new Rectangle2D(0, 0, 64, 64));

        Image image = imageView.snapshot(snapshotParameters, null);*/
        gc.drawImage(bullet, i, j);
    }
}
