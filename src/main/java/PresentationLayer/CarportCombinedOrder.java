package PresentationLayer;

import FunctionLayer.CarportCombined;
import FunctionLayer.LoginSampleException;
import Util.CalculateCarport;
import Util.CalculateMaterials;
import Util.CalculateRoof;
import Util.CalculateShed;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarportCombinedOrder extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        CalculateMaterials cm = new CalculateMaterials();
        CalculateRoof cr = new CalculateRoof();

        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        boolean wantAShed = Boolean.parseBoolean(request.getParameter("shedYesOrNo"));
        boolean isHalf = Boolean.parseBoolean(request.getParameter("isHalf"));
        int amountOfSides = Integer.parseInt(request.getParameter("claddingsides1"));
        int woodWidth = Integer.parseInt(request.getParameter("woodwidth"));


        int totalPosts = cm.calculateAmountOfPosts(wantAShed, isHalf,length, width);
        int totalScrews = cm.calculateScrews(totalPosts);
        int totalRafters = cm.calculateRafters(width);
        int amountOfCladdingCarport = cm.calculateCladdingCarport(amountOfSides, length, width, woodWidth);
        double totalAmountOfShedCladding = cm.calculateShedCladding(isHalf, woodWidth, width, length);
        double amountOfRafter = cm.calculateRafters(width);
        double amountOfBrackets =
        int fascia;
        double totalRoofAreal;
        double roofHeight;

        CarportCombined cc = new CarportCombined();

        return "../index";
    }
}
