package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for updating a price of the customer.
 */
public class UpdateCustomerOrderPrice extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        int co_id = Integer.parseInt(request.getParameter("co_id"));
        int updatePrice = Integer.parseInt(request.getParameter("updatePrice"));
        LogicFacade.updatePrice(co_id,updatePrice);

        return "editEmployee";
    }
}
