package Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;

public class CalculateCarportPartsPrice {
    private CarportParts carportParts;

    public CalculateCarportPartsPrice(CarportParts carportParts) {
        this.carportParts = carportParts;
    }

    public double calculateCarportPartPrice(double screwPrice, double rafterPrice, double postPrice, CarportMaterials carportMaterials){
        double totalScrewPrice = carportParts.getTotalScrews() * screwPrice;
        double totalRafterPrice = carportParts.getTotalRafters() * rafterPrice;
        double totalPostPrice = carportParts.getTotalPosts() * postPrice;
        double totalCladdingPrice = carportParts.getCarportCladding() * carportMaterials.getMaterialPriceM();
        double totalPrice = totalScrewPrice + totalRafterPrice + totalPostPrice + totalCladdingPrice;
        return totalPrice;
    }

    @Override
    public String toString() {
        return "CalculateCarportPartsPrice{" +
                "carportParts=" + carportParts +
                '}';
    }
}
