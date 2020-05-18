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

        double carportWidth = fullCarport.getCarportParts().getLength();
        double carportHeight = fullCarport.getCarportParts().getWidth();
        //Omregnes fordi de er m på siden.
        int carportHeigthDB = (int) (carportHeight * 100);
        int carportWidthDB = (int) (carportWidth * 100);

        //Størrelsesforhold
        int intCarportHeight;
        int intCarportWidth;

        if(carportWidth < 5){
            intCarportHeight = (int) (carportHeight*120);
            intCarportWidth = (int) (carportWidth*120);
        }else{
            intCarportHeight = (int) (carportHeight*100);
            intCarportWidth = (int) (carportWidth*100);
        }

        //Viewbox
        Svg svg = new Svg(780, 750, "0,0,900,700", 0, 0);
        //Carport
        int startX = 0;
        int startY = 20;
        svg.addRect(startX, startY, intCarportHeight, intCarportWidth);

        // REMME YDRE
        svg.addRect(startX+10, startY+10, intCarportHeight-20, intCarportWidth-20);


        // REMME INDENI ( STRAPS )
        svg.addStraps(intCarportWidth,intCarportHeight);

        // Rafters
        svg.addRafters(fullCarport, intCarportWidth,intCarportHeight);

        //Shed
        svg.addShedPosts(fullCarport, intCarportWidth);

        //Carport posts
        svg.addPosts(fullCarport, intCarportWidth, intCarportHeight);

        //Pointer vertical
        int pointerX = intCarportWidth + 20;
        int pointerY = startY;
        int finishY = intCarportHeight;
        svg.addVerticalPointer(pointerX, pointerY,finishY, carportHeigthDB);

        //Horizontal pointer
        pointerX = startX;
        pointerY = intCarportHeight + 20;
        int finishX = intCarportWidth;
        svg.addHorizontalPointer(pointerX, pointerY, finishX,carportWidthDB);

        request.setAttribute("svgdrawing", svg.toString());

        request.setAttribute("message","DIN PLANTEGNING ER NU KLAR");
        return "design";
    }
}
