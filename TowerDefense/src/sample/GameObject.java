package sample;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    public int i, j, x, y;
    public int iCenter;
    public int jCenter;

    public abstract void render(GraphicsContext gc);
    public abstract void update();
}
