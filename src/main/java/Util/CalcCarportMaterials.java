package Util;

import FunctionLayer.CarportParts;

import java.util.InputMismatchException;

/**
 * Class used to calculate materials needed in a carport-skeleton.
 * Has one class variabels carportParts this is used for calculations throughout.
 * @Author Josef, Hallur, Thor og Frederik
 */

public class CalcCarportMaterials {
    private CarportParts carportParts;

    /**
     * Constructor for CalcCarportMaterials
     * @param carportParts -> Makes sure that we're working on a object of the type carportParts - defined as a class variabel.
     *             All calls for width and height etc comes from the carportParts class's getters.
     */
    public CalcCarportMaterials(CarportParts carportParts) {
        this.carportParts = carportParts;
    }

    /**
     * By using the length and width of the carport we calculate the needed amountOF posts.
     * @return the amounts of post needed for the carport-skeleton
     */
    public int calculateAmountOfPosts() {
        double length = carportParts.getLength();
        double width = carportParts.getWidth();
        int lengthPosts = 0;
        int widthPosts = 0;

        //Starts with the value 4, since this is the minimum of posts in a carport.
        if (length < 4) {
            lengthPosts = 4;
        }
        if (length > 4) {
            lengthPosts = 6;
        }
        if (width <= 6) {
            widthPosts = 2;
        }
        int totalPosts = lengthPosts + widthPosts;
        // If customers want a shed
        if (carportParts.isHasAShed()) {
            if (carportParts.isHalfWidth()) {
                totalPosts += 3;
            } else {
                totalPosts += 4;
            }
        }

        return totalPosts;
    }

    /**
     * Using the carport-skeletons width it calculates the amount of rafter needed for a carport-skeleton
     * @return the amount of rafter for the carport-skeleton
     */
    //Spær rafters
    public int calculateRafters() {
        double width = carportParts.getWidth();
        int amountOfRafters = 0;
        if (width < 0) {
            throw new InputMismatchException("Only positive numbers");
        }
        double rafters = (int) ((width * 2));
        if (rafters % width != 0) {
            rafters++;
        }
        amountOfRafters = (int) rafters;

        return amountOfRafters;
    }

    /**
     * Using the carport width and length and the width of the material used for the carport the amount of cladding needed is calculated
     * @return carportCladding needed for the carport-skeleton
     */
    public double calculateCarportCladding() {
        //Beklædning (antal træ)
        double amountOfCladding = 0;
        double length = carportParts.getLength();
        double width = carportParts.getWidth();
        double woodWidth = carportParts.getCarportMaterials().getWidth();

        switch (carportParts.getSidesWithCladding()) {
            //En langside
            case 1:
                amountOfCladding = (length / woodWidth);
                break;
            //To langside
            case 2:
                amountOfCladding = ((length / woodWidth) * 2);
                break;
            //En langside og bagsiden
            case 3:
                amountOfCladding = (((length / woodWidth)) + (width / woodWidth));
                break;
            //Begge langsider og bagsiden
            case 4:
                amountOfCladding = ((2 * (length / woodWidth)) + (width / woodWidth));
                break;
        }
        return amountOfCladding;
    }

    /**
     * Amount of straps is a fixed variabel.
     *      If the carport has a shed it is 6
     *      If the carport does not have a shed it is 4
     * @return amount of straps
     */
    public int amountOfStraps() {
        if (carportParts.isHasAShed()) {
            return 6;
        }
        return 4;
    }

    /**
     * Calculate straplength using the carport-skeletons width and length
     * @return the length of the straps
     */
    public double calcStrapLength() {
        return (2 * carportParts.getWidth()) + (2 * carportParts.getLength());
    }
}
