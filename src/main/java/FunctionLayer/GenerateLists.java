package FunctionLayer;

import java.util.List;

public class GenerateLists {

    private static List<RoofMaterials> roffMaterialList;
    private static List<CarportMaterials> carportMaterials;
    private static List<User> customerList;
    private static List<Order> orderList;
    private static List<CustomerOrder> customerOrderList;

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

    public static void initOrderList(){
        if(orderList == null){
            orderList = LogicFacade.getOrderList();
        }
    }

    public static void initCustomerOrderList(User user){
        if(customerOrderList == null){
            int userId = user.getId();
            customerOrderList = LogicFacade.getCustomerDesignOrder(userId);
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

    public static List<User> getCustomerList(){return customerList; }

    public static List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public static void main(String[] args) {
        System.out.println(LogicFacade.getOrderList());
    }
}
