package PresentationLayer;

import FunctionLayer.CarportCombined;
import FunctionLayer.LoginSampleException;
import Util.CalculateCarport;
import Util.CalculateMaterials;
import Util.CalculateRoof;
import Util.CalculateShed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarportCombinedOrder extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        CalculateMaterials cm = new CalculateMaterials();
        CalculateRoof cr = new CalculateRoof();

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        boolean wantAShed = Boolean.parseBoolean(request.getParameter("shedYesOrNo"));
        boolean isHalf = Boolean.parseBoolean(request.getParameter("isHalf"));
        int amountOfSides = Integer.parseInt(request.getParameter("claddingsides1"));
        int woodWidth = Integer.parseInt(request.getParameter("woodwidth"));
        boolean isHighRoof = Boolean.parseBoolean(request.getParameter("isHighRoof"));
        double roofHeight = cr.getRoofHeight();
        double roofLength = cr.getRoofLength();
        double roofWidth = cr.getRoofWidth();

        int totalPosts = cm.calculateAmountOfPosts(wantAShed, isHalf,length, width);
        int totalScrews = cm.calculateScrews();
        int totalRafters = cm.calculateRafters(width);
        int amountOfCladdingCarport = cm.calculateCladdingCarport(amountOfSides, length, width, woodWidth);
        double amountOfCladdingShed = cm.calculateShedCladding(isHalf, woodWidth, width, length);
        double amountOfRafter = cm.calculateRafters(width);
        double amountOfBrackets = cm.calculateBrackets(amountOfRafter);
        int fascia = 4; //TODO FIX DEBUGMASTER
        double totalRoofAreal = 0;
        if(isHighRoof){
            totalRoofAreal = cr.calcHighRoofAreal(length, roofHeight);
        } else {
            totalRoofAreal = cr.calcFlatRoofAreal(roofLength, length, roofWidth, width);
        }

        CarportCombined cc = new CarportCombined(totalPosts, totalScrews, totalRafters, amountOfCladdingCarport, amountOfCladdingShed, amountOfRafter, amountOfBrackets, fascia, totalRoofAreal, roofHeight);

        session.setAttribute("cc", cc);

        return "../index";
    }
}
