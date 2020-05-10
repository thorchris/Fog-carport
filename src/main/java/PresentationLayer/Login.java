package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Her er en klasse der gør at kunden kan logge ind, hvis det er en admin der logger ind viderestilles administratoren til admin.jsp.
 *
 * @author Thor, Hallur, Josef og Frederik
 */
public class Login extends Command {
    /**
     * @param request - den aktuelle HTTP request
     * @param response - den aktuelle HTTP servlet response
     * @return - en string, som er den side der skal returneres når metoden er kort.
     * Denne sendes til frontcontrolleren, hvor der tilsættes den rette sti (WEB-INF/ ... )
     * @throws - LoginSampleException, en hjemmelavet exception som propageres (VI KASTER DEN BARE VÆK) og ikke håndteres.
     * @version - Færdige version for cupcake projektet.
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        String role = user.getRole();

        HttpSession session = request.getSession();

        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("user", user);
        request.setAttribute("message","Velkommen," + user.getEmail() + " du er nu logget ind ");

        switch (role) {
            case "employee":
                return "employee";
            default:
                return "../index";
        }

    }

}