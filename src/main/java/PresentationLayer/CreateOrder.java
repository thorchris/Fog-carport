package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreateOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        FullCarport fullCarport = (FullCarport) session.getAttribute("fullCarport");
        if(fullCarport == null){
            new CalculatePrice().execute(request, response);
            fullCarport = (FullCarport) session.getAttribute("fullCarport");
        }

        User user = (User) session.getAttribute("user");
        //Creates order aka stykliste
        LogicFacade.createOrder(user, fullCarport);

        //creates customerOrder aka kundeordre
        Roof roof = fullCarport.getRoof();
        CarportParts carportParts = fullCarport.getCarportParts();
        Shed shed = fullCarport.getShed();

        int roofMatId = roof.getRoofmaterial().getMaterialID();
        int carportMatId = carportParts.getCarportMaterials().getMaterialID();
        int shedMatId = shed.getShedMaterials().getMaterialID();
        int orderID = LogicFacade.getUserOrderId(user);
        int userId = user.getId();
        int cp_length = (int) carportParts.getLength();
        int cp_width = (int) carportParts.getWidth();
        int claddingSides = carportParts.getSidesWithCladding();
        int roofAngle = roof.getRoofAngle();
        double price = (double) session.getAttribute("price");

        CustomerOrder customerOrder = new CustomerOrder(roofMatId, carportMatId, shedMatId, orderID, userId, cp_length, cp_width, claddingSides, roofAngle, (int) price);
        LogicFacade.createCustomerDesign(customerOrder);

        request.setAttribute("message","DIN CARPORT ER NU GEMT OG DU KAN FINDE DEN PÅ DIN SIDE");
        return "design";
    }

}
