package Util;

public class CalculateMaterials {

    private int totalPosts = 0;
    private int amountOfStraps = 0;
    private int amountOfScrews = 0;
    private int amountOfCladding = 0;
    private double totalAmountOfCladding = 0;


    //Stolper
    public int calculateAmountOfPosts(boolean hasShed, boolean isHalfWidth, double length, double width) {


        int lengthPosts = 0;
        int widthPosts = 0;

        //starter med værdien 4 idet det er min antal stolper i en carport
        if (length < 4) {
            lengthPosts = 4;
        }
        if (length > 4) {
            lengthPosts = 6;
        }
        if (width <= 6) {
            widthPosts = 2;
        }

        totalPosts = lengthPosts + widthPosts;

        // Hvis kunden vælger et skur
        if (hasShed) {
            if (isHalfWidth) {
                totalPosts += 3;
            } else {
                totalPosts += 4;
            }
        }

        return totalPosts;
    }

    //Spær rafters
    public int calculateStraps(double width) {
        amountOfStraps = (int) (width * 2);
        return amountOfStraps;
    }

    //Skruer
    public int calculateScrews(int totalPosts) {
        amountOfScrews = 4 * totalPosts;
        return amountOfScrews;
    }

    //Beklædning (antal træ)
    public int calculateCladdingCarport(int amountOfSides, double length, double width, double woodWidth) {

        switch (amountOfSides) {
            //En langside
            case 1:
                amountOfCladding = (int) (length / woodWidth);
                break;
            //To langside
            case 2:
                amountOfCladding = (int) ((length / woodWidth) * 2);
                break;
            //En langside og bagsiden
            case 3:
                amountOfCladding = (int) (((length / woodWidth)) + (width / woodWidth));
                break;
            //Begge langsider og bagsiden
            case 4:
                amountOfCladding = (int) ((2 * (length / woodWidth)) + (width / woodWidth));
                break;
        }
        return amountOfCladding;
    }

    public double calculateShedCladding(boolean isHalfWidth, double woodWidth, double carportWidth, double carportLength) {

        double shedWidth = 0;
        double amountOfCladdingWidth = 0;
        double amountOfCladdingLength = 0;
        double shedLength = 0;


        if (carportLength <= 3.6) {
            shedLength = 1;
        } else if (carportLength <= 5.1) {
            shedLength = 2;
        } else if (carportLength <= 7.8) {
            shedLength = 3;
        }

        if (isHalfWidth) {
            shedWidth = carportWidth / 2;
        } else {
            shedWidth = carportWidth;
        }

        amountOfCladdingLength = (shedLength / woodWidth);
        if (shedLength % woodWidth > 0) {
            amountOfCladdingLength++;
        }


        amountOfCladdingWidth = (shedWidth / woodWidth);
        if (shedWidth % woodWidth > 0) {
            amountOfCladdingWidth++; // If we need an extra to get 100% coverage.
        }


        totalAmountOfCladding = amountOfCladdingLength + amountOfCladdingWidth;

        return totalAmountOfCladding;
    }

    public static void main(String[] args) {
        CalculateMaterials cm = new CalculateMaterials();

        boolean test = true;
        double woodwidth = 0.15;
        double carportWidth = 7.2;
        double carportLength = 7.2;


        double pis = cm.calculateShedCladding(test, woodwidth, carportWidth, carportLength);

        System.out.println(pis);

    }


    //Remme til skur
    public int calculateStrapsShed(boolean isHalfWidth, double width) {

        //For hver meter er der 2 straps.
        amountOfStraps = (int) (width * 2);
        return amountOfStraps;
    }


    //Skruer til skur
    public int calculateScrewsShed(int totalPosts) {
        int amountOfScrews = 4 * totalPosts;
        return amountOfScrews;
    }


}
