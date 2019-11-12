package sample.GameEntities.Bullet;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.GameEntities.Enemy.AbstractEnemy;
import sample.GameObject;

import static sample.Main.gameObjects;

public class NormalBullet extends AbstractBullet{
    Image bullet;

    public NormalBullet(int i, int j, int i1, int j1, double rota){
        this.i = i;
        this.j = j;
        iCenter = i + 32;
        jCenter = j + 32;
        damage = 1;
        speed = 35;
        this.rota = rota;

        bullet = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile275.png") ;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bullet, i, j);
    }

    public boolean inRange(AbstractEnemy enemy){
        if(iCenter <= enemy.i + 64 && iCenter >= enemy.i && jCenter <= enemy.j + 64 && jCenter >= enemy.j){
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if(rota <= 90)   {
            i = (int) (i + speed * Math.sin(rota / 180 * Math.PI));
            j = (int) (j - speed * Math.cos(rota / 180 * Math.PI));
        }
        else if(rota <= 180) {
            i = (int) (i + speed * Math.cos((rota - 90) / 180 * Math.PI));
            j = (int) (j + speed * Math.sin((rota - 90) / 180 * Math.PI));
        }
        else if(rota <= 270) {
            i = (int) (i - speed * Math.sin((rota - 180) / 180 * Math.PI));
            j = (int) (j + speed * Math.cos((rota - 180) / 180 * Math.PI));
        }
        else {
            i = (int) (i - speed * Math.cos((rota - 270) / 180 * Math.PI));
            j = (int) (j - speed * Math.sin((rota - 270) / 180 *Math.PI));
        }

        iCenter = i + 32;
        jCenter = j + 32;
    }
}
