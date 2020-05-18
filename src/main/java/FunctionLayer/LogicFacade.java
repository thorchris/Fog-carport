package FunctionLayer;

import DBAccess.DataMapper;
import DBAccess.UserMapper;

import java.util.List;

/**
 * The purpose of LogicFacade is to get a layer between datamappers and the java classes.
 * Logicfacade contains mostly static methods since we need to use the same connection and database through them all.
 * @author kasper - orignial
 * @Author Josef, Hallur, Thor og Frederik - edited
 */
public class LogicFacade {

    /**
     * @return list of roof materials
     */
    public static List<RoofMaterials> getRoofMaterialList(){
        return DataMapper.getRoofMaterialsList();
    }

    /**
     * @return list of carport materials
     */
    public static List<CarportMaterials> getCarportMaterialList(){
        return DataMapper.getCarportMaterialsList();
    }

    /**
     * @return list of products
     */
    public static List<Product> getProductList(){
        return DataMapper.getProductList();
    }

    /**
     * Creates order
     * @param user the user who owns the order.
     * @param carport the fullcarport design that the user is ordering
     */
    public static void createOrder(User user, FullCarport carport){
        DataMapper.addOrder(user, carport);
    }

    /**
     * Creates a user
     * @param email the users email
     * @param password the users password
     * @return a user that is created in the database.
     * @throws LoginSampleException, if the login fails
     */
    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password);
        UserMapper.createUser(user);
        return user;
    }

    /**
     * Login method
     * @param email users email
     * @param password users password
     * @return return the user that is login in
     * @throws LoginSampleException, if the login fails.
     */
    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    /**
     * @return a list of orders
     */
    public static List<Order> getOrderList(){
        return DataMapper.getOrderList();
    }

    /**
     * @return a list of users
     */
    public static List<User> getCustomerList(){
        return UserMapper.getCustomerList();
    }

    /**
     * @param email the email which we want to find the user id for
     * @return the user id which the email belongs to
     */
    public static int getUserId(String email){return UserMapper.getUserId(email);}

    /**
     * @param customerId the customers id (userID), which we want to find all orders connected to
     * @return returns all the customers orders.
     */
    public static List<CustomerOrder> getCustomerDesignOrder(int customerId) {
        return DataMapper.getCustomerDesignOrder(customerId);
    }

    /**
     * @param customerOrder inserts this customerOrder into the database
     */
    public static void createCustomerDesign(CustomerOrder customerOrder){
        DataMapper.createCustomerDesign(customerOrder);
    }

    /**
     * @param user, the users which order we want to search for
     * @return returns the users orderID
     */
    public static int getUserOrderId(User user) {
        return DataMapper.getUserOrderId(user);
    }

    /**
     * @param orderId, the order id for the order that we're searching for
     * @return the order with the given order id.
     * @throws OrderException, homemade exception thrown if something unexpected happens.
     */
    public static Order getOrder(int orderId) throws OrderException {
        return DataMapper.getOrder(orderId);
    }

    /**
     * @param orderId the order id which we want to find a customerOrder for
     * @return the customerOrder
     * @throws OrderException, homemade exception thrown if something unexpected happens.
     */
    public static CustomerOrder getCustomerOrder(int orderId) throws OrderException {
        return DataMapper.getCustomerOrder(orderId);
    }

    /**
     * @param orderId, the orderId of the customerOrder to delete
     */
    public static void deleteCustomerOrder (int orderId){
        DataMapper.deleteCustomerOrder(orderId);
    }

    /**
     * @param orderId, the orderId of the order to delete
     */
    public static void deleteOrder(int orderId){
        DataMapper.deleteOrder(orderId);
    }

    /**
     * @param co_id, the customerOrderId for the customerOrder which price wished to update
     * @param price, the new price of the CustomerOrder
     */
    public static void updatePrice(int co_id, int price){
        DataMapper.updatePrice(co_id,price);
    }



}
