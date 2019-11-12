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

import sample.GameEntities.Map;
import sample.GameEntities.Road;
import sample.GameEntities.Spawner;
import sample.GameEntities.Bullet.AbstractBullet;
import sample.Gold;

import sample.GameEntities.Tower.NormalTower;

import java.util.ArrayList;

import java.util.List;



public class Main extends Application {
    public static GraphicsContext gc;
    public static List<GameObject> gameObjects = new ArrayList<>();
    public static List<Spawner> spawners = new ArrayList<>();
    public static List<AbstractBullet> bullets = new ArrayList<>();
    public static Time time = new Time();
    public static Gold gold = new Gold(350);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(Config.tileWidth * Config.tileScale, Config.tileHeight *Config.tileScale);
        gc = canvas.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        stage.setTitle("Tower Defense");

        stage.setResizable(false);

        Image start_button = new Image("file:src/AssetsKit_2/StartButton.png");
        ImageView imageView_start_button = new ImageView(start_button);

        Button button = new Button("", imageView_start_button);
        button.setWrapText(true);
        button.setTranslateX(Config.tileWidth * Config.tileScale - 780);
        button.setTranslateY(Config.tileHeight * Config.tileScale - 300);

        Image menu = new Image("file:src/AssetsKit_2/Menu.png");
        ImageView imageView_menu = new ImageView(menu);
        imageView_menu.setFitHeight(Config.tileHeight * Config.tileScale);
        imageView_menu.setFitWidth(Config.tileWidth * Config.tileScale);
        root.getChildren().add(imageView_menu);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                root.getChildren().removeAll(imageView_menu, button);

                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        render();
                        update();
                    }
                };
                timer.start();
            }
        });

        gameObjects.add(time);

        gameObjects.add(gold);
        gameObjects.add(new NormalTower(5,7));
        gameObjects.add(new NormalTower(14,4));
        spawners.add(new Spawner(50,20,5));

        root.getChildren().add(button);
        stage.setScene(scene);
        stage.show();
    }

    public void update() {
        spawners.forEach(Spawner::update);
        gameObjects.forEach(GameObject::update);
        bullets.forEach(AbstractBullet::update);
    }

    public void render() {
        Map.drawMap(gc);
        Road.drawPoint(gc);
        spawners.forEach(g -> g.render(gc));
        gameObjects.forEach(g -> g.render(gc));
        bullets.forEach(g -> g.render(gc));
    }
}




