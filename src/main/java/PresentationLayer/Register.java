package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Her er en klasse der benyttes til at oprette en bruger og denne gemmes i databasen.
 * Admins skal oprettes direkte i databasen for at have admin rettigheder.
 * @author Thor, Hallur, Josef og Frederik
 */

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, password1 );
            LogicFacade.login(email,password1);
            HttpSession session = request.getSession();
            user.setRole("customer");
            session.setAttribute("user",user);
            session.setAttribute("email",email);
            return "../index";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }
}