package sample;

public class Rotate {

    double rotate;
    public Rotate() {

    }
    public Rotate(double rotate) {
        this.rotate = rotate;
    }

    public static double degree(int x1, int y1, int x2, int y2) {
        double z1 = (y2 - y1) * -1;
        double z2 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double goc = (Math.acos(z1 / z2)) / Math.PI * 180;
        if((x2 - x1) >= 0) {
            return goc;
        }
        return 360 - goc;
    }
}

