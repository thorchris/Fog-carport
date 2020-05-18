package PresentationLayer;

import FunctionLayer.CustomerOrder;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for finding an customerOrder from the database.
 */
public class FindCustomerOrder extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String customerEmail = request.getParameter("customerEmail");

        int customerId = LogicFacade.getUserId(customerEmail);
        List<CustomerOrder> customerOrder = LogicFacade.getCustomerDesignOrder(customerId);


        String message = customerEmail +" designs";

        request.setAttribute("customerOrder",customerOrder);
        request.setAttribute("message",message);

        return "editEmployee";
    }
}
