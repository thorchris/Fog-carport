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

    //Beklædning (antal træ)
    public int calculateCladding(int amountOfSides,double length, double width, double woodWidth){
        int amountOfCladding = 0;

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
}
