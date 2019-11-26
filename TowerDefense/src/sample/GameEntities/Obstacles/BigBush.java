package sample.GameEntities.Obstacles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;

public class BigBush extends BaseObstacle {

    Image bigBush;

    public BigBush(int x, int y) {
        this.i = 15 * Config.tileScale;
        this.j = 5 * Config.tileScale;
        bigBush = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile130.png");
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bigBush, i, j);
    }
}
