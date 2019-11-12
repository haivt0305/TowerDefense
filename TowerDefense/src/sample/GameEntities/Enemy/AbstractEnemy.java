package sample.GameEntities.Enemy;

import sample.*;
import sample.GameEntities.GameEntity;

public abstract class AbstractEnemy extends GameObject implements GameEntity {
    int armor;
    int gold;
    int speed;
    Direction direction;
}
