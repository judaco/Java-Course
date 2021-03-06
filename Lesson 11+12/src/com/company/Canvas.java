package com.company;

/**
 * Created by Juda on 13/08/2016.
 */
public class Canvas {

    private boolean[][] canvas;//maarach du meimadi

    public Canvas(){//my constructor
        canvas = new boolean[60][90];//array of 60 rows and in each rows there are 90 booleans
    }


    public void drawRectangle(int x, int y, int width, int height){
        for (int i = 0; i < height; i++) {
            canvas[y + i][x] = true;//x - to right - ||
            canvas[y + i][x + width - 1] = true;// x + width = the distance right - ||
        }
        for (int j = 0; j < width; j++) {
            canvas[y][x + j] = true;// - top
            canvas[y + height - 1][x + j] = true;// - down
        }
    }

    public void drawSegment(Segment segment){

    }

    public void renderScreen(){
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }
}
