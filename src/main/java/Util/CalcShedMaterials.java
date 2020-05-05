package Util;

import FunctionLayer.Shed;

public class CalcShedMaterials {

    /**
     * In this class we are calculating the material needed for the shed.
     */
    private Shed shed;
    private double totalShedCladding;

    /**
     * Constructor for CalcShedMaterials
     * @param shed -> Makes sure that we're working on a object of the type shed - defined as a class variabel.
     *             All calls for width and height etc comes from the shed class's getters.
     */

    public CalcShedMaterials(Shed shed) {
        this.shed = shed;
    }

    /**
     * Calculate the amount of shedcladding using the shed width and the width of the material that the shed is made from.
     * @return the amount of cladding needed in amount of wood
     */
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
     * Calculate the length of the straps for the shed
     * Amount of straps are set in the carportMaterial class
     */

    public double calculateStrapsLength() {
        double strapLengthShed = shed.getShedWidth() * 2;
        return strapLengthShed;
    }

}

