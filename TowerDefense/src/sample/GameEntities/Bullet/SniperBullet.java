package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;
import sample.GameEntities.Tower.BaseTower;

public class SniperBullet extends BaseBullet {

    Image sniperBullet;

    public SniperBullet(int i, int j, double rota, BaseTower owner){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        this.owner = owner;
        damage = Config.SNIPER_BULLET_DAMAGE;
        speed = Config.SNIPER_BULLET_SPEED;
        this.rota = rota;
        sniperBullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile274.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(sniperBullet, i, j);
    }

    @Override
    public void update() {

    }
}
