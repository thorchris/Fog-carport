package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Command used for login, if the user is an employee it goes to the employee page and if it is a user it goes to the employee
 * @author Thor, Hallur, Josef og Frederik
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = LogicFacade.login(email, password);
            String role = user.getRole();

            HttpSession session = request.getSession();
            session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
            session.setAttribute("user", user);
            session.setAttribute("HeaderMessage", "Du er logget ind som: " + user.getEmail());

            switch (role) {
                case "employee":
                    return "employee";
                default:
                    return "../index";
            }
        } catch (LoginSampleException e) {
            request.setAttribute("message", "FEJL UNDER LOGIN, PRØV IGEN ELLER KONTAKT IT AFDELINGEN");
            return "login";
        }

    }

}