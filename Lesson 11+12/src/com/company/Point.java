package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class Point {
    private int x, y;

    public Point(int x, int y) {//constructor
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(x < 0)
            return;
        this.x = x;
    }

    @Override
    public String toString() {
        return "(" + commaSeparatedComponents() + ")";
    }

    protected String commaSeparatedComponents(){
        return x + "," + y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(y < 0)
            return;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(obj instanceof Point){
            Point other = (Point)obj;
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (7 * x) ^ (11 * y) ^ (53 * y);
    }

    public double distanceTo(Point other){//distance between other and the point on her the methoud setted on
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);//square root
    }
}
