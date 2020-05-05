package FunctionLayer;

import DBAccess.DataMapper;
import DBAccess.UserMapper;

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

    public static void main(String[] args) {
        UserMapper um = new UserMapper();

        User user = new User("Josef@ja.dk", "kode");
        user.setId(12);
        User user2 = new User("sefef@ja.dk", "kode");


        um.getUserId("josef@tis.dk");
        System.out.println(um.getUserId("josef@tis.dk"));
        double length = 2;
        double width = 2;
        boolean hasAShed = true;
        boolean isHalfWidth = true;
        CarportMaterials carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        int sidesWithCladding = 2;
        CarportParts carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);

        ShedMaterials shedMaterials = new ShedMaterials();
        Shed shed = new Shed(length, width, isHalfWidth, shedMaterials);

        boolean isHighRoof = true;
        RoofMaterials roofMaterials = new RoofMaterials("testMateriale", 1, 25, 10,15);
        //RoofMaterials roofmaterial,double carportLength, double carportWidth
        Roof roof = new Roof(isHighRoof, roofMaterials,length, width);
        FullCarport carport = new FullCarport(carportParts, roof, shed);

        LogicFacade.insertData(user, carport);
    }
}
