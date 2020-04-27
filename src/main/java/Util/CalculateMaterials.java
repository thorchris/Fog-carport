package Util;

public class CalculateMaterials {
    //Stolper
    public int calculateAmountOfPosts(double length, double width){
        int lengthPosts = 0;
        int widthPosts = 0;
        //starter med værdien 4 idet det er min antal stolper i en carport
        int totalPosts = 0;

        if(length < 4){
            totalPosts = 4;
        }
        if(length > 4){
            lengthPosts += 4 + (length / 2);
        }
        if(width > 4) {
            widthPosts += 2 + (width / 2);
        }

        totalPosts = lengthPosts + widthPosts;

        return totalPosts;
    }

    //Remme
    public int calculateStraps(double width){
        //For hver meter er der 2 straps.
        int amountOfStraps = (int) (width * 2);
        return amountOfStraps;
    }

    //Skruer
    public int calculateScrews(int totalPosts){
        int amountOfScrews = 4 * totalPosts;
        return amountOfScrews;
    }

    //Beklædning
    public int calculateCladding(int amountOfSides,double length, double width, double woodWidth){
        int amountOfCladding = 0;

        switch (amountOfSides) {
            case 1:
                amountOfCladding = (int) (woodWidth / length);
                break;
            case 2:
                amountOfCladding = (int) ((woodWidth / length) * 2);
                break;
            case 3:
                amountOfCladding = (int) ((2 * (woodWidth / length)) + (woodWidth / width));
                break;
        }
        return amountOfCladding;
    }

}
