package Util;

import FunctionLayer.Roof;

/**
 * Class for calculating the price of a roof.
 * Materials in a roof is defined in roof-class and calculated by the CalcRoofMaterials
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
