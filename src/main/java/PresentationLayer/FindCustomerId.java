package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for finding customerID, not yet implemented on the JSP page.
 */
public class FindCustomerId extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("customerEmail");
        int customerId = LogicFacade.getUserId(email);
        String message = "Kunde id for " + email + " er: " + customerId;

        request.setAttribute("customerId", customerId);
        request.setAttribute("message", message);


        return "editEmployee";
    }
}
