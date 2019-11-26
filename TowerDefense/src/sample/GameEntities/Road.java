package sample.GameEntities;

import sample.Config;
import sample.Point;

public class Road {
    public static final Point[] wayPoints = new Point[] {
            new Point(3 * Config.tileScale, 8 * Config.tileScale),
            new Point(3 * Config.tileScale, 5 * Config.tileScale),
            new Point(5 * Config.tileScale, 5 * Config.tileScale),
            new Point(5 * Config.tileScale, 1 * Config.tileScale),
            new Point(11 * Config.tileScale, 1 * Config.tileScale),
            new Point(11 * Config.tileScale, 7 * Config.tileScale),
            new Point(20 * Config.tileScale, 7 * Config.tileScale),
            new Point(20 * Config.tileScale, 7 * Config.tileScale),
    };
}
