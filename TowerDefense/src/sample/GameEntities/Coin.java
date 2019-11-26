package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import sample.Config;

public class Coin extends ImmovableObject {
    public int coin;

    public Coin(int coin) {
        this.coin = coin;

        this.i = 13 * Config.tileScale;
        this.j = 11 * Config.tileScale;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "COIN: " + String.valueOf(coin);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR,25));
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.BLACK);
        gc.fillText(toString(), i, j);
    }

    @Override
    public void update() {

    }
}
