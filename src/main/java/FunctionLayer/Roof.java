package FunctionLayer;

import Util.CalcRoofMaterials;

/**
 * @Author Josef, Hallur, Thor og Frederik
 */
public class Roof {

    /**
     * Roof class:
     * @gbl length: Variable that stores the length of the roof
     * @gbl width: Variable that stores the width of the roof
     * @gbl screw: Variable that stores amount of screws for the roof 
     * @gbl fascia: Variable that stores amount of fascia for the roof 
     * @gbl rafter: Variable that stores amount of rafters for the roof 
     * @gbl bracket: Variable that stores amount of brackets for the roof 
     * @gbl roofHeight: Variable that stores the height of the roof 
     * @gbl roofAreal: Variable that stores the areal of the roof
     * @gbl roofmaterial: Variable that stores the material of the roof
     * @gbl isHighRoof: Variable that stores if it is a flat roof or not
     * @gbl roofAngle: Variable that stores the angle of the roof
     *
     *
     */
    private double length, width, screw, fascia, rafter, bracket, straps, roofHeight, roofAreal;
    private RoofMaterials roofmaterial;
    private boolean isHighRoof;
    private int roofAngle;

    /**
     * The constructor for roof calls calculation methods from the class CalcRoofMaterials.
     * I use these to determine the values for roof - The global variabels are set upon creating a instance of roof.
     * @param isHighRoof: Boolean value to show if the roof is high or flat
     * @param roofmaterial: Material of the roof
     * @param carportLength: Length of the carport, roof length is determined upon this value
     * @param carportWidth: Width of the carport, roof width is determined upon this value.
     *
     */
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

        setRoofHeight(roofAngle);
        //this.roofAreal = calcRoofMat.calcRoofAreal(this);

    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getStraps() {
        return straps;
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

    public void setRoofHeight(int roofAngle) {
        switch (roofAngle) {
            case 15:
                roofHeight = (0.5);
                break;
            case 20:
                roofHeight = (0.55);
                break;
            case 25:
                roofHeight = (0.6);
                break;
            case 30:
                roofHeight = (0.65);
                break;
            case 35:
                roofHeight = (0.7);
                break;
            case 40:
                roofHeight = (0.75);
                break;
            case 45:
                roofHeight = (0.8);
                break;
            case 50:
                roofHeight = (0.85);
                break;
            case 0:
                roofHeight = (0);
                break;
        }
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

    public void setRoofAreal(double roofAreal) {
        this.roofAreal = roofAreal;
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
                ", roofAreal=" + roofAreal +
                ", roofmaterial=" + roofmaterial +
                ", isHighRoof=" + isHighRoof +
                ", roofAngle=" + roofAngle +
                ", roofAreal=" + roofAreal +
                '}';
    }


}
