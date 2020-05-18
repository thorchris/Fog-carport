package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for getting an order from the database.
 */
public class GetCustomerOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException {
        HttpSession session = request.getSession();

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = LogicFacade.getOrder(orderId);

        session.setAttribute("order", order);

        return "orderEmployee";
    }
}
