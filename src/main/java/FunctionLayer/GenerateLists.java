package FunctionLayer;

import java.util.List;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Class used for generating lists containing:
 *      Roof materials, carport materials and customers which is accessed from the database.
 *      These lists are static since these only need to be updated once on the JSP side.
 *
 *      Contains a list of orders as well, this list is non-static since we want it to generate a new list on the customerpage
 *      containing all the orders at that time, so it needs to be able to update it "as we go".
 *              //  Could might have been done with static as well.... //
 *
 */
public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;
    private static List<CarportMaterials> carportMaterials;
    private static List<User> customerList;
    private List<Order> orderList;

    /**
     * Gets the static lists with from the datamappers through the logicfacade.
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
     * Gets the non-static list with from the datamappers through the logicfacade.
     */
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

}
