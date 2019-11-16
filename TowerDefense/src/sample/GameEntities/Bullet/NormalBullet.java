package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;
import sample.GameEntities.Enemy.AbstractEnemy;
import sample.GameEntities.Enemy.NormalEnemy;
import sample.GameEntities.MovableObject;
import sample.GameEntities.Tower.AbstractTower;
import sample.GameEntities.Tower.NormalTower;
import sample.GameObject;
import sample.Point;


public class NormalBullet extends AbstractBullet {
    Image bullet;

    public NormalBullet(int i, int j, double rota, AbstractTower owner){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        damage = 5;
        speed = 30;
        this.rota = rota;
        this.owner = owner;

        bullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile272.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bullet, i, j);
    }

}
