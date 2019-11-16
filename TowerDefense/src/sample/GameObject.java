package sample;

import javafx.scene.canvas.GraphicsContext;

public interface GameObject {


    public abstract void render(GraphicsContext gc);
    public abstract void update();
}
