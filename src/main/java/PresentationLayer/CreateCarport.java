package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CreateCarport extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        //CREATING CARPORT PARTS
        double length = Double.parseDouble(request.getParameter("length"));
        session.setAttribute("length", length);
        double width = Double.parseDouble(request.getParameter("width"));
        session.setAttribute("width", width);
        boolean hasAShed = Boolean.parseBoolean(request.getParameter("shedYesOrNo"));
        session.setAttribute("wantAShed", hasAShed);
        boolean isHalfWidth = Boolean.parseBoolean(request.getParameter("shedLength"));
        session.setAttribute("shedLength", isHalfWidth);

        //Carport materials from DB
        List<CarportMaterials> carportMaterials = GenerateLists.getCarportMaterialsList();
        String carportMaterialAsString = request.getParameter("carportMaterial");
        CarportMaterials userCarportMaterial = null;

        for (CarportMaterials carportMaterial : carportMaterials) {
            if(carportMaterial.getMaterialName().equals(carportMaterialAsString)){
                userCarportMaterial = carportMaterial;
            }
        }

        int sidesWithCladding = 0;
        if (hasAShed) {
            sidesWithCladding = Integer.parseInt(request.getParameter("claddingsides1"));
        } else {
            sidesWithCladding = Integer.parseInt(request.getParameter("claddingsides"));
        }
        session.setAttribute("sidesWithCladding", sidesWithCladding);

        CarportParts carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, userCarportMaterial, sidesWithCladding);
        session.setAttribute("carportParts",carportParts);

        //CREATING A SHED
        ShedMaterials shedMaterials = new ShedMaterials();
        Shed shed = new Shed(length, width, isHalfWidth, shedMaterials);
        session.setAttribute("shed",shed);

        //CREATING ROOF
        boolean isHighRoof = Boolean.parseBoolean(request.getParameter("isHighRoof"));
        session.setAttribute("isHighRoof",isHighRoof);


        List<RoofMaterials> roofMaterialsList = GenerateLists.getRoffMaterialList();
        String roofMaterialAsString = request.getParameter("roofMaterial");
        RoofMaterials userRoofMaterial = null;

        for (RoofMaterials roofMaterials : roofMaterialsList) {
            if(roofMaterials.getMaterialName().equals(roofMaterialAsString)){
                userRoofMaterial = roofMaterials;
            }
        }

        Roof roof = new Roof(isHighRoof, userRoofMaterial,length, width);
        if(isHighRoof){
            int roofAngle = Integer.parseInt(request.getParameter("angle"));
            session.setAttribute("roofAngle",roofAngle);
            roof.setRoofHeight(roofAngle);
            roof.setRoofAngle((roofAngle));
        }

        session.setAttribute("roof",roof);

        User user = (User) session.getAttribute("user");
        if(user==null){
            user = new User("KundeUdenLogin", "1234");
            user.setId(0);
            user.setRole("customer"); 
            session.setAttribute("user",user);
        }
        //CREATING FULL CARPORT
        FullCarport fullCarport = new FullCarport(carportParts, roof, shed);
        session.setAttribute("fullCarport", fullCarport) ;

        return "design";
    }
}
