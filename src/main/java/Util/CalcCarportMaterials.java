package Util;

import FunctionLayer.CarportParts;

import java.util.InputMismatchException;

public class CalcCarportMaterials {
    private CarportParts carportParts;

    public CalcCarportMaterials(CarportParts carportParts) {
        this.carportParts = carportParts;
    }

    //Stolper
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
                amountOfCladding =((length / woodWidth) * 2);
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

}
