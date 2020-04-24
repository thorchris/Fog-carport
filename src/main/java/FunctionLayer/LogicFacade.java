package FunctionLayer;

import DBAccess.DataMapper;

import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static List<RoofMaterials> getRoofMaterialList(){
        return DataMapper.getRoffMaterialsList();
    }

    public static List<CarportMaterials> getCarportMaterialList(){
        return DataMapper.getCarportMaterialsList();
    }

    public static List<Product> getProductList(){
        return DataMapper.getProductList();
    }


}
