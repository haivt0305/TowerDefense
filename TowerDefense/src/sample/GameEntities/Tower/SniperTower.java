package sample.GameEntities.Tower;

import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import sample.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.GameEntities.Bullet.BaseBullet;
import sample.GameEntities.Bullet.SniperBullet;
import sample.GameEntities.Enemy.BaseEnemy;

import static sample.Main.spawner;
import static sample.Main.tick;

public class SniperTower extends BaseTower {
    Image gun;
    Image base;

    public SniperTower(int x, int y) {
        this.x = x;
        this.y = y;
        i = x * Config.tileScale;
        j = y * Config.tileScale;
        iCenter = x * Config.tileScale + 32;
        jCenter = y * Config.tileScale + 32;
        damage = Config.SNIPER_BULLET_DAMAGE;
        fireRate = Config.SNIPER_TOWER_FIRE_RATE;
        fireRange = Config.SNIPER_TOWER_RANGE;
        price = Config.SNIPER_TOWER_PRICE;
        this.timeShot = 0;
        this.rota = 0;
        gun = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        base = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile183.png");
    }

    @Override
    public void update() {
        for (BaseEnemy a : spawner.enemies) {
            if (this.shooting(a)) {
                this.rota = Rotate.degree(this.iCenter, this.jCenter, a.iCenter, a.jCenter);
                if (tick.getTick() >= timeShot + fireRate) {
                    bullets.add(new SniperBullet(this.i, this.j, this.rota, this));
                    timeShot = tick.getTick();
                    MediaPlayer sniper = new MediaPlayer(Music.sniperMedia);
                    sniper.play();
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
        snapshotParameters.setTransform(new javafx.scene.transform.Rotate(this.rota, 32, 32));
        snapshotParameters.setViewport(new Rectangle2D(0, 0, 64, 64));

        Image gun = gunImgView.snapshot(snapshotParameters,null);

        bullets.forEach(g->g.render(gc));
        gc.setStroke(Color.RED);
        gc.strokeOval(i - fireRange * Config.tileScale + 32, j - fireRange * Config.tileScale + 32, fireRange * Config.tileScale * 2, fireRange * Config.tileScale * 2);
        gc.drawImage(base, i, j);
        gc.drawImage(gun, i, j);
    }
}
