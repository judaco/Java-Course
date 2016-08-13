package graphicshape;

import com.company.Point;

/**
 * Created by Juda on 13/08/2016.
 */
public class Circle extends Shape {
    private int radius;
    private Point center;

    public Circle(Point center, int radius){
        this.center = center;
        setRadius(radius);
    }

    public Circle(int r) {//call up - this (10,10,r) --> public Circle(int xPos, int yPos, int radius)
        this(new Point(10,10),r);
    }

    public Circle(){//call up - this (7) --> public Circle (int r)
        this(7);
    }
    @Override
    public String toString(){
        return "center = (" + center + ") and radius = " + radius;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj instanceof Circle){
            Circle other = (Circle)obj;
            return other.center.equals(this.center) && other.radius == this.radius;
        }
        return false;
    }

    @Override
    public int hashCode() {//helping with the accelaration of search - this is a fun who returns a int
        //that represents the object
        return center.hashCode() ^ radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius >= 0)
            this.radius = radius;
    }

    public double area(){
        return Math.PI* radius * radius;
    }

    void fillcolor(){
        System.out.println("color: " + color);
    }
    public void fillColor(int red, int green, int blue){

    }
    public void fillColor(float hue, float saturation, float brightness){

    }
}
