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

    public static void insertData(User user, FullCarport carport){
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

    public static void main(String[] args) {
        System.out.println(LogicFacade.getOrderList());
    }
}
