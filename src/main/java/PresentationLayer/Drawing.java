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
        FullCarport fullCarport= null;
        if(fullCarport == null){
            new CalculatePrice().execute(request, response);
            fullCarport = (FullCarport) session.getAttribute("fullCarport");
        }

        double height = fullCarport.getCarportParts().getLength();
        double width = fullCarport.getCarportParts().getWidth();
        //Omregnes fordi de er m på siden.
        int intHeight = (int) (height*100);
        int intWidth = (int) (width*100);

        Svg svg = new Svg(780, 750, "0,0,800,600",0,0);

        //Carport
        svg.addRect(0,0,intHeight,intWidth);
        //svg.addRect(0,0,600,780);

        //Posts
        svg.addPosts(svg, fullCarport, intWidth, intHeight);

        


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
