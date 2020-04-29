package Util;

import FunctionLayer.RoofMaterials;

public class CalculateRoof {
    public CalculateMaterials cm = new CalculateMaterials();
    private double roofHeight;
    private double roofWidth;
    private double roofLength;

    public double flatRoof(double length, double width, double screwPrice, double fasciaPrice, double rafterPrice, double bracketPrice, RoofMaterials roofmaterial) {
        double totalPrice = 0;


        double amountOfRafter = cm.getAmountOfRafters();
        double amountOfBrackets = cm.calculateBrackets(amountOfRafter);
        double amountOfScrews = cm.calculateScrews();


        //Roof size
        roofWidth = width + 0.15;
        roofLength = length + 0.15;

        double totalRoofAreal = calcFlatRoofAreal(roofLength, length, roofWidth, width);

        double roofmaterialPriceM2 = roofmaterial.getmaterialPriceM2();

        double totalRoofPrice = totalRoofAreal * roofmaterialPriceM2;

        //Stern pris:
        int fascia = 4;
        double totalFasciaPrice = ((width * fasciaPrice)*fascia) + ((length * fasciaPrice)*fascia);


        //Spær pris:
        double totalRafterPrice = amountOfRafter * (width * rafterPrice);

        //Beslag pris:
        double totalBracketPrice = amountOfBrackets * bracketPrice;

        //Skruer pris:
        double totalScrewPrice = amountOfScrews * screwPrice;

        CalculateMaterials.itemList.put("Antal beslag til taget: ", amountOfBrackets);
        CalculateMaterials.itemList.put("Antal skruer til taget: ", amountOfScrews);
        CalculateMaterials.itemList.put("Antal stern til taget: ", (double) fascia);
        CalculateMaterials.itemList.put("Antal"  + roofmaterial.getMaterialName()+ " m2 : ", totalRoofAreal);

        totalPrice = totalRoofPrice + totalFasciaPrice + totalRafterPrice + totalScrewPrice + totalBracketPrice;

        return totalPrice;
    }

    public double highRoof(int angle, double length, double width, double screwPrice, double fasciaPrice, double rafterPrice, double bracketPrice, RoofMaterials roofmaterial) {
        double totalPrice = 0;
        roofWidth = width + 0.15;
        roofLength = length + 0.15;
        double amountOfRafter =  cm.getAmountOfRafters();;
        double amountOfBrackets = cm.calculateBrackets(amountOfRafter);
        double amountOfScrews = cm.calculateScrews();

        //Stern pris:
        int fascia = 4;
        double totalFasciaPrice = ((width * fasciaPrice)*fascia) + ((length * fasciaPrice)*fascia);

        //Spær pris:
        double totalRafterPrice = amountOfRafter * (width * rafterPrice);

        //Beslag pris:
        double totalBracketPrice = amountOfBrackets * bracketPrice;

        //Skruer pris:
        double totalScrewPrice = amountOfScrews * screwPrice;

        double highRafterPrice = 0;
        double roofAreal = 0;
        double roofMaterialPrice = 0;

        double roofMaterialPricePrm2 = roofmaterial.getmaterialPriceM2();

        //Tag areal udregning : https://www.bolius.dk/hvor-stort-er-mit-tag-89636

        switch (angle) {
            case 15:
                highRafterPrice = amountOfRafter * ((width * 0.5)  * rafterPrice);
                roofHeight = 0.5;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 20:
                highRafterPrice = amountOfRafter * ((width * 0.55)  * rafterPrice);
                roofHeight = 0.55;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 25:
                highRafterPrice = amountOfRafter * ((width * 0.6)  * rafterPrice);
                roofHeight = 0.6;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 30:
                highRafterPrice = amountOfRafter * ((width * 0.65)  * rafterPrice);
                roofHeight = 0.65;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 35:
                highRafterPrice = amountOfRafter * ((width * 0.7)  * rafterPrice);
                roofHeight = 0.7;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 40:
                highRafterPrice = amountOfRafter * ((width * 0.75)  * rafterPrice);
                roofHeight = 0.75;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 45:
                highRafterPrice = amountOfRafter * ((width * 0.80)  * rafterPrice);
                roofHeight = 0.8;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
            case 50:
                highRafterPrice = amountOfRafter * ((width * 0.85)  * rafterPrice);
                roofHeight = 0.85;
                roofAreal = calcHighRoofAreal(length, roofHeight);;
                roofMaterialPrice = roofMaterialPricePrm2 * roofAreal;
                break;
        }

        CalculateMaterials.itemList.put("Antal beslag til taget: ", amountOfBrackets);
        CalculateMaterials.itemList.put("Antal skruer til taget: ", amountOfScrews);
        CalculateMaterials.itemList.put("Antal stern til taget: ", (double) fascia);
        CalculateMaterials.itemList.put("Antal " + roofmaterial.getMaterialName()+ " m2 : ", roofAreal);

        totalPrice = roofMaterialPrice + highRafterPrice + totalFasciaPrice + totalRafterPrice + totalScrewPrice + totalBracketPrice;

        return totalPrice;
    }
    public double calcHighRoofAreal(double length, double roofHeight){
        return length * roofHeight * 2;
    }

    public double calcFlatRoofAreal(double roofLength, double length, double roofWidth, double width){
        return (roofLength / length) + (roofWidth / width);
    }

    public double getRoofHeight(){
        return roofHeight; 
    }

    public double getRoofWidth() {
        return roofWidth;
    }

    public double getRoofLength() {
        return roofLength;
    }
}
