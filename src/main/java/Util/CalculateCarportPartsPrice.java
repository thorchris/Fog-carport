package Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;

public class CalculateCarportPartsPrice {
    private CarportParts carportParts;

    public CalculateCarportPartsPrice(CarportParts carportParts) {
        this.carportParts = carportParts;
    }

    /**
     *
     * @param screwPrice is the price for each screw
     * @param rafterPrice is the price for every meter of rafter
     * @param postPrice is the price per post
     * @param strapPrice is the price for every meter of strap
     * @param carportMaterials
     * @return the total price for all the materials needed for a carport
     * the method get's it's values from the class carportParts, which we get through the constructor
     */

    public double calculateCarportPartPrice(double screwPrice, double rafterPrice, double postPrice, double strapPrice, CarportMaterials carportMaterials){
        double totalScrewPrice = carportParts.getTotalScrews() * screwPrice;
        double totalRafterPrice = carportParts.getTotalRafters() * rafterPrice;
        double totalPostPrice = carportParts.getTotalPosts() * postPrice;
        double totalCladdingPrice = carportParts.getCarportCladding() * carportMaterials.getMaterialPriceM();
        double totalStrapsPrice = carportParts.getStrapLength() *strapPrice;
        double totalPrice = totalScrewPrice + totalRafterPrice + totalPostPrice + totalCladdingPrice + totalStrapsPrice;
        return totalPrice;
    }

    @Override
    public String toString() {
        return "CalculateCarportPartsPrice{" +
                "carportParts=" + carportParts +
                '}';
    }
}
