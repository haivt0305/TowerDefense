package sample;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntities.ImmovableObject;

public class Tick extends ImmovableObject {
    public  int[] tick = {0};

    public void upTime(){
        tick[0]++;
    }

    public String toString() {
        return  String.valueOf(tick[0])  ;
    }

    public int getTick() {
        return tick[0];
    }

    public void render(GraphicsContext gc) {

    }

    public void update() {
        tick[0]++;
    }
}