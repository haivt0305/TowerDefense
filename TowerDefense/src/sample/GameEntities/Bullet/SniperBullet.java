package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;
import sample.GameEntities.Tower.BaseTower;

public class SniperBullet extends BaseBullet {
    Image bullet;

    public SniperBullet(int i, int j, double rota, BaseTower tower){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        this.tower = tower;
        damage = Config.SNIPER_BULLET_DAMAGE;
        speed = Config.SNIPER_BULLET_SPEED;
        this.rota = rota;
        bullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile274.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bullet, i, j);
    }
}
