package Util;

import FunctionLayer.Svg;

public class DrawingBaseCarport {


    public void drawcCarportBase(int height, int width , String viewBox, int x, int y){
        Svg svg = new Svg(height, width, viewBox, x, y);

    }
}
