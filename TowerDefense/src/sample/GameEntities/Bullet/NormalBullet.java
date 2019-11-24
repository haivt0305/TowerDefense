package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;
import sample.GameEntities.Tower.BaseTower;

public class NormalBullet extends BaseBullet {
    Image bullet;

    public NormalBullet(int i, int j, double rota, BaseTower owner){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        this.owner = owner;
        damage = Config.NORMAL_BULLET_DAMAGE;
        speed = Config.NORMAL_BULLET_SPEED;
        this.rota = rota;


        bullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile275.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bullet, i, j);
    }
}
