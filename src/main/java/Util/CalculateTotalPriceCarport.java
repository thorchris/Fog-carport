package Util;

public class CalculateTotalPriceCarport {
    //carport
    double length = 7.8;
    double width = 3.9;
    double materialPrice = 29;
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

    public double calculateTotalPrice(){
       return new CalculateCarport().calculateCarportPrice(length, width, postsPrice, skrewPrice, strapPrice)
               + new CalculateShed().shedPrice(isHalf, shedLength, woodWidth, pricePrWoodM, doorKnobsPrice, doorHinges)
               + new CalculateRoof().highRoof(25,length, width);
    }

    public static void main(String[] args) {
        System.out.println(new CalculateTotalPriceCarport().calculateTotalPrice());
    }

}
