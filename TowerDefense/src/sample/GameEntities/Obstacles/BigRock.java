package sample.GameEntities.Obstacles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;

public class BigRock extends BaseObstacle {

    Image bigRock;

    public BigRock(int x, int y) {
        this.i = 17 * Config.tileScale;
        this.j = 5 * Config.tileScale;
        bigRock = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile136.png");
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bigRock, i, j);
    }
}
