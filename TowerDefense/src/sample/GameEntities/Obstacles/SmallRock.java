package sample.GameEntities.Obstacles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;

public class SmallRock extends BaseObstacle {
    Image smallRock;

    public SmallRock(int x, int y) {
        this.i = 17 * Config.tileScale;
        this.j = 3 * Config.tileScale;
        smallRock = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile135.png");
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(smallRock, i, j);
    }
}
