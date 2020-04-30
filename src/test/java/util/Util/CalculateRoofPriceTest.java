package Util;

import FunctionLayer.Roof;
import FunctionLayer.RoofMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateRoofPriceTest {
    public CalculateRoofPrice calculateRoofPrice;
    public Roof roof;

    @Before
    public void setup(){
        //Making sure it's empty pre testing
        calculateRoofPrice = null;
        //Adding data
        RoofMaterials roofmaterial = new RoofMaterials("testMateriale", 1, 1, 10,15);
        boolean isHighRoof = true;
        double carportLength = 5;
        double carportWidth = 2.5;
        roof = new Roof(isHighRoof,roofmaterial,carportLength,carportWidth);
        roof.setRoofHeight(15);
        double roofAreal = new CalcRoofMaterials(roof).calcRoofAreal(roof);
        roof.setRoofAreal(roofAreal);
        calculateRoofPrice = new CalculateRoofPrice(roof);
    }

    @Test
    public void calcRoofPrice() {
        double screwPricePrPiece = 1;
        double fasciaPricePrPiece = 50;
        double rafterPricePrPiece = 15;
        double bracketPricePrPiece = 50;
        
        double expected = 1450;
        double result = calculateRoofPrice.calcRoofPrice(screwPricePrPiece, fasciaPricePrPiece, rafterPricePrPiece, bracketPricePrPiece);

        assertEquals(expected,result,0.1);
    }
}