package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sample.Config;
import sample.Point;

public class Road {
    public static final Point[] wayPoints = new Point[] {
            new Point(1 * Config.tileScale, 8 * Config.tileScale),
            new Point(3 * Config.tileScale, 8 * Config.tileScale),
            new Point(3 * Config.tileScale, 5 * Config.tileScale),
            new Point(5 * Config.tileScale, 5 * Config.tileScale),
            new Point(5 * Config.tileScale, 1 * Config.tileScale),
            new Point(11 * Config.tileScale, 1 * Config.tileScale),
            new Point(11 * Config.tileScale, 7 * Config.tileScale),
            new Point(19 * Config.tileScale, 7 * Config.tileScale)
    };


}
