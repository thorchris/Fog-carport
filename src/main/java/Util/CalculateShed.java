package Util;

public class CalculateShed {

    public double shedPrice(boolean isHalfWidth, double shedLength, double woodWidth, double pricePrWoodM, double doorKnobsPrice, double doorHinges, double carportWidth){
        double shedPrice = 0;

        if(isHalfWidth){
            double shedWidth = carportWidth/2;
            shedPrice = (2*(shedWidth / woodWidth) * pricePrWoodM) + (2*(shedLength / woodWidth)* pricePrWoodM) + doorHinges + doorKnobsPrice;

        } else {
            double shedWidth = carportWidth;
            shedPrice = (2*(shedWidth / woodWidth)* pricePrWoodM) + (2*(shedLength / woodWidth) * pricePrWoodM) + doorHinges + doorKnobsPrice;
        }

        return shedPrice;
    }

    public static void main(String[] args) {
        double shedLength = 4.0;
        double woodWidth = 0.10;
        double pricePrWoodM = 29;
        double doorKnobsPrice = 100;
        double doorHinges = 50;
        double carportWidth = 3.5;
        System.out.println(new CalculateShed().shedPrice(true, shedLength, woodWidth, pricePrWoodM, doorKnobsPrice, doorHinges, carportWidth));

    }
}
