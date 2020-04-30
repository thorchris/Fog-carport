package Util;

import FunctionLayer.Roof;

import java.util.InputMismatchException;

public class CalcRoofMaterials {

    private Roof roof;
    private double roofAreal;

    public CalcRoofMaterials(Roof roof) {
        this.roof = roof;
        roofAreal = calcRoofAreal(this.roof);
        this.roof.setRoofAreal(roofAreal);
    }

    //Spær / rafters
    public int amountOfRafter() {
        double width = roof.getLength();
        if (width < 0) {
            throw new InputMismatchException("Only positive numbers");
        }
        double rafters = (width * 2);
        if (rafters % width != 0) {
            rafters++;
        }
        int amountOfRafters = (int) rafters;

        return amountOfRafters;
    }
    //TODO: GENNEMGÅ OM DET ER NOK BRACKETS
    public int amountOfBrackets() {
        return amountOfRafter() * 2;
    }

    public double calcRoofAreal(Roof roof) {
        if (roof.isHighRoof()) {
            roofAreal = highRoofArealCalc();
        } else if(!roof.isHighRoof()) {
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
