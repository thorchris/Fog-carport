package util.Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;
import Util.CalcCarportMaterials;
import Util.CalculateCarportPartsPrice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateCarportPartsPriceTest {

    private double length, width;
    private int sidesWithCladding;
    private boolean hasAShed, isHalfWidth;

    double screwPrice, rafterPrice, postPrice, strapPrice;

    CarportParts carportParts;
    CarportMaterials carportMaterials;
    CalcCarportMaterials calcCarportMaterials;
    CalculateCarportPartsPrice calculateCarportPartPrice;


    @Before
    public void setup() {
        // Test data
        length = 3;
        width = 3;
        sidesWithCladding = 0;
        hasAShed = true;
        isHalfWidth = false;

        // Samme priser som fra DB
        screwPrice = 20;
        rafterPrice = 14;
        postPrice = 50;
        strapPrice = 20;

        // adding data
        // double materialPriceM, double width, double length, samme værdier som fra DB
        carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);
        calcCarportMaterials = new CalcCarportMaterials(carportParts);
        calculateCarportPartPrice = new CalculateCarportPartsPrice(carportParts);
    }


    @Test
    public void carportPartsPrice() {

        // evt hente priser i fremtiden fra DB
        double testScrews = carportParts.getTotalScrews() * screwPrice;
        double testRafters = carportParts.getTotalRafters() * rafterPrice;
        double testPosts = carportParts.getTotalPosts() * postPrice;
        double testStraps = carportParts.getStrapLength() * strapPrice;
        double testMaterial = carportParts.getCarportCladding() * carportMaterials.getMaterialPriceM();

        double expected = testScrews + testRafters + testPosts + testMaterial + testStraps;
        double result = calculateCarportPartPrice.calculateCarportPartPrice(screwPrice, rafterPrice, postPrice, strapPrice,carportMaterials);

        assertEquals(expected, result, 0);

    }


}
