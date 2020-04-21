package Util;

public class CalculateTotalPriceCarport {
    //carport
    double length = 7.8;
    double width = 3.9;
    double materialPriceM2 = 29;
    double postsPrice = 50;
    double skrewPrice = 20;
    double strapPrice = 20;

    //Shed
    double shedLength = 2.40;
    double woodWidth = 0.10;
    double pricePrWoodM = 29;
    double doorKnobsPrice = 100;
    double doorHinges = 50;
    boolean isHalf = false;


/*

    public double calculateTotalPrice(boolean isRoofHigh){
        double totalPrice = 0;
        totalPrice += new CalculateCarport().calculateCarportPrice(length, width, postsPrice, skrewPrice, strapPrice);
        totalPrice += new CalculateShed().shedPrice(isHalf, shedLength, woodWidth, pricePrWoodM, doorKnobsPrice, doorHinges):

        if(isRoofHigh){
            totalPrice += new CalculateRoof().highRoof(angle, length, width, screwPrice, fasciaPrice, rafterPrice, bracketPrice, roofmaterial);
        }else {
            totalPrice += new CalculateRoof().flatRoof(length, width, roofmaterialPriceM2, screwPrice, fasciaPrice, rafterPrice, bracketPrice, roofmaterial);
        }


        return totalPrice;
    }
*/


}
