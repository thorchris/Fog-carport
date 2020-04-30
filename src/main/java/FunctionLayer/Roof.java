package FunctionLayer;

import Util.CalcRoofMaterials;

public class Roof {

    private double length, width, screw, fascia, rafter, bracket, roofHeight, roofAreal;
    private RoofMaterials roofmaterial;
    private boolean isHighRoof;
    private int roofAngle;

    public Roof(boolean isHighRoof, RoofMaterials roofmaterial,double carportLength, double carportWidth) {
        CalcRoofMaterials calcRoofMat = new CalcRoofMaterials(this);
        this.isHighRoof = isHighRoof; //boolean to see if roof is high
        this.length = carportLength + 0.15; //roof is 0.15 m longer than carport
        this.width = carportWidth + 0.15; //roof is 0.15 m widder than carport
        this.screw = 100; //their needs to be 100 screws for the roof.
        this.fascia = 4; //roof needs 4 fascia.
        this.rafter = calcRoofMat.amountOfRafter(); //calling calc method to get amount of rafter
        this.bracket = calcRoofMat.amountOfBrackets(); //calling calc method to get amount of brackets
        this.roofmaterial = roofmaterial;
        this.roofAngle = 0; //standard is set to 0.
        this.roofAreal = calcRoofMat.calcRoofAreal();

    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double getRafter() {
        return rafter;
    }

    public void setRafter(double rafter) {
        this.rafter = rafter;
    }

    public double getBracket() {
        return bracket;
    }

    public void setBracket(double bracket) {
        this.bracket = bracket;
    }

    public RoofMaterials getRoofmaterial() {
        return roofmaterial;
    }

    public void setRoofmaterial(RoofMaterials roofmaterial) {
        this.roofmaterial = roofmaterial;
    }

    public double getWidth() {
        return width;
    }

    public boolean isHighRoof() {
        return isHighRoof;
    }

    public void setRoofAngle(int roofAngle) {
        this.roofAngle = roofAngle;
    }

    public int getRoofAngle() {
        return roofAngle;
    }

    public double getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

    public double getScrew() {
        return screw;
    }

    public double getFascia() {
        return fascia;
    }

    public double getRoofAreal() {
        return roofAreal;
    }



    @Override
    public String toString() {
        return "Roof{" +
                "length=" + length +
                ", width=" + width +
                ", screw=" + screw +
                ", fascia=" + fascia +
                ", rafter=" + rafter +
                ", bracket=" + bracket +
                ", roofHeight=" + roofHeight +
                ", roofmaterial=" + roofmaterial +
                ", isHighRoof=" + isHighRoof +
                ", roofAngle=" + roofAngle +
                '}';
    }
}
