package Util;

import FunctionLayer.Roof;

/**
 * Class for calculating the price of a roof.
 * Materials in a roof is defined in roof-class and calculated by the CalcRoofMaterials
 * @Author Josef, Hallur, Thor og Frederik
 */
public class CalculateRoofPrice {
    private Roof roof;
    private double totalPrice;

    /**
     *  Constructor for CalculateRoofPrice
     *      * @param roof -> Makes sure that we're working on a object of the type roof - defined as a class variabel.
     *      *             All calls for width and height etc comes from the roof class's getters.
     */
    public CalculateRoofPrice(Roof roof) {
        this.roof = roof;
    }

    /**
     *
     * @param screwPricePrPiece: Variable that stores the screw price pr screw
     * @param fasciaPricePrPiece: Variable that stores the fascia price pr fascia
     * @param rafterPricePrPiece: Variable that stores the rafter price pr rafter
     * @param bracketPricePrPiece: Variable that stores the bracket price pr bracket
     * @localvar totalPriceRoofMaterial: Stores the price of the roofmaterial pr m2 multiplied with the roof size
     * @return double totalPrice, that stores the return value of the 4 doubles totalScrewPrice, totalFasciaPrice, totalRafterPrice and TotalBracketPrice
     * The double does also contain the price for the amount of roofMaterial for the given roof and calulates totalPrice
     * These local variables are added and or multiplied to calculate the total price for the roof.
     */
    public double calcRoofPrice(double screwPricePrPiece, double fasciaPricePrPiece, double rafterPricePrPiece, double bracketPricePrPiece){
        double totalScrewPrice = roof.getScrew()*screwPricePrPiece;
        double totalFasciaPrice = roof.getFascia()*fasciaPricePrPiece;
        double totalRafterPrice = roof.getRafter()*rafterPricePrPiece;
        double totalBracketPrice = roof.getBracket()*bracketPricePrPiece;
        if(roof.isHighRoof()){
            roof.setRoofHeight(roof.getRoofAngle());
        }
        roof.setRoofAreal(new CalcRoofMaterials(roof).calcRoofAreal(roof));
        double totalPriceRoofMaterial = roof.getRoofmaterial().getmaterialPriceM2()*roof.getRoofAreal();
        totalPrice = totalScrewPrice + totalFasciaPrice + totalRafterPrice + totalBracketPrice+totalPriceRoofMaterial;
        return totalPrice;
    }


}
