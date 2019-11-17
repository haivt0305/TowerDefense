package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import sample.Config;

public class Coin extends ImmovableObject {
    public int coin;

    public Coin(int coin) {
        this.coin = coin;

        this.i=13* Config.tileScale;
        this.j=2 * Config.tileScale;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "Coin: " + String.valueOf(coin);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.fillText(toString(), i, j);
    }

    @Override
    public void update() {

    }
}
