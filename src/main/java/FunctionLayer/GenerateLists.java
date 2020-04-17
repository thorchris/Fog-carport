package FunctionLayer;

import java.util.List;

public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;
    private static List<CarportMaterials> carportMaterialList;

    public static void initLists(){
        if(roffMaterialList == null){
            roffMaterialList = LogicFacade.getRoofMaterialList();
        }
        if(carportMaterialList == null){
            carportMaterialList = LogicFacade.getCarportMaterialList();
        }
    }

    public static List<RoofMaterials> getRoffMaterialList() {
        return roffMaterialList; 
    }

    public static List<CarportMaterials> getCarportMaterialList() {
        return carportMaterialList;
    }
}
