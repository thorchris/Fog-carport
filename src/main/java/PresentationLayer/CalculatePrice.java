package PresentationLayer;

import FunctionLayer.*;
import Util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CalculatePrice extends Command {

    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        new CreateCarport().execute(request,response);
        HttpSession session = request.getSession();

        Product screw = null;
        Product post = null;
        Product strap = null;
        Product fascia = null;
        Product bracket = null;
        Product wood = null;
        Product doorKnob = null;
        Product doorHinges = null;
        Product rafter = null;

        for (Product product : LogicFacade.getProductList()) {
            if(product.getName().equals("skrue")) {
                screw = product;
            }
            if(product.getName().equals("stolpe")){
                post = product;
            }
            if(product.getName().equals("rem")){
                strap = product;
            }
            if(product.getName().equals("stern")){
                fascia = product;
            }
            if(product.getName().equals("beslag")){
                bracket = product;
            }
            if(product.getName().equals("beklædning")){
                wood = product;
            }
            if(product.getName().equals("dørhåndtag")){
                doorKnob = product;
            }
            if(product.getName().equals("dørhængsel")){
                doorHinges = product;
            }
            if(product.getName().equals("spær")){
                rafter = product;
            }

        }
        double screwPrice = screw.getPrice();
        double postPrice = post.getPrice();
        double strapPrice = strap.getPrice();
        double fasciaPrice = fascia.getPrice();
        double bracketPrice = bracket.getPrice();
        double doorKnobPrice = doorKnob.getPrice();
        double doorHingesPrice = doorHinges.getPrice();
        double rafterPrice = rafter.getPrice();

        double length = Double.parseDouble(request.getParameter("length"));
        session.setAttribute("length", length);
        double width = Double.parseDouble(request.getParameter("width"));
        session.setAttribute("width", width);
        boolean wantAShed = Boolean.parseBoolean(request.getParameter("shedYesOrNo"));
        session.setAttribute("wantAShed", wantAShed);
        boolean isHalf = Boolean.parseBoolean(request.getParameter("shedLength"));
        session.setAttribute("shedLength",isHalf);

        boolean isHighRoof = Boolean.parseBoolean(request.getParameter("isHighRoof"));
        session.setAttribute("isHighRoof",isHighRoof);

        //CARPORT
        CarportParts carportParts = (CarportParts) session.getAttribute("carportParts");
        CarportMaterials carportMaterial = carportParts.getCarportMaterials();
        double carportPrice = new CalculateCarportPartsPrice(carportParts).calculateCarportPartPrice(screwPrice, rafterPrice, postPrice,strapPrice,carportMaterial);

        //Skur
        Shed shed = (Shed) session.getAttribute("shed");
        double shedPrice = new CalculateShedPrice(shed).calcShedPrice(doorKnobPrice, doorHingesPrice);

        //TAG
        Roof roof = (Roof) session.getAttribute("roof");
        double roofPrice = new CalculateRoofPrice(roof).calcRoofPrice(screwPrice,fasciaPrice,rafterPrice,bracketPrice);

        //Total pris
        double totalPrice = carportPrice + shedPrice + roofPrice;
        //Bruges på createOrder
        session.setAttribute("price", totalPrice);
        String price = (String.format("%,.0f ,-", totalPrice));

        session.setAttribute("totalPrice", price);

        return "design";
    }
}
