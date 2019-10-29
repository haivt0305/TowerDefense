package TD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("C:\\Users\\Admin\\Desktop\\Oriented-object Programming\\TowerDefense\\Texture\\Map.png"));
        //Image image1 = new Image(new FileInputStream("C:\\Users\\Admin\\Desktop\\Oriented-object Programing\\TowerDefense\\Texture\\Entities\\towerDefense_tile248.png"));

        ImageView imageView = new ImageView(image);
        //ImageView imageView1 = new ImageView(image1);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(1280/2);
        imageView.setFitWidth(2560/2);

        imageView.setPreserveRatio(true);

        Group root = new Group(imageView);

        Scene scene = new Scene(root, 2560/2, 1280/2);

        stage.setTitle("Tower Defense");

        stage.setScene(scene);

        stage.show();

    }
    public static void main(String args[]) {
        launch(args);
    }
}