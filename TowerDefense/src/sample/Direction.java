package sample;

public enum Direction {
    LEFT(180), UP(270), RIGHT(0), DOWN(90);

    int degree;

    Direction(int i) {
        degree = i;
    }

    public int getDegree() {
        return degree;
    }
}
