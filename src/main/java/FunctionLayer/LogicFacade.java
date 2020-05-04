package FunctionLayer;

import DBAccess.DataMapper;

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

    public static void insertData(int order_Id, int user_Id, FullCarport carport){
        DataMapper.addOrder(order_Id, user_Id, carport);
    }

    public static void main(String[] args) {
        int order_Id = 1;
        int user_Id = 1;

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

        LogicFacade.insertData(order_Id, user_Id, carport);
    }
}
