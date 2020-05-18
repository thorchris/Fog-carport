package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.SvgCustomer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCommand extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {

        String getCustomerOrder = request.getParameter("getCustomerOrder");
        String findCustomerOrder = request.getParameter("findCustomerOrder");
        String deleteOrder = request.getParameter("deleteOrder");
        String changePrice = request.getParameter("changePrice");

        String calcPrice = request.getParameter("calcPriceButton");
        String createOrder = request.getParameter("createOrderButton");

        String openSvgDrawing = request.getParameter("openSvgDrawing");

        String action = request.getParameter("action");

        if (calcPrice != null){
            action = "svgDrawing";
        } else if (createOrder != null){
            action = "createOrder";
        }

        if (getCustomerOrder != null){
            action = "getCustomerOrder";
        }

        if(findCustomerOrder != null){
            action = "findCustomerOrder";
        }

        if(deleteOrder != null){
            action = "deleteOrder";
        }
        if(changePrice != null){
            action = "changePrice";
        }

        if(openSvgDrawing != null){
            action = "openSvgDrawing";
        }


        switch (action) {
            case "createOrder":
                new CreateOrder().execute(request, response);
                return "design";
                
            case "getCustomerOrder":
                new GetCustomerOrder().execute(request,response);
                return "orderEmployee";

            case "findCustomerOrder":
                new FindCustomerOrder().execute(request,response);
                return "editEmployee";

            case "deleteOrder":
                new DeleteCustomerOrder().execute(request,response);
                return "orderEmployee";

            case "changePrice":
                new UpdateCustomerOrderPrice().execute(request,response);
                return "editEmployee";

            case "svgDrawing":
                new Drawing().execute(request, response);
                return "design";

            case "openSvgDrawing":
                new DrawingCustomer().execute(request,response);
                return "customerSvg";

            default:
                return "design";
        }
    }
}
