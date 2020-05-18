package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author Josef, Hallur, Thor og Frederik
 * EVERY COMMAND IN JSP IS CALLED FROM THIS HASHMAP.
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("calculatePrice", new CalculatePrice());
        commands.put("createCarport", new CreateCarport());
        commands.put( "redirect", new Redirect());
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put("logout", new LogoutSession());
        commands.put("findCustomerOrder", new FindCustomerOrder());
        commands.put("createOrder", new CreateOrder());
        commands.put("manageCommand", new ManageCommand());
        commands.put("getCustomerOrder", new GetCustomerOrder());
    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "taget" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, OrderException;

}
