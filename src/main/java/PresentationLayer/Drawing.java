package PresentationLayer;

import FunctionLayer.FullCarport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Drawing extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
        HttpSession session = request.getSession();
        new CalculatePrice().execute(request, response);
        FullCarport fullCarport = (FullCarport) session.getAttribute("fullCarport");

        double carportWidth = fullCarport.getCarportParts().getLength();
        double carportHeight = fullCarport.getCarportParts().getWidth();
        //Omregnes fordi de er m på siden.
        int intCarportHeight = (int) (carportHeight * 100);
        int intCarportWidth = (int) (carportWidth * 100);

        intCarportHeight = 240;
        intCarportWidth = 240;
        //Viewbox
        Svg svg = new Svg(500, 750, "0,0,800,750", 0, 0);
        svg.addRect(0,0,500,640);
        //Carport
        int startX = 200;
        int startY = 220;
        svg.addRect(startX, startY, intCarportHeight, intCarportWidth);

        //Shed
        svg.addShedPosts(svg, fullCarport);

        //Carport posts
        svg.addPosts(fullCarport, intCarportWidth);




        //int x, int y, int height, int width

     /*   //Remme
        svg.addRect(0,35,4,780);
        svg.addRect(0,565,4,780);
        svg.addRect(0,565,4,780);
        svg.addRect(0,565,4,780);

        //Stolper
        svg.addRect(0,565,4,780);

        //Spær
        svg.addRect(0,565,4,780);*/

        request.setAttribute("svgdrawing", svg.toString());
        return "design";
    }
}
