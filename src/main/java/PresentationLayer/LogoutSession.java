package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Thor, Hallur, Josef og Frederik
 * Command used reseting the session
 */

public class LogoutSession extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        ServletContext context = request.getSession().getServletContext();
        session.setAttribute("email", null);
        context.setAttribute("user",null);
        session.invalidate();

        return "../index";
    }
}
