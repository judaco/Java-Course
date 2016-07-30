package graphicshape;

/**
 * Created by Juda on 30/07/2016.
 */
public class Circle extends Shape {
    private int radius;

    public double area(){
        return 3.14 * radius * radius;
    }

    void fillColor(){
        System.out.println("color: " + color);
    }
}
