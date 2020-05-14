package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCommand extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {

        String svgDrawing = request.getParameter("svgDrawing");

        String calcPrice = request.getParameter("calcPriceButton");
        String createOrder = request.getParameter("createOrderButton");
        String getCustomerOrder = request.getParameter("getCustomerOrder");
        String findCustomerOrder = request.getParameter("findCustomerOrder");
        String deleteOrder = request.getParameter("deleteOrder");
        String changePrice = request.getParameter("changePrice");

        String action = request.getParameter("action");

        if (calcPrice != null){
            action = "calculatePrice";
        } else if (createOrder != null){
            action = "createOrder";
        } else if (svgDrawing != null){
            action = "svgDrawing";
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

        switch (action) {
            case "calculatePrice":
                new CalculatePrice().execute(request, response);
                return "design";

            case "createOrder":
                new CreateOrder().execute(request, response);
                return "design";

            case "svgDrawing":
                new Drawing().execute(request, response);
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
                return "orderEmployee";

            default:
                return "design";
        }
    }
}
