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

    public static void drawPoint(GraphicsContext gc){
        for (int n = 0; n < wayPoints.length; n++){
            Circle point = new Circle();
            point.setCenterX( wayPoints[n].getX() );
            point.setCenterY( wayPoints[n].getY() );
            point.setRadius(10);
            gc.fillOval(wayPoints[n].getX(), wayPoints[n].getY(), 10, 10);
        }

    }
}
