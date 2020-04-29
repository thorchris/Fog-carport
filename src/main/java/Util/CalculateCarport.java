package Util;

public class CalculateCarport {
    double price;


    public double calculateCarportPrice(double length, double width, double postPrice, double skrewPrice, double rafterPrice,boolean hasShed, boolean isHalfWidth){
        CalculateMaterials cm = new CalculateMaterials();

        int totalRafters = cm.calculateRafters(width);
        int totalPosts = cm.calculateAmountOfPosts(hasShed, isHalfWidth,length, width);
        int totalScrews = cm.calculateScrews();


        price = (totalPosts * postPrice) + (totalScrews * skrewPrice) + (totalRafters * rafterPrice);

        return price;
    }

    public double getPrice() {
        return price;
    }
}
