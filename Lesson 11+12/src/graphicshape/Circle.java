package graphicshape;

/**
 * Created by Juda on 13/08/2016.
 */
public class Circle extends Shape {
    private int radius;

    public Circle(int r){
        setRadius(r);
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if(radius >= 0)
            this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    void fillColor(){
        System.out.println("color: " + color);
    }

    public void fillColor(int red, int green, int blue){

    }

    public void fillColor(float hue, float saturation, float brightness){

    }
}
