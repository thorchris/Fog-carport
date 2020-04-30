package Util;

import FunctionLayer.Roof;

import java.util.InputMismatchException;

public class CalcRoofMaterials {

    private Roof roof;
    private double roofAreal;
    private double roofHeight;

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
        if (roof.isHighRoof()) {
            roofAreal = highRoofArealCalc();
        } else {
            roofAreal = calcFlatRoofAreal();
        }
        return roofAreal;
    }

    public double calcFlatRoofAreal() {
        return roof.getLength() * roof.getWidth();
    }

    public double highRoofArealCalc() {
        return (roof.getLength() * roof.getRoofHeight() * 2);
    }

 }
