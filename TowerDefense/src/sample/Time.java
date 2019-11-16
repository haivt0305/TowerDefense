package sample;

import javafx.scene.canvas.GraphicsContext;
import sample.GameEntities.ImmovableObject;

public class Time extends ImmovableObject {
    public  int[] time={0};

    public void upTime(){
        time[0]++;
    }

    public String toString() {
        return  String.valueOf(time[0])  ;
    }

    public int getTime() {
        return time[0];
    }

    public void render(GraphicsContext gc) {

    }

    public void update() {
        time[0]++;
    }
}