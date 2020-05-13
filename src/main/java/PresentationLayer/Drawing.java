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

        Svg svg = new Svg(780, 750, "0,0,800,600", 0, 0);

        //Carport
        svg.addRect(0, 0, intCarportHeight, intCarportWidth);
        //svg.addRect(0,0,600,780);

        //Posts
        svg.addPosts(svg, fullCarport, intCarportHeight, intCarportWidth);
        //Shed
        if (fullCarport.getCarportParts().isHasAShed()) {

            if (fullCarport.getCarportParts().isHalfWidth() == true) {
                double shedWidth = fullCarport.getShed().getShedWidth();
                double shedLength = fullCarport.getShed().getShedLength();
                int intShedWidth = (int) (shedWidth * 100);
                int intShedHeight = (int) (shedLength * 100);
                //Shed

                svg.addRect(intCarportWidth, 0, intShedHeight, intShedWidth / 2);
            } else {
                double shedWidth = fullCarport.getShed().getShedWidth();
                double shedLength = fullCarport.getShed().getShedLength();
                int intShedWidth = (int) (shedWidth * 100);
                int intShedHeight = (int) (shedLength * 100);
                //Shed

                svg.addRect(intCarportWidth, 0, intShedHeight, intShedWidth);

            }
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
