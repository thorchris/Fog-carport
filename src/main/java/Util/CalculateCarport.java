package Util;

public class CalculateCarport {
    double price;
    double length = 2.4;
    double width = 3.5;
    double postsPrice =  29;
    double skrewPrice =  20;
    double strapPrice =  20;

    public double calculateCarportPrice(double length, double width, double postPrice, double skrewPrice, double strapPrice){

        double lengthPosts = 0;
        double widthPosts = 0;
        double totalStraps = 0;
        double totalPosts;
        double totalScrews;


        totalStraps = width * 2;

        if(length > 4) {
            lengthPosts += 4 + (length / 2);
        }

        if(width > 4) {
            widthPosts += 4 + (width / 2);
        }

        totalPosts = lengthPosts + widthPosts;
        totalScrews = 4 * totalPosts;

        //Altid 4 frame
        int frame = 4;
        double framePricePrM = 25;
        double framePrice = (length * framePricePrM) + (width * framePricePrM)* frame;

        price = (totalPosts * postsPrice) + (totalScrews * skrewPrice) + (totalStraps * strapPrice) + framePrice;

        return price;

    }

    public double getPrice() {
        return price;
    }
}
