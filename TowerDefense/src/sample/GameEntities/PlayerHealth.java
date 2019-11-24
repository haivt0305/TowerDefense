package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import sample.Config;

import static sample.Main.*;

public class PlayerHealth extends ImmovableObject {
    public int playerHealth;

    public PlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;

        this.i = 13 * Config.tileScale;
        this.j = 12 * Config.tileScale - 33;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    @Override
    public String toString() {
        return "PLAYER HEALTH: " + String.valueOf(playerHealth);
    }
    @Override
    public void render(GraphicsContext gc) {
        gc.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR,25));
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.fillText(toString(), i, j);

        if(playerHealth <= 0) {

            ImageView gameover = new ImageView(new Image("file:src/AssetsKit_2/GameOver.png"));
            gameover.setFitWidth(10 * Config.tileScale);
            gameover.setFitHeight(5 * Config.tileScale);
            gameover.setTranslateX(Config.tileWidth * Config.tileScale - 975);
            gameover.setTranslateY(Config.tileHeight * Config.tileScale - 600);

            timer.stop();

            root.getChildren().add(gameover);

        }
    }
    @Override
    public void update() {

    }
}
