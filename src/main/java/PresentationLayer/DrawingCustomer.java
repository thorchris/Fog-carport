package PresentationLayer;

import DBAccess.DataMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for creating carport drawing on the customerpage.
 */
public class DrawingCustomer extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {

        int orderId = Integer.parseInt(request.getParameter("openSvgDrawing"));

        CustomerOrder customerOrder = LogicFacade.getCustomerOrder(orderId);
        Order order = DataMapper.getOrder(orderId);

        double carportWidth = customerOrder.getCp_width();
        double carportHeight = customerOrder.getCp_height();

        int carportHeigthDB = (int) (carportHeight * 100);
        int carportWidthDB = (int) (carportWidth * 100);

        int intCarportHeight;
        int intCarportWidth;

        if(carportWidth < 5){
            intCarportHeight = (int) (carportHeight*120);
            intCarportWidth = (int) (carportWidth*120);
        }else{
            intCarportHeight = (int) (carportHeight*100);
            intCarportWidth = (int) (carportWidth*100);
        }

        SvgCustomer svg = new SvgCustomer(780, 750, "0,0,900,700", 0, 0);

        int startX = 0;
        int startY = 20;
        svg.addRect(startX, startY, intCarportHeight, intCarportWidth);


        svg.addRect(startX+10, startY+10, intCarportHeight-20, intCarportWidth-20);

        svg.addStraps(intCarportWidth,intCarportHeight);

        svg.addRafters(order, intCarportWidth,intCarportHeight);

        svg.addShedPosts(customerOrder, intCarportWidth);

        svg.addPosts(order, intCarportWidth, intCarportHeight);

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

        request.setAttribute("svgCustomerDrawing", svg.toString());

        request.setAttribute("message","DIN PLANTEGNING ER NU KLAR");
        return "customerSvg";
    }
}
