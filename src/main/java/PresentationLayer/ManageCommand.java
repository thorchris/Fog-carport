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
        String svgDrawing = request.getParameter("svgDrawing");
        String action = request.getParameter("action");

        if (calcPrice != null){
            action = "calculatePrice";
        } else if (createOrder != null){
            action = "createOrder";
        } else if (svgDrawing != null){
            action = "svgDrawing";
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
            default:
                return "design";
        }
    }
}
