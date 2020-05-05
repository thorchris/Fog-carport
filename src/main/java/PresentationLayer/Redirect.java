package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Her er en klasse der benyttes til at navigere rundt imellem de forskellige side.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String modtagerside = request.getParameter("modtagerside");

        switch (modtagerside){
            case "checkout":
                return "checkout";

            case "sælger":
                // liste med alle kundebestillinger new OrderList().execute(request, response);
                return "sælger";

            case "index":
                return "../index";

            case "register":
                return "register";

            case "login":
                return "login";

            default:
                return "index";
        }
    }
}