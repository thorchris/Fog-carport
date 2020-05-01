package Util;

import FunctionLayer.Roof;
import java.util.InputMismatchException;


/**
 * Class used to calculate materials needed in a roof.
 * Has two class variabels roofAreal and roof, those are used for calculations throughout.
 */
public class CalcRoofMaterials {

    private Roof roof;
    private double roofAreal;

    /**
     * Constructor for CalcRoofMaterials
     * @param roof -> Makes sure that we're working on a object of the type roof - defined as a class variabel.
     *             All calls for width and height etc comes from the roof class's getters.
     * The constructor sets the areal for the roof given as parameter as well. T
     */
    public CalcRoofMaterials(Roof roof) {
        this.roof = roof;
        roofAreal = calcRoofAreal(this.roof);
        this.roof.setRoofAreal(roofAreal);
    }

    /**
     * By using the length of the roof we calculate the amount of rafters.
     * Throws exception if width variabel < 0.
     * Rafters are calculated by 2 rafters pr meter roof-length.
     * @return amount of rafters needed for given roof
     */
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

    /**
     * Takes the amount of rafter calculated in the method before and multiplies it by 2.
     *          Since you need 2 brackets pr rafter.
     * @return
     */
    public int amountOfBrackets() {
        return amountOfRafter() * 2;
    }

    /**
     * Calls two assistant methods in an if statement, for calculating the areal of either highRoof or a flat roof.
     * @param roof, takes parameter roof so that it can be called later on with different variabels.
     * @return roofAreal
     */
    public double calcRoofAreal(Roof roof) {
        if (roof.isHighRoof()) {
            roofAreal = highRoofArealCalc();
        } else if(!roof.isHighRoof()) {
            roofAreal = calcFlatRoofAreal();
        }
        return roofAreal;
    }

    /**
     * Formula for calculating areal of a flatroof
     * @return areal of flat roof.
     */
    public double calcFlatRoofAreal() {
        return roof.getLength() * roof.getWidth();
    }

    /**
     * Formula for calculating areal of a high roof
     * @return areal of high roof.
     */
    public double highRoofArealCalc() {
        return ((roof.getLength() * roof.getWidth() * 2));
    }

 }
