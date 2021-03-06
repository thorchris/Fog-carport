package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This command is used for redirecting between pages.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String modtagerside = request.getParameter("modtagerside");

        switch (modtagerside){
            case "design":
                return "design";

            case "employee":
                // liste med alle kundebestillinger new OrderList().execute(request, response);
                return "employee";

            case "contact":
                return "contact";

            case "index":
                return "../index";

            case "register":
                return "register";

            case "login":
                return "login";

            case "editEmployee":
                return "editEmployee";

            case "orderEmployee":
                return "orderEmployee";

            case "customer":
                return "customer";

            case "customerSvg":
                return "customerSvg";

            default:
                return "index";
        }
    }
}