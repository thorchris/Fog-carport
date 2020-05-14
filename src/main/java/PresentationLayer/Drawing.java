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
        int carportHeigthDB = (int) (carportHeight * 100);
        int carportWidthDB = (int) (carportWidth * 100);

        int intCarportHeight = 240;
        int  intCarportWidth = 240;
        //Viewbox
        Svg svg = new Svg(500, 750, "0,0,500,750", 0, 0);
        svg.addRect(0,0,500,640);
        //Carport
        int startX = 200;
        int startY = 220;
        svg.addRect(startX, startY, intCarportHeight, intCarportWidth);

        // REMME
        svg.addRect(startX+10, startY+10, intCarportHeight-20, intCarportWidth-20);

        //Shed
        svg.addShedPosts(svg, fullCarport);

        //Carport posts
        svg.addPosts(fullCarport, intCarportWidth);

        //Pointer vertical
        int pointerX = startX-20;
        int pointerY = startY;
        int finishY = 440;
        svg.addVerticalPointer(pointerX, pointerY, pointerX,finishY, carportHeigthDB);

        //Horizontal pointer
        pointerX = startX;
        pointerY = startY-20;
        int finishX = 440;
        svg.addHorizontalPointer(pointerX, pointerY, finishX, pointerY,carportWidthDB);


        //int x, int y, int height, int width

     /*   //Remme
        svg.addRect(0,35,4,780);
        svg.addRect(0,565,4,780);
        svg.addRect(0,565,4,780);
        svg.addRect(0,565,4,780);

        //Spær
        svg.addRect(0,565,4,780);*/

        request.setAttribute("svgdrawing", svg.toString());
        return "design";
    }
}
