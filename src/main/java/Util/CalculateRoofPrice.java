package Util;

import FunctionLayer.Roof;

public class CalculateRoofPrice {
    private Roof roof;
    private double totalPrice;

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
            roof.setRoofAngle((roof.getRoofAngle()));
        }
        roof.setRoofAreal(new CalcRoofMaterials(roof).calcRoofAreal(roof));
        double totalPriceRoofMaterial = roof.getRoofmaterial().getmaterialPriceM2()*roof.getRoofAreal();
        totalPrice = totalScrewPrice + totalFasciaPrice + totalRafterPrice + totalBracketPrice+totalPriceRoofMaterial;
        return totalPrice;
    }


}
