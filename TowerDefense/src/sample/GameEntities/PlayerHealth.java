package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import sample.Config;

import static sample.Main.*;

public class PlayerHealth extends ImmovableObject {
    public int playerHealth;

    public PlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;

        this.j = 13 * Config.tileScale;
        this.j = 4 * Config.tileScale;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    @Override
    public String toString() {
        return "Player Health: " + String.valueOf(playerHealth);
    }
    @Override
    public void render(GraphicsContext gc) {
        gc.fillText(toString(), i, j);

    }

    @Override
    public void update() {

    }
}
