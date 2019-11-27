package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import sample.GameEntities.*;
import sample.GameEntities.Map;
import sample.GameEntities.Obstacles.BigBush;
import sample.GameEntities.Obstacles.BigRock;
import sample.GameEntities.Obstacles.SmallBush;
import sample.GameEntities.Obstacles.SmallRock;
import sample.GameEntities.Spawner;
import sample.GameEntities.MovableObject;
import sample.GameEntities.ImmovableObject;
import sample.GameEntities.PlayerHealth;
import sample.GameEntities.Coin;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;


public class Main extends Application {
    public static GraphicsContext gc;
    public static Tick tick = new Tick();
    public static AnimationTimer timer;
    public static Coin coin = new Coin(300);
    public static PlayerHealth playerHealth = new PlayerHealth(1);
    public static Group root = new Group();
    public static Scene scene = new Scene(root);
    public static List<MovableObject> movableObjects = new ArrayList<>();
    public static List<ImmovableObject> immovableObjects = new ArrayList<>();
    public static Spawner spawner = new Spawner(10, 10, 100);
    public static Shop shop = new Shop();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(Config.tileWidth * Config.tileScale, Config.tileHeight * Config.tileScale);
        gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        stage.setTitle("Tower Defense");
        stage.setResizable(false);

        Image start_button = new Image("file:src/AssetsKit_2/StartButton.png");
        ImageView imageView_start_button = new ImageView(start_button);

        Image menu = new Image("file:src/AssetsKit_2/Menu.png");
        ImageView imageView_menu = new ImageView(menu);
        imageView_menu.setFitHeight(Config.tileHeight * Config.tileScale);
        imageView_menu.setFitWidth(Config.tileWidth * Config.tileScale);
        root.getChildren().add(imageView_menu);

        Button button = new Button("", imageView_start_button);
        button.setWrapText(true);
        button.setTranslateX(Config.tileWidth * Config.tileScale - 780);
        button.setTranslateY(Config.tileHeight * Config.tileScale - 300);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.getChildren().removeAll(imageView_menu, button);
                root.getChildren().add(Shop.normalTowerImgView);
                root.getChildren().add(Shop.machineGunImgView);
                root.getChildren().add(Shop.sniperTowerImgView);

                timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        try {
                            render();

                            update();
                         } catch (ConcurrentModificationException e) {
                                }
                    }
                };
                timer.start();
            }
        });
        immovableObjects.add(tick);
        immovableObjects.add(coin);
        immovableObjects.add(playerHealth);
        immovableObjects.add(shop);

        immovableObjects.add(new BigRock(17, 5));
        immovableObjects.add(new SmallRock(17, 3));
        immovableObjects.add(new BigBush(15, 5));
        immovableObjects.add(new SmallBush(15, 3));

        movableObjects.add(spawner);
        root.getChildren().add(button);

        Music.bgMediaPlayer.play();

        stage.setScene(scene);
        stage.show();
    }

    public static void update() {
        movableObjects.forEach(MovableObject::update);
        immovableObjects.forEach(ImmovableObject::update);
    }

    public static void render() {
        Map.drawMap(gc);
        movableObjects.forEach(g -> g.render(gc));
        immovableObjects.forEach(g -> g.render(gc));
    }
}
