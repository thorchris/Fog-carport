package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;
    private static List<CarportMaterials> carportMaterials;
    private static List<User> customerList;
    private List<Order> orderList;

    public static void initLists(){
        if(roffMaterialList == null){
            roffMaterialList = LogicFacade.getRoofMaterialList();
        }
        if(carportMaterials == null){
            carportMaterials = LogicFacade.getCarportMaterialList();
        }
        if(customerList == null){
            customerList = LogicFacade.getCustomerList();
        }

    }

    public void initOrderList(){
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public static List<User> getCustomerList(){return customerList; }



    public static void main(String[] args) {
        GenerateLists generateLists = new GenerateLists();
        generateLists.initOrderList();
        System.out.println("Fra klassen:" + generateLists.getOrderList());
        System.out.println("Fra dm" + LogicFacade.getOrderList());
    }
}
