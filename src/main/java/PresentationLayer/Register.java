package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This command is used for creating users.
 *      If the users need to be an employee, they must be generated directly in the database.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("email");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if (password1.equals(password2)) {
                User user = LogicFacade.createUser(email, password1);
                LogicFacade.login(email, password1);
                HttpSession session = request.getSession();
                user.setRole("customer");
                session.setAttribute("user", user);
                session.setAttribute("email", email);
                return "../index";
            } else {
                Log.finest("registrer " + "De to password passede ikke sammen under oprettelse");
                request.setAttribute("message", "DE TO PASSWORD PASSEDE IKKE SAMMEN");
                return "register";
            }
        } catch (LoginSampleException e) {
            Log.finest("registrer " + "Der opstod en fejl ved oprettelse af bruger - Tjek duplicate entry");
            request.setAttribute("message", "DER SKETE EN FEJL VED OPRETTELSE AF BRUGER, ELLER KONTAKT IT AFDELINGEN");
            return "register";
        }
    }
}