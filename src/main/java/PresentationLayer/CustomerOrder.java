package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        FullCarport carport = (FullCarport) session.getAttribute("fullCarport");

        Roof roof = carport.getRoof();
        CarportParts carportParts = carport.getCarportParts();
        Shed shed = carport.getShed();

        int roofMatId = roof.getRoofmaterial().getMaterialID();
        int carportMatId = carportParts.getCarportMaterials().getMaterialID();
        int shedMatId = shed.getShedMaterials().getMaterialID();


        //int roofMatId, int cpMatId, int shedMatId, int orderId, int userId, int cp_length, int cp_width, int claddingSides, int roofAngle, int price
        //FunctionLayer.CustomerOrder customerOrder = new FunctionLayer.CustomerOrder(roofMatId, carportMatId, shedMatId, )
        //createCustomerDesign



        return null;
    }
}
