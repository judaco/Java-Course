package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class Point3D extends Point {

    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            if(obj instanceof Point3D){
                Point3D other = (Point3D)obj;
                return this.z == other.z;
            }
        }
        return false;
    }

    @Override
    protected String commaSeparatedComponents() {
        return super.commaSeparatedComponents() + "," + z;
    }
}
