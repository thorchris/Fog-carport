package FunctionLayer;

import java.util.List;

public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;
    private static List<CarportMaterials> carportMaterials;
    private static List<User> customerList;
    private static List<Order> orderList;

    /**
     * initLists(): method uses logicFacade to fill the lists
     * roffMaterialList, carportMaterials and customerList with data from the database
     */

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

    /**
     * initOrderList(): method uses logicFacade and fills the list OrderList with orders
     */

    public static void initOrderList(){
        if(orderList == null){
            orderList = LogicFacade.getOrderList();
        }
    }

    /**
     * getRoffMaterialList()
     * getCarportMaterialsList()
     * getOrderList()
     * getCustomerList()
     * @return method returns lists made in initLists() and initOrderList() method.
     */

    public static List<RoofMaterials> getRoffMaterialList() {
        return roffMaterialList; 
    }

    public static List<CarportMaterials> getCarportMaterialsList() {
        return carportMaterials;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static List<User> getCustomerList(){
        return customerList;
    }



    public static void main(String[] args) {
        System.out.println(LogicFacade.getOrderList());
    }
}
