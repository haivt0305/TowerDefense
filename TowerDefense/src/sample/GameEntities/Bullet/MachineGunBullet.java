package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntities.Tower.BaseTower;

public class MachineGunBullet extends BaseBullet {
    Image bullet;

    public MachineGunBullet(int i, int j, double rota, BaseTower owner){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        this.owner = owner;
        damage = 3;
        speed = 20;
        this.rota = rota;


        bullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bullet, i, j);
    }
}
