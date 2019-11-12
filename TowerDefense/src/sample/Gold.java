package sample;

import javafx.scene.canvas.GraphicsContext;

public class Gold extends GameObject {

    public int Gold;
    int x;
    int y;

    public Gold(int gold) {
        this.Gold = gold;
        this.x = 18 * Config.tileScale;
        this.y = 1 * Config.tileScale;
    }

    public Gold() {

    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        this.Gold = gold;
    }

    public String toString(){
        return "Gold: " + String.valueOf(Gold);
    }

    public void render(GraphicsContext gc) {
        gc.fillText(toString(), x, y);
    }

    public void update() {

    }
}
