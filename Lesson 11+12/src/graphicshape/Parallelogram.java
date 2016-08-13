package graphicshape;

import com.company.Point;
import com.company.Segment;

/**
 * Created by Juda on 13/08/2016.
 */
public class Parallelogram extends Shape {

    Point p1, p2, p3;

    public Parallelogram(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    @Override
    public double area() {
        Triangle t = new Triangle(p1, p2, p3);
        return t.area() * 2;
    }

    public double perimeter(){
        Segment segment1 = new Segment(p1, p2);
        Segment segment2 = new Segment(p2, p3);
        return (segment1.length() + segment2.length()) * 2;
    }
}
