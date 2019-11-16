package sample;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntities.ImmovableObject;

public class Gold extends ImmovableObject {

    public int Gold;

    public Gold(int gold) {
        this.Gold = gold;
        this.j = 18 * Config.tileScale;
        this.j = 1 * Config.tileScale;
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
        gc.fillText(toString(), i, j);
    }

    public void update() {

    }
}
