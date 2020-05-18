package PresentationLayer;

import FunctionLayer.FullCarport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for creating carport drawing
 */
public class Drawing extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        new CalculatePrice().execute(request, response);
        FullCarport fullCarport = (FullCarport) session.getAttribute("fullCarport");

        double carportLength = fullCarport.getCarportParts().getLength();
        double carportWidth = fullCarport.getCarportParts().getWidth();
        //Converting to metric measurements as they are metric on the actual site.
        int carportHeigthDB = (int) (carportLength * 100);
        int carportWidthDB = (int) (carportWidth * 100);

        //Aspect Ratio
        int intCarportLength;
        int intCarportWidth;

        if(carportLength < 5){
            intCarportLength = (int) (carportLength*120);
            intCarportWidth = (int) (carportWidth*120);
        }else{
            intCarportLength = (int) (carportLength*100);
            intCarportWidth = (int) (carportWidth*100);
        }

        //Viewbox
        Svg svg = new Svg(780, 750, "0,0,900,700", 0, 0);
        //Carport
        int startX = 0;
        int startY = 20;
        svg.addRect(startX, startY, intCarportLength, intCarportWidth);

        // Outer strap
        svg.addRect(startX+10, startY+10, intCarportLength-20, intCarportWidth-20);


        //Inner straps
        svg.addStraps(intCarportWidth,intCarportLength);

        //Rafters
        svg.addRafters(fullCarport, intCarportWidth,intCarportLength);

        //Shed
        svg.addShedPosts(fullCarport, intCarportWidth);

        //Carport posts
        svg.addPosts(fullCarport, intCarportWidth, intCarportLength);

        //Pointer vertical
        int pointerX = intCarportWidth + 20;
        int pointerY = startY;
        int finishY = intCarportLength;
        svg.addVerticalPointer(pointerX, pointerY,finishY, carportHeigthDB);

        //Horizontal pointer
        pointerX = startX;
        pointerY = intCarportLength + 20;
        int finishX = intCarportWidth;
        svg.addHorizontalPointer(pointerX, pointerY, finishX,carportWidthDB);

        request.setAttribute("svgdrawing", svg.toString());

        request.setAttribute("message","DIN PLANTEGNING ER NU KLAR");
        return "design";
    }
}
