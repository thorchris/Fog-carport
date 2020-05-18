package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for deleting a customerOrder in JSP
 */
public class DeleteCustomerOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        int orderid = Integer.parseInt(request.getParameter("deleteOrder"));

        LogicFacade.deleteCustomerOrder(orderid);
        LogicFacade.deleteOrder(orderid);

        return "orderEmployee";
    }
}
