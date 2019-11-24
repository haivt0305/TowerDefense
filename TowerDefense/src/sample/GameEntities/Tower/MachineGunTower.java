package sample.GameEntities.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import sample.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.GameEntities.Bullet.BaseBullet;
import sample.GameEntities.Bullet.MachineGunBullet;
import sample.GameEntities.Enemy.BaseEnemy;

import static sample.Main.spawner;
import static sample.Main.tick;

public class MachineGunTower extends BaseTower {
    Image gun;
    Image pedestal;

    public MachineGunTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.tileScale;
        j = y * Config.tileScale;
        iCenter = x * Config.tileScale + 32;
        jCenter = y * Config.tileScale + 32;
        damage = Config.MACHINE_GUN_BULLET_DAMAGE;
        fireRate = Config.MACHINE_GUN_TOWER_FIRE_RATE;
        fireRange = Config.MACHINE_GUN_TOWER_RANGE;
        price = Config.MACHINE_GUN_TOWER_PRICE;
        this.timeShot = 0;
        this.rota = 0;
        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        pedestal = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile182.png");

    }

    @Override
    public void update() {
        for (BaseEnemy a : spawner.enemies) {
            if (this.haveTarget(a)) {
                this.rota = Rotation.degree(this.iCenter, this.jCenter, a.iCenter, a.jCenter);
                if (tick.getTick() >= timeShot + fireRate) {
                    bullets.add(new MachineGunBullet(this.i, this.j, this.rota, this));
                    timeShot = tick.getTick();
                }
                break;
            }
        }

        bullets.forEach(BaseBullet::update);

    }

    public void render(GraphicsContext gc) {
        ImageView gunImgView = new ImageView(gun);
        SnapshotParameters snapshotParameters = new SnapshotParameters();

        snapshotParameters.setFill(Color.TRANSPARENT);
        snapshotParameters.setTransform(new Rotate(this.rota, 32, 32));
        snapshotParameters.setViewport(new Rectangle2D(0, 0, 64, 64));

        Image gun = gunImgView.snapshot(snapshotParameters,null);

        //gc.fillOval(i - fireRange * Config.tileScale + 32,j - fireRange * Config.tileScale + 32,fireRange * Config.tileScale * 2,fireRange * Config.tileScale * 2);

        bullets.forEach(g->g.render(gc));
        gc.setStroke(Color.RED);
        gc.strokeOval(i - fireRange * Config.tileScale + 32, j - fireRange * Config.tileScale + 32, fireRange * Config.tileScale * 2, fireRange * Config.tileScale * 2);
        gc.drawImage(pedestal, i, j);
        gc.drawImage(gun, i, j);

        /*gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillOval(i - 5, j - 5, 10, 10);
        gc.setFill(javafx.scene.paint.Color.RED);
        gc.fillOval(iCenter - 5,jCenter - 5, 10, 10);
        gc.setFill(Color.BLACK);*/
    }
}
