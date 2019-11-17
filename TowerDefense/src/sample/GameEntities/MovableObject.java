package sample.GameEntities;

import sample.GameObject;

public abstract class MovableObject implements GameObject {
    public int x, y, i, j;
    public int iCenter, jCenter;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getiCenter() {
        return iCenter;
    }

    public void setiCenter(int iCenter) {
        this.iCenter = iCenter;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getjCenter() {
        return jCenter;
    }

    public void setjCenter(int jCenter) {
        this.jCenter = jCenter;
    }
}
