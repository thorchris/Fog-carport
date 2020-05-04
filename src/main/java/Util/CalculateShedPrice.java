package Util;

import FunctionLayer.Shed;

public class CalculateShedPrice {
    public Shed shed;

    public CalculateShedPrice(Shed shed) {
        this.shed = shed;

    }

    //totalShedCladding, straps, doorKnob, doorHinges, shedMaterial
    public double calcShedPrice(double strapsPrice, double doorKnobPrice, double doorHingePrice){
        double totalShedMaterialPrice = shed.getTotalShedCladding() * shed.getShedMaterials().getPricePrM2();
        double totalStrapsPrice = shed.getStrapLength() * strapsPrice;
        double totalDoorKnobPrice = shed.getDoorKnob() * doorKnobPrice;
        double totalDoorHingePrice = shed.getDoorHinges() * doorHingePrice;
        double totalPriceForShed = totalShedMaterialPrice+totalStrapsPrice+totalDoorKnobPrice+totalDoorHingePrice;
        return totalPriceForShed;

    }
}
