package Util;

import FunctionLayer.Roof;
import FunctionLayer.RoofMaterials;

import java.util.InputMismatchException;

public class CalcRoofMaterials {

    private Roof roof;
    private double roofAreal;

    public CalcRoofMaterials(Roof roof) {
        this.roof = roof;
        roofAreal = calcRoofAreal();
    }

    //Spær / rafters
    public double amountOfRafter() {
        double width = roof.getWidth();
        if (width < 0) {
            throw new InputMismatchException("Only positive numbers");
        }
        double rafters = (width * 2);
        if (rafters % width != 0) {
            rafters++;
        }
        double amountOfRafters = rafters;

        return amountOfRafters;
    }

    public double amountOfBrackets() {
        return amountOfRafter() * 2;
    }

    public double calcRoofAreal() {
        roofAreal = 0;
        if (roof.isHighRoof()) {
            roofAreal = HighRoofArealCalc();
        } else {
            roofAreal = calcFlatRoofAreal();
        }
        return roofAreal;
    }

    public double calcFlatRoofAreal() {
        return roof.getLength() * roof.getWidth();
    }

    public double roofArealCalc(double length, double roofHeight) {
        return (length * roofHeight) * 2;
    }

    public double HighRoofArealCalc() {
        int angle = roof.getRoofAngle();
        double length = roof.getLength();
        double roofAreal = 0;
        switch (angle) {
            case 15:
                roof.setRoofHeight(0.5);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 20:
                roof.setRoofHeight(0.55);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 25:
                roof.setRoofHeight(0.6);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 30:
                roof.setRoofHeight(0.65);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 35:
                roof.setRoofHeight(0.7);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 40:
                roof.setRoofHeight(0.75);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 45:
                roof.setRoofHeight(0.58);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 50:
                roof.setRoofHeight(0.85);
                roofAreal = roofArealCalc(length, roof.getRoofHeight());
                ;
                break;
            case 0:
                roofAreal = calcFlatRoofAreal();
        }

        return roofAreal;
    }


}
