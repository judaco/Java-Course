package graphicshape;

/**
 * Created by Juda on 13/08/2016.
 */
public class Circles {

    void getArea(){
        Circle circle = new Circle();
        //call to public method within package:
        double a = circle.area();
        //call default method:
        circle.fillcolor();
        //access protected field within package:
        System.out.println(circle.color);;
        //access private field doesn't work!, since it's private for Circle (meant radius)
 //       System.out.println(circle.radius);
    }
}
