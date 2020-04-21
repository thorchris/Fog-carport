package FunctionLayer;

import java.util.List;

public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;

    public static void initLists(){
        if(roffMaterialList == null){
            roffMaterialList = LogicFacade.getRoofMaterialList();
        }
    }

    public static List<RoofMaterials> getRoffMaterialList() {
        return roffMaterialList; 
    }

}
