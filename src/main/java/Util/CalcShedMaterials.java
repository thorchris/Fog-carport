package Util;

import FunctionLayer.Shed;

public class CalcShedMaterials {

    /**
     * In this class we are calculating the cladding for the shed aswell as the strap length.
     *
     */
    private Shed shed;
    private double totalShedCladding;

    public CalcShedMaterials(Shed shed) {
        this.shed = shed;
    }
    public double calculateShedCladding() {
        double shedWidth = shed.getShedWidth();
        double amountOfCladdingWidth = 0;
        double amountOfCladdingLength = 0;

        double woodWidth = shed.getShedMaterials().getWoodWith();

        amountOfCladdingLength = (shed.getShedLength() / woodWidth);
        if (amountOfCladdingLength % woodWidth > 0) {
            amountOfCladdingLength++; //if we need extra to get 100% coverage
        }

        amountOfCladdingWidth = (shedWidth / woodWidth);
        if (amountOfCladdingWidth % woodWidth > 0) {
            amountOfCladdingWidth++; // If we need an extra to get 100% coverage.
        }

        totalShedCladding = amountOfCladdingLength + amountOfCladdingWidth;

        return totalShedCladding;
    }

    /**
     * Shed always needs two straps, one each side.
     *
     */

    //TODO Altid to straps til et skur
    public double calculateStrapsLength() {
        double strapLengthShed = shed.getShedWidth() * 2;
        return strapLengthShed;
    }

}

