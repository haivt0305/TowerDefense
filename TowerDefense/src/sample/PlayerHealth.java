package sample;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntities.ImmovableObject;

public class PlayerHealth extends ImmovableObject {

    public int playerHealth;

    public PlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
        this.j = 18 * Config.tileScale;
        this.j = 1 * Config.tileScale;
    }

    public PlayerHealth() {

    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public String toString(){
        return "Player Health: " + String.valueOf(playerHealth);
    }

    public void render(GraphicsContext gc) {
        gc.fillText(toString(), i, j);
    }

    public void update() {

    }
}
