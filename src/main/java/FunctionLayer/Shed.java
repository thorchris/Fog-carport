package FunctionLayer;

import Util.CalcShedMaterials;

public class Shed {
    /**
     * @globalvar: carportLength
     * @globalvar: carportWidth
     * @globalvar: shedWidth
     * @globalvar: shedLength
     * @globalvar: totalShedCladding
     * @globalvar: straps
     * @globalvar: totalShedCladding
     * @globalvar: totalShedCladding
     */

    private double carportLength, carportWidth, shedWidth, shedLength, totalShedCladding, straps;
    private boolean isHalfWidth;
    private int doorKnob, doorHinges;
    private ShedMaterials shedMaterials;

    public Shed(double carportLength, double carportWidth,boolean isHalfWidth, ShedMaterials shedMaterials) {
        CalcShedMaterials calcShedMaterials = new CalcShedMaterials(this);
        this.carportLength = carportLength;
        this.doorKnob = 1; // a door needs 1 doorknob
        this.doorHinges = 2; //a door needs 2 hinges
        this.carportWidth = carportWidth;
        this.isHalfWidth = isHalfWidth;
        this.shedMaterials = shedMaterials;
        setShedLength();
        this.totalShedCladding = calcShedMaterials.calculateShedCladding();
        this.straps = calcShedMaterials.calculateStraps();

        //If the shed is half width make it half of carport width, otherwise full width.
        if(isHalfWidth){
            shedWidth = carportWidth/2;
        } else{
            shedWidth = carportWidth;
        }

    }

     public double getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(double carportLength) {
        this.carportLength = carportLength;
    }

    public double getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(double carportWidth) {
        this.carportWidth = carportWidth;
    }

    public boolean isHalfWidth() {
        return isHalfWidth;
    }

    public void setHalfWidth(boolean halfWidth) {
        isHalfWidth = halfWidth;
    }

    public double getShedWidth() {
        return shedWidth;
    }

    public ShedMaterials getShedMaterials() {
        return shedMaterials;
    }

    public void setShedLength() {
        if (carportLength <= 3.6) {
            shedLength = 1.0;
        } else if (carportLength <= 5.1) {
            shedLength = 2.0;
        } else if (carportLength <= 7.8) {
            shedLength = 3.0;
        }
    }

    public double getShedLength() {
        return shedLength;
    }

    public double getTotalShedCladding() {
        return totalShedCladding;
    }

    public double getStraps() {
        return straps;
    }

    public int getDoorKnob() {
        return doorKnob;
    }

    public int getDoorHinges() {
        return doorHinges;
    }

    @Override
    public String toString() {
        return "Shed{" +
                "carportLength=" + carportLength +
                ", carportWidth=" + carportWidth +
                ", shedWidth=" + shedWidth +
                ", shedLength=" + shedLength +
                ", totalShedCladding=" + totalShedCladding +
                ", straps=" + straps +
                ", isHalfWidth=" + isHalfWidth +
                ", doorKnob=" + doorKnob +
                ", doorHinges=" + doorHinges +
                ", shedMaterials=" + shedMaterials +
                '}';
    }
}
