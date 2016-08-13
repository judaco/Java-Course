package graphicshape;

/**
 * Created by Juda on 13/08/2016.
 */
public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width >= 0)
            this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height >= 0)
            this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
