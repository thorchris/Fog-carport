package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCustomerOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = LogicFacade.getOrder(orderId);

        request.setAttribute("order", order);

        return "orderEmployee";
    }
}
