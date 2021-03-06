package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Josef, Hallur, Thor og Frederik
 * Command used for creating an order and customerOrder in the database.
 */
public class CreateOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        new CalculatePrice().execute(request, response);
        new Drawing().execute(request,response);
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
        double cp_length = carportParts.getLength();
        double  cp_width = carportParts.getWidth();
        boolean hasShed = fullCarport.getCarportParts().isHasAShed();
        boolean shedHalf = fullCarport.getCarportParts().isHalfWidth();
        int claddingSides = carportParts.getSidesWithCladding();
        int roofAngle = roof.getRoofAngle();

        double price = (double) session.getAttribute("price");

        //We only want two digits
        price = (int)(price * 100 + 0.5) / 100.0;;
        CustomerOrder customerOrder = new CustomerOrder(roofMatId, carportMatId, shedMatId, orderID, userId, cp_length, cp_width,hasShed,shedHalf, claddingSides, roofAngle, price);
        LogicFacade.createCustomerDesign(customerOrder);

        request.setAttribute("message","DIN CARPORT ER NU GEMT OG DU KAN FINDE DEN PÅ DIN SIDE");
        return "design";
    }

}