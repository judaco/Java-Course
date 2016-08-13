package com.company;


import graphicshape.Circle;
import graphicshape.Rectangle;
import graphicshape.Shape;
import graphicshape.Square;
//import graphicshape.Shape;

public class Main {

    public static void main(String[] args) {
	    /*
        Shape s = new Shape();
        s.color = 14567;
        System.out.println(s.color);
        Circle c = new Circle();
        c.color = 123;
        */

        /*Circle circle = new Circle(4);
        System.out.println(circle.area());
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(10, 5)
        };*/
        //System.out.println(shapes[0]);
        //System.out.println(sumOfArea(shapes));
/*
        Square square = new Square(5);
        square.setWidth(10);
        System.out.println(square.area());*/

//        Canvas canvas = new Canvas();
//        canvas.drawRectangle(6, 12, 30, 17);
//        canvas.drawRectangle(4, 8, 30, 17);
//        canvas.renderScreen();

        Point p1 = new Point(3,4);
        Point p2 = new Point(5,6);
        Segment segment = new Segment(p1, p2);
        p1.setX(3);

        Circle c = new Circle(14);
        c.fillColor(20, 10, 1.0f);
        c.fillColor(100, 120, 0);


    }

    public static double sumOfArea(Shape[] shapes){
        double sum = 0.0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }

    public static void change(int[] numbers){
        //numbers = new int[]{23,64,13};
        numbers[0] = 100;
    }
}
