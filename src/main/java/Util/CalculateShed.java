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


}
