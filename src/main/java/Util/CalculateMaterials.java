package Util;

import FunctionLayer.RoofMaterials;

import java.util.HashMap;
import java.util.InputMismatchException;

public class CalculateMaterials {

    private int totalPosts = 0;
    private int amountOfScrews = 0;
    private int amountOfRafters = 0;
    private int amountOfCladding = 0;
    private double TOTALSTRAPS = 4;
    private double totalAmountOfShedCladding = 0;
    public static HashMap<String, Double> itemList = new HashMap<>();

    public int getAmountOfRafters() {
        return amountOfRafters;
    }

    //Spær rafters
    public int calculateRafters(double width) {
        if (width < 0) {
            throw new InputMismatchException("Only positive numbers");
        }
        double rafters = (int) ((width * 2));
        if (rafters % width != 0) {
            rafters++;
        }
        amountOfRafters = (int) rafters;
        itemList.put("Antal spær", (double) amountOfRafters);

        return amountOfRafters;
    }

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
        itemList.put("Antal stolper", (double) totalPosts);

        return totalPosts;
    }


    //Skruer
    public int calculateScrews(int totalPosts) {
        //TODO ÆNDRE TIL 500 skruer????
        amountOfScrews = 4 * totalPosts;

        itemList.put("Antal skruer", (double) amountOfScrews);
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
        itemList.put("Antal brædder til beklædning på carport", (double) amountOfCladding);
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

        itemList.put("Antal brædder til beklædning på skur ", totalAmountOfShedCladding);
        totalAmountOfShedCladding = amountOfCladdingLength + amountOfCladdingWidth;

        return totalAmountOfShedCladding;
    }

    //Remme til skur
    //Rem strap, samme længde og bredde som carport
    // skal bruge 2 til længde og 2 til bredde
    public double calculateStraps(boolean hasAShed, boolean isHalfWidth, double width, double length) {
        double strapLengthShed = 0;
        if (hasAShed) {
            if (isHalfWidth) {
                strapLengthShed = width / 2;
                itemList.put("2 x Remme til skurets bredde på: ", strapLengthShed);
            } else {
                strapLengthShed = width;
                itemList.put("2 x Remme til skurets bredde på: ", strapLengthShed);
            }
        }
        itemList.put("2 x Remme til carportens længde på: ", length);
        itemList.put("2 x Remme til carportens bredde på: ", width);
        return strapLengthShed;
    }

    public static void main(String[] args) {
        //highRoof(int angle, double length, double width, double screwPrice, double fasciaPrice, double rafterPrice, double bracketPrice, RoofMaterials roofmaterial)
        CalculateRoof cr = new CalculateRoof();
        CalculateMaterials cm = new CalculateMaterials();

        boolean hasAShed = true;
        boolean isHalfWidth = true;
        double length = 3.20;
        double width = 2.80;
        int amountOfSides = 2;
        double woodWidth = 0.15;

        int angle = 15;
        double screwPrice = 20;
        double fasciaPrice = 20;
        double rafterPrice = 50;
        double bracketPrice = 60;
        RoofMaterials roofMaterials = new RoofMaterials("Blåtonet plast", 1, 20, 15, 15);

        int totalPosts = cm.calculateAmountOfPosts(hasAShed, isHalfWidth, length, width);
        cm.calculateRafters(width);
        cm.calculateScrews(totalPosts);
        cm.calculateCladdingCarport(amountOfSides, length, width, woodWidth);
        cm.calculateShedCladding(isHalfWidth, woodWidth, width, length);
        cm.calculateStraps(hasAShed, isHalfWidth, width, length);

        cr.highRoof(angle, length, width, screwPrice, fasciaPrice, rafterPrice, bracketPrice, roofMaterials);

        System.out.println(itemList);

    }

}
