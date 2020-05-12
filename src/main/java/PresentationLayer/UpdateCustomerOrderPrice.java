package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCustomerOrderPrice extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {


        int co_id = Integer.parseInt(request.getParameter("co_id"));
        int updatePrice = Integer.parseInt(request.getParameter("updatePrice"));
        LogicFacade.updatePrice(co_id,updatePrice);

        return "editEmployee";
    }
}
