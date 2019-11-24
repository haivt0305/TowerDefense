package sample.GameEntities.Obstacles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;

public class SmallBush extends BaseObstacle {
    Image smallBush;

    public SmallBush(int x, int y) {
        this.i = 15 * Config.tileScale;
        this.j = 3 * Config.tileScale;
        smallBush = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile131.png");
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(smallBush, i, j);
    }
}
