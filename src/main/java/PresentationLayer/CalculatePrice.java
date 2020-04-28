package PresentationLayer;

import FunctionLayer.*;
import Util.CalculateCarport;
import Util.CalculateMaterials;
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
        Product rafter = null;

        CalculateMaterials cm = new CalculateMaterials();


        //Roof Materials
        List<RoofMaterials> roofMaterialsList = GenerateLists.getRoffMaterialList();
        String roofMaterialAsString = request.getParameter("roofMaterial");
        RoofMaterials userRoofMaterial = null;


        for (RoofMaterials roofMaterials : roofMaterialsList) {
            if(roofMaterials.getMaterialName().equals(roofMaterialAsString)){
                userRoofMaterial = roofMaterials;
            }
        }

        //Carport materials
        List<CarportMaterials> carportMaterials = GenerateLists.getCarportMaterialsList();
        String carportMaterialAsString = request.getParameter("carportMaterial");
        CarportMaterials userCarportMaterial = null;

        for (CarportMaterials carportMaterial : carportMaterials) {
            if(carportMaterial.getMaterialName().equals(carportMaterialAsString)){
                userCarportMaterial = carportMaterial;
            }
        }

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
        double woodPrice = wood.getPrice();
        double doorKnobPrice = doorKnob.getPrice();
        double doorHingesPrice = doorHinges.getPrice();
        double rafterPrice = rafter.getPrice();

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));

        double carportPrice = new CalculateCarport().calculateCarportPrice(length, width, postPrice, screwPrice, strapPrice);

        boolean wantAShed = Boolean.parseBoolean(request.getParameter("shedYesOrNo"));
        boolean isHalf = Boolean.parseBoolean(request.getParameter("isHalf"));

        double roofPrice = 0;
        boolean isHighRoof = Boolean.parseBoolean(request.getParameter("isHighRoof"));

        if(isHighRoof){
            int roofAngle = Integer.parseInt(request.getParameter("angle"));
            roofPrice = new CalculateRoof().highRoof(roofAngle, length, width, screwPrice, fasciaPrice, rafterPrice, bracketPrice, userRoofMaterial);
        } else {
            for (RoofMaterials roofMaterials : roofMaterialsList) {
                if (roofMaterials.getMaterialName().equals("Tagplader Plastmo blåtonet")) {
                    userRoofMaterial = roofMaterials;
                }
                 roofPrice = new CalculateRoof().flatRoof(length, width, screwPrice, fasciaPrice, rafterPrice, bracketPrice, userRoofMaterial);
            }
        }

        //Beklædning
        double woodWidth = 0;
        double claddingPrice = 0;
        if(wantAShed){
            int amountOfSides = Integer.parseInt(request.getParameter("claddingsides1"));
            woodWidth = userCarportMaterial.getWidth();
            int amountOfCladding = cm.calculateCladding(amountOfSides, length, width, woodWidth);
            claddingPrice = amountOfCladding * userCarportMaterial.getMaterialPriceM();
        } else {
            int amountOfSides = Integer.parseInt(request.getParameter("claddingsides"));
            woodWidth = userCarportMaterial.getWidth();
            int amountOfCladding = cm.calculateCladding(amountOfSides, length, width, woodWidth);
            claddingPrice = amountOfCladding * userCarportMaterial.getMaterialPriceM();
        }

        double shedPrice = 0;
        if(wantAShed){
            shedPrice = new CalculateShed().shedPrice(isHalf, length, woodWidth, woodPrice, doorKnobPrice, doorHingesPrice, width);
        }
        //Total pris
        double totalPrice = carportPrice + shedPrice + roofPrice + claddingPrice;
        String price = (String.format("%,.0f ,-", totalPrice));

        session.setAttribute("totalPrice", price);

        return "../index";
    }
}
