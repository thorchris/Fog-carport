package Util;

import FunctionLayer.Shed;

public class CalculateShedPrice {
    public Shed shed;

    public CalculateShedPrice(Shed shed) {
        this.shed = shed;

    }

    /**
     *
     * @param strapsPrice is the price per meter of strap
     * @param doorKnobPrice is the price for 1 doorknob
     * @param doorHingePrice is the price for 1 doorhinge
     * @return the total price for a shed
     * the method gets it's values from the shed class, which we get with the constructor
     */

    //totalShedCladding, straps, doorKnob, doorHinges, shedMaterial
    public double calcShedPrice(double strapsPrice, double doorKnobPrice, double doorHingePrice){
        double totalShedMaterialPrice = shed.getTotalShedCladding() * shed.getShedMaterials().getPricePrM2();
        double totalDoorKnobPrice = shed.getDoorKnob() * doorKnobPrice;
        double totalDoorHingePrice = shed.getDoorHinges() * doorHingePrice;
        double totalPriceForShed = totalShedMaterialPrice+totalDoorKnobPrice+totalDoorHingePrice;
        return totalPriceForShed;

    }
}
