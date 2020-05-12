package FunctionLayer;

import DBAccess.DataMapper;
import DBAccess.UserMapper;

import javax.xml.crypto.Data;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static List<RoofMaterials> getRoofMaterialList(){
        return DataMapper.getRoofMaterialsList();
    }

    public static List<CarportMaterials> getCarportMaterialList(){
        return DataMapper.getCarportMaterialsList();
    }

    public static List<Product> getProductList(){
        return DataMapper.getProductList();
    }

    public static void createOrder(User user, FullCarport carport){
        DataMapper.addOrder(user, carport);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password);
        UserMapper.createUser(user);
        return user;
    }

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static List<Order> getOrderList(){
        return DataMapper.getOrderList();
    }

    public static List<User> getCustomerList(){
        return UserMapper.getCustomerList();
    }

    public static List<CustomerOrder> getCustomerDesign(User user) {
        return DataMapper.getCustomerDesign(user);
    }


    public static int getUserId(String email){return UserMapper.getUserId(email);}


    // TIL editEmployee.jsp
    public static List<CustomerOrder> getCustomerDesignOrder(int customerId) {
        return DataMapper.getCustomerDesignOrder(customerId);
    }

    public static void createCustomerDesign(CustomerOrder customerOrder){
        DataMapper.createCustomerDesign(customerOrder);
    }

    public static int getUserOrderId(User user) {
        return DataMapper.getUserOrderId(user);
    }

    public static Order getCustomerOrder(int orderId) throws OrderException {
        return DataMapper.getCustomerOrder(orderId);
    }

    public static void deleteOrder(int orderId){
        DataMapper.deleteOrder(orderId);
    }



}
