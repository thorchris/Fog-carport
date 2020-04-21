package Util;

import FunctionLayer.RoofMaterials;

public class CalculateRoof {

    public double flatRoof(double length, double width, double screwPrice, double fasciaPrice, double rafterPrice, double bracketPrice, RoofMaterials roofmaterial) {
        double totalPrice = 0;
        width += 0.15;
        length += 0.15;
        double amountOfRafter = length/1;
        double amountOfBrackets = amountOfRafter * 2;
        double amountOfScrews = (amountOfBrackets * 4) + (amountOfRafter * 5);

        //Roof size
        double roofLength = roofmaterial.getLength();
        double roofWidth = roofmaterial.getWidth();
        double totalRoofAreal = (roofLength / length) + (roofWidth / width);

        double roofmaterialPriceM2 = roofmaterial.getmaterialPriceM2();

        double totalRoofPrice = totalRoofAreal * roofmaterialPriceM2;

        //Stern pris:
        int fascia = 2;
        double totalFasciaPrice = ((width * fasciaPrice)*fascia) + ((length * fasciaPrice)*fascia);

        //Spær pris:
        double totalRafterPrice = amountOfRafter * (width * rafterPrice);

        //Beslag pris:
        double totalBracketPrice = amountOfBrackets * bracketPrice;

        //Skruer pris:
        double totalScrewPrice = amountOfScrews * screwPrice;

        totalPrice = totalRoofPrice + totalFasciaPrice + totalRafterPrice + totalScrewPrice + totalBracketPrice;

        return totalPrice;
    }

    public double highRoof(int angle, double length, double width, double screwPrice, double fasciaPrice, double rafterPrice, double bracketPrice, RoofMaterials roofmaterial) {
        double totalPrice = 0;
        width += 0.15;
        length += 0.15;
        double amountOfRafter = length/1;
        double amountOfBrackets = amountOfRafter * 2;
        double amountOfScrews = (amountOfBrackets * 4) + (amountOfRafter * 5);

        //Stern pris:
        int fascia = 2;
        double totalFasciaPrice = ((width * fasciaPrice)*fascia) + ((length * fasciaPrice)*fascia);

        //Spær pris:
        double totalRafterPrice = amountOfRafter * (width * rafterPrice);

        //Beslag pris:
        double totalBracketPrice = amountOfBrackets * bracketPrice;

        //Skruer pris:
        double totalScrewPrice = amountOfScrews * screwPrice;

        double highRafterPrice = 0;
        double roofHeight = 0;
        double roofAreal;
        double roofMaterialPrice = 0;

        double roofMaterialPricePrm2 = roofmaterial.getmaterialPriceM2();

        //Tag areal udregning : https://www.bolius.dk/hvor-stort-er-mit-tag-89636

        switch (angle) {
            case 15:
                highRafterPrice = amountOfRafter * ((width * 0.5)  * rafterPrice);
                roofHeight = 0.5;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 20:
                highRafterPrice = amountOfRafter * ((width * 0.55)  * rafterPrice);
                roofHeight = 0.55;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 25:
                highRafterPrice = amountOfRafter * ((width * 0.6)  * rafterPrice);
                roofHeight = 0.6;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 30:
                highRafterPrice = amountOfRafter * ((width * 0.65)  * rafterPrice);
                roofHeight = 0.65;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 35:
                highRafterPrice = amountOfRafter * ((width * 0.7)  * rafterPrice);
                roofHeight = 0.7;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 40:
                highRafterPrice = amountOfRafter * ((width * 0.75)  * rafterPrice);
                roofHeight = 0.75;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 45:
                highRafterPrice = amountOfRafter * ((width * 0.80)  * rafterPrice);
                roofHeight = 0.8;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 50:
                highRafterPrice = amountOfRafter * ((width * 0.85)  * rafterPrice);
                roofHeight = 0.85;
                roofAreal = length * roofHeight * 2;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
        }

        totalPrice = roofMaterialPrice + highRafterPrice + totalFasciaPrice + totalRafterPrice + totalScrewPrice + totalBracketPrice;

        return totalPrice;
    }

}
