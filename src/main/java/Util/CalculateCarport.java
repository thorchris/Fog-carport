package Util;

public class CalculateCarport {
    double price;
    double length = 2.4;
    double width = 3.5;
    double materialPrice = 2000;
    double postsPrice =  50;
    double skrewPrice =  20;
    double strapPrice =  20;

    public double calculateCarportPrice(double length, double width, double materialPrice, double postsPrice, double skrewPrice, double strapPrice){

        double lengthPosts = 0;
        double widthPosts = 0;
        double totalStraps = 0;
        double totalPosts;
        double totalScrews;

        double lengthWidthPrice = (length + width) * materialPrice;

        totalStraps = width * 2;

        if(length > 4) {
            lengthPosts += 4 + (length / 2);
        }

        if(width > 4) {
            widthPosts += 4 + (width / 2);
        }

        totalPosts = lengthPosts + widthPosts;
        totalScrews = 4 * totalPosts;

        price = lengthWidthPrice + (totalPosts * postsPrice) + (totalScrews * skrewPrice) + (totalStraps * strapPrice);

        return price;

    }

    public double getPrice() {
        return price;
    }
}
