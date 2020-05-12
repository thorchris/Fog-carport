package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        double height = Double.parseDouble(request.getParameter("width"));
        double width = Double.parseDouble(request.getParameter("length"));
        int intHeight = (int) (height*100);
        int intWidth = (int) (width*100);

        Svg svg = new Svg(800, 600, "0,0,800,600",0,0);
        Svg svgInnerDrawing = new Svg(900,800,"0,0,900,800",0,0);

        //Basis carport
        svg.addRect(0,0,600,780);

        //Remme
        svg.addRect(0,35,4,780);
        svg.addRect(0,565,4,780);
        svg.addRect(0,565,4,780);
        svg.addRect(0,565,4,780);

        //Stolper
        svg.addRect(0,565,4,780);

        //Spær
        svg.addRect(0,565,4,780);

        request.setAttribute("svgdrawing", svg.toString());
        return "design";
    }
}
