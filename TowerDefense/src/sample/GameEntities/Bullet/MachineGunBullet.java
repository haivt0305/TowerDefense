package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;
import sample.GameEntities.Tower.BaseTower;

public class MachineGunBullet extends BaseBullet {

    Image machineGunBullet;

    public MachineGunBullet(int i, int j, double rota, BaseTower owner) {
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        this.owner = owner;
        damage = Config.MACHINE_GUN_BULLET_DAMAGE;
        speed = Config.MACHINE_GUN_BULLET_SPEED;
        this.rota = rota;
        machineGunBullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(machineGunBullet, i, j);
    }

    @Override
    public void update() {

    }
}
