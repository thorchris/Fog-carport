package Util;

import FunctionLayer.LogicFacade;
import FunctionLayer.Product;

import java.util.ArrayList;
import java.util.List;

public class CalculateCarport {
    double price;


    public double calculateCarportPrice(double length, double width, double postPrice, double skrewPrice, double strapPrice,boolean hasShed, boolean isHalfWidth){
        CalculateMaterials cm = new CalculateMaterials();

        int totalStraps = cm.calculateStraps(width);
        int totalPosts = cm.calculateAmountOfPosts(hasShed, isHalfWidth,length, width);
        int totalScrews = cm.calculateScrews(totalPosts);


        price = (totalPosts * postPrice) + (totalScrews * skrewPrice) + (totalStraps * strapPrice);

        return price;
    }

    public double getPrice() {
        return price;
    }
}
