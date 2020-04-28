package Util;

public class CalculateShed {

    public double shedPrice(boolean isHalfWidth, double woodWidth, double pricePrWoodM, double carportLength, double doorKnobsPrice, double doorHingesPrice, double carportWidth){
        double shedPrice = 0;

        double amountOfShedCladding = new CalculateMaterials().calculateShedCladding(isHalfWidth, woodWidth, carportWidth, carportLength);
        shedPrice += amountOfShedCladding * pricePrWoodM + doorHingesPrice + doorKnobsPrice;

        return shedPrice;
    }


}
