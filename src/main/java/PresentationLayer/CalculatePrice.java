package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Product;
import FunctionLayer.RoofMaterials;
import Util.CalculateCarport;
import Util.CalculateRoof;
import Util.CalculateShed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CalculatePrice extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        Product screw = null;
        Product post = null;
        Product strap = null;
        Product fascia = null;
        Product bracket = null;
        Product wood = null;
        Product doorKnob = null;
        Product doorHinges = null;

        RoofMaterials roofMaterial = (RoofMaterials) session.getAttribute("roofMaterial");

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
        }
        double screwPrice = screw.getPrice();
        double postPrice = post.getPrice();
        double strapPrice = strap.getPrice();
        double fasciaPrice = fascia.getPrice();
        double bracketPrice = bracket.getPrice();
        double woodPrice = wood.getPrice();
        double doorKnobPrice = doorKnob.getPrice();
        double doorHingesPrice = doorHinges.getPrice();

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));

        double carportPrice = new CalculateCarport().calculateCarportPrice(length, width, postPrice, screwPrice, strapPrice);

        boolean wantAShed = Boolean.parseBoolean(request.getParameter("shedYesOrNo"));
        boolean isHalf = Boolean.parseBoolean(request.getParameter("isHalf"));

        double shedPrice = 0;
        if(wantAShed){
            shedPrice = new CalculateShed().shedPrice(isHalf, length, width, woodPrice, doorKnobPrice, doorHingesPrice);
        }



        double totalPrice = carportPrice + shedPrice;

        session.setAttribute("totalPrice", totalPrice);







        return "../index";
    }
}
