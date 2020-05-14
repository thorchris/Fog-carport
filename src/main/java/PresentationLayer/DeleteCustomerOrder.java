package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCustomerOrder extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {


        int orderid = Integer.parseInt(request.getParameter("deleteOrder"));

        LogicFacade.deleteOrder(orderid);

        return "orderEmployee";
    }
}
