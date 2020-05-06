package FunctionLayer;

import java.util.List;

public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;
    private static  List<CarportMaterials> carportMaterials;
    private static List<Order> orderList;

    public static void initLists(){
        if(roffMaterialList == null){
            roffMaterialList = LogicFacade.getRoofMaterialList();
        }
        if(carportMaterials == null){
            carportMaterials = LogicFacade.getCarportMaterialList();
        }

    }

    public static void initOrderList(){
        if(orderList == null){
            orderList = LogicFacade.getOrderList();
        }
    }

    public static List<RoofMaterials> getRoffMaterialList() {
        return roffMaterialList; 
    }

    public static List<CarportMaterials> getCarportMaterialsList() {
        return carportMaterials;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }
}
