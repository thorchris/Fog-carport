package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class GetCustomerOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        FullCarport carport = (FullCarport) session.getAttribute("fullCarport");
        User user = (User) session.getAttribute("user");

        Roof roof = carport.getRoof();
        CarportParts carportParts = carport.getCarportParts();
        Shed shed = carport.getShed();


        List<CustomerOrder> customerOrderList = new ArrayList<>();
        List<Integer> userOrderIdList = LogicFacade.getUserOrderIdList(user);
        for (Integer orderId : userOrderIdList) {
            int roofMatId = roof.getRoofmaterial().getMaterialID();
            int carportMatId = carportParts.getCarportMaterials().getMaterialID();
            int shedMatId = shed.getShedMaterials().getMaterialID();
            int orderID = orderId;
            int userId = user.getId();
            int cp_length = (int) carportParts.getLength();
            int cp_width = (int) carportParts.getWidth();
            int claddingSides = carportParts.getSidesWithCladding();
            int roofAngle = roof.getRoofAngle();
            int price = (int) session.getAttribute("price");
            CustomerOrder customerOrder = new CustomerOrder(roofMatId, carportMatId, shedMatId, orderID, userId,cp_length, cp_width, claddingSides, roofAngle, price);
            customerOrderList.add(customerOrder);
        }
        session.setAttribute("customerOrderList",customerOrderList);

        return "customer";
    }


}
