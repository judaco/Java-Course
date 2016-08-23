package com.company;

public class Main {
    public static void main(String[] args){
        MyClass.MyStaticNestedClass myStaticNestedClass = new MyClass.MyStaticNestedClass();
        MyClass.MyInnerClass myInnerClass = new MyClass(8).new MyInnerClass();
        myInnerClass.stam();



        Doable d = new Circle();
        d.whatToDo();

        Point[] points = {new Point(4,5),new Point(5,4),new Point(1,2)};
        sort(points);
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i]);
        }


        Button b = new Button();
        b.setListener(new Button.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("button clicked");
            }
        });

    }


    public static void sort(Comparable[] arr){
        boolean isSorted = false;
        int upTo = arr.length - 1;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if(arr[i].compare(arr[i+1])){
                    Comparable temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                }
            }
            upTo--;
        }


    }
}

class Point implements Comparable{
    int x, y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean compare(Object o) {
        if(o == null)
            return false;
        if(o instanceof Point){
            Point other = (Point)o;
            double d1 = this.distanceFromOrigin();
            double d2 = other.distanceFromOrigin();
            if(d1 > d2){
                return true;
            }else if(d1 == d2){
                if(this.x < other.x)
                    return true;
                else if(this.x == other.x){
                    if(this.y < other.y){
                        return true;
                    }
                    return false;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    double distanceFromOrigin(){
        return Math.sqrt(x*x + y*y);
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}


class Button{

    private String text;
    private OnClickListener listener;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    static interface OnClickListener{
        void onClick();
    }

    private void detectClick(){
        //lines of code to detect touch
        if(listener != null)
            listener.onClick();
    }

}