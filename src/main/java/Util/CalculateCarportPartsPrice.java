package Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;

/**
 * Class for calculating the price of a carport-skeleton.
 * Materials in a carport-skeleton is defined in carportParts and calculated by the CalcCarportMaterials
 * @Author Josef, Hallur, Thor og Frederik
 */
public class CalculateCarportPartsPrice {
    private CarportParts carportParts;

    /**
     * Constructor for CalculateCarportPartsPrice
     * @param carportParts -> Makes sure that we're working on a object of the type carportParts - defined as a class variabel.
     *             All calls for width and height etc comes from the carportParts class's getters.
     */
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

}
