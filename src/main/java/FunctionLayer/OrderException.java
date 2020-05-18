package FunctionLayer;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Exception thrown or catched if something unexpected happens during getting orders from the database.
 */
public class OrderException extends Exception {

    public OrderException(String msg) {
        super(msg);
    }
}
