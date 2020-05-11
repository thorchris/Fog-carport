package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCommand extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String calcPrice = request.getParameter("calcPriceButton");
        String createOrder = request.getParameter("createOrderButton");
        String action = request.getParameter("action");

        if (calcPrice != null){
            action = "calculatePrice";
        } else if (createOrder != null){
            action = "createOrder";
        }

        switch (action) {
            case "calcPrice":
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
