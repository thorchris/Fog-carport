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

        double carportHeight = fullCarport.getCarportParts().getLength();
        double carportWidth = fullCarport.getCarportParts().getWidth();
        //Omregnes fordi de er m på siden.
        int intCarportHeight = (int) (carportHeight*100);
        int intCarportWidth = (int) (carportWidth*100);

        Svg svg = new Svg(780, 750, "0,0,800,600",0,0);

        //Carport
        svg.addRect(0,0,intCarportHeight,intCarportWidth);
        //svg.addRect(0,0,600,780);

        //Posts
        svg.addPosts(svg, fullCarport, intCarportWidth, intCarportHeight);

        if(fullCarport.getCarportParts().isHasAShed()) {
            double shedWidth = fullCarport.getShed().getShedWidth();
            double shedLength = fullCarport.getShed().getShedLength();
            int intShedWidth = (int) (shedWidth * 100);
            int intShedLength = (int) (shedLength * 100);
            //Shed
            svg.addRect(-intCarportWidth,intShedWidth,-intShedLength,intCarportHeight);
        }
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
