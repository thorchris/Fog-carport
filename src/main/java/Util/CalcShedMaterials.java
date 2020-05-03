package Util;

import FunctionLayer.Shed;

public class CalcShedMaterials {

    private Shed shed;
    private double totalShedCladding, shedLength;

    public CalcShedMaterials(Shed shed) {
        this.shed = shed;
    }

    public double calculateShedCladding() {
        double shedWidth = shed.getCarportWidth();
        double amountOfCladdingWidth = 0;
        double amountOfCladdingLength = 0;

        double woodWidth = shed.getShedMaterials().getWoodWith();

        amountOfCladdingLength = (shedLength / woodWidth);
        if (shedLength % woodWidth > 0) {
            amountOfCladdingLength++; //if we need extra to get 100% coverage
        }

        amountOfCladdingWidth = (shedWidth / woodWidth);
        if (shedWidth % woodWidth > 0) {
            amountOfCladdingWidth++; // If we need an extra to get 100% coverage.
        }

        totalShedCladding = amountOfCladdingLength + amountOfCladdingWidth;

        return totalShedCladding;
    }

    public double calculateStraps() {
        double shedWidth = shed.getShedWidth();
        double strapLengthShed = 0;
            if (shed.isHalfWidth()) {
                strapLengthShed = shedWidth / 2;
            } else {
                strapLengthShed = shedWidth;
        }
        return strapLengthShed;
    }

}

