package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCommand extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {

        String calcPrice = request.getParameter("calcPriceButton");
        String createOrder = request.getParameter("createOrderButton");
        String getCustomerOrder = request.getParameter("getCustomerOrder");
        String findCustomerOrder = request.getParameter("findCustomerOrder");
        String action = request.getParameter("action");

        if (calcPrice != null){
            action = "calculatePrice";
        } else if (createOrder != null){
            action = "createOrder";
        }

        if (getCustomerOrder != null){
            action = "getCustomerOrder";
        }

        if(findCustomerOrder != null){
            action = "findCustomerOrder";
        }

        switch (action) {
            case "getCustomerOrder":
                new GetCustomerOrder().execute(request,response);
                return "orderEmployee";
            case "findCustomerOrder":
                new FindCustomerOrder().execute(request,response);
                return "editEmployee";
            case "calculatePrice":
                new CalculatePrice().execute(request, response);
                return "design";
            case "createOrder":
                new CreateOrder().execute(request, response);
                return "design";
            default:
                return "design";
        }
    }
}
