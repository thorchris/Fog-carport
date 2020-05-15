package PresentationLayer;

import FunctionLayer.*;
import com.sun.javafx.binding.StringFormatter;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
        double cp_length = carportParts.getLength();
        double  cp_width = carportParts.getWidth();
        int claddingSides = carportParts.getSidesWithCladding();
        int roofAngle = roof.getRoofAngle();

        double price = (double) session.getAttribute("price");
        DecimalFormat df = new DecimalFormat("#,##");
        double p = Double.parseDouble(df.format(price));

        //double price = Double.parseDouble(String.format("%.2f",session.getAttribute("price")));

        CustomerOrder customerOrder = new CustomerOrder(roofMatId, carportMatId, shedMatId, orderID, userId, cp_length, cp_width, claddingSides, roofAngle, p);
        LogicFacade.createCustomerDesign(customerOrder);

        return "design";
    }

}