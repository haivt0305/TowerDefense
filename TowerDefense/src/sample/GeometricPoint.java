package sample;

public class GeometricPoint {
    int i, j;
    double range;
    public GeometricPoint(int i, int j, double range) {
        this.i = i;
        this.j = j;
        this.range = range;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}