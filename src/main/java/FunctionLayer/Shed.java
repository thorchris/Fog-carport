package FunctionLayer;

import Util.CalcShedMaterials;

public class Shed {
    /**
     * @globalvar: carportLength - The carport length is used to determine the length of the shed you can choose.
     * @globalvar: carportWidth - The carport width is used to determine the width of the shed
     * @globalvar: shedWidth - Shed width is determined from the width of the carport (half or full)
     * @globalvar: shedLength - Shed length is set values of either 1,2 or 3 meters
     * @globalvar: totalShedCladding - Total shed cladding is a variable holding the total amount of cladding needed for the shed
     * @globalvar: straps - Straps is dertermined by width of the carport
     * @globalvar: doorKnob - One doorknob is always used
     * @globalvar: doorHinges - Two doorhinges always needed
     * @globalvar: shedMaterials - Shed Materials is the materials you can choose to have your shed built from
     */

    private double carportLength, carportWidth, shedWidth, shedLength, totalShedCladding, straps;
    private boolean isHalfWidth;
    private int doorKnob, doorHinges;
    private ShedMaterials shedMaterials;

    /**
     * @param carportLength The carport length is used to determine the length of the shed you can choose.
     * @param carportWidth  The carport width is used to determine the width of the shed
     * @param isHalfWidth This boolean is used for two options to chose size of the shed - half the width of the carport or the whole width of the carport
     * @param shedMaterials ShedMaterials is a class containing all materials used to build out a shed, doorknobs, doorhinges etc..
     */

    public Shed(double carportLength, double carportWidth,boolean isHalfWidth, ShedMaterials shedMaterials) {
        CalcShedMaterials calcShedMaterials = new CalcShedMaterials(this);
        this.carportLength = carportLength;
        this.doorKnob = 1; // a door needs 1 doorknob
        this.doorHinges = 2; //a door needs 2 hinges
        this.carportWidth = carportWidth;
        this.isHalfWidth = isHalfWidth;
        this.shedMaterials = shedMaterials;
        setShedLength();
        setShedWidth();
        this.totalShedCladding = calcShedMaterials.calculateShedCladding();
        this.straps = calcShedMaterials.calculateStrapsLength();
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
        }else if (carportLength <= 5.1 && carportLength > 3.6) {
            shedLength = 2.0;
        }else if (carportLength <= 7.8 && carportLength > 5.1) {
            shedLength = 3.0;
        }
    }

    public void setShedWidth(){
        //If the shed is half width make it half of carport width, otherwise full width.
        if(isHalfWidth){
            shedWidth = carportWidth/2;
        } else{
            shedWidth = carportWidth;
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
