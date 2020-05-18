package Util;

import FunctionLayer.Shed;

/**
 * Class for calculating the price of a shed.
 * Materials in a shed is defined in shed-class and calculated by the CalcShedMaterials
 * @Author Josef, Hallur, Thor og Frederik
 */
public class CalculateShedPrice {
    public Shed shed;

    /**
     * Constructor for CalculateShedPrice
     * @param shed -> Makes sure that we're working on a object of the type shed - defined as a class variabel.
     *             All calls for width and height etc comes from the shed class's getters.
     */
    public CalculateShedPrice(Shed shed) {
        this.shed = shed;
    }

    /**
     * @param doorKnobPrice is the price for 1 doorknob
     * @param doorHingePrice is the price for 1 doorhinge
     * @return the total price for a shed
     * the method gets it's values from the shed class, which we get with the constructor
     */
    public double calcShedPrice(double doorKnobPrice, double doorHingePrice){
        double totalShedMaterialPrice = shed.getTotalShedCladding() * shed.getShedMaterials().getPricePrM2();
        double totalDoorKnobPrice = shed.getDoorKnob() * doorKnobPrice;
        double totalDoorHingePrice = shed.getDoorHinges() * doorHingePrice;
        double totalPriceForShed = totalShedMaterialPrice+totalDoorKnobPrice+totalDoorHingePrice;
        return totalPriceForShed;

    }
}
