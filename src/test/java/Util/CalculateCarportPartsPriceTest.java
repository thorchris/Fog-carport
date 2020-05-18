package Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the CalcCarportMaterials class
 */
public class CalculateCarportPartsPriceTest {

    private double length, width;
    private int sidesWithCladding;
    private boolean hasAShed, isHalfWidth;

    double screwPrice, rafterPrice, postPrice, strapPrice;

    CarportParts carportParts;
    CarportMaterials carportMaterials;
    CalcCarportMaterials calcCarportMaterials;
    CalculateCarportPartsPrice calculateCarportPartPrice;

    /**
     *@Before notation makes sure that this method is run pre every test.
     *        Sets every local variabel equal null to assure the test starts fresh.
     *        Then instantiates the variabels to be equal to our test value
     */
    @Before
    public void setup() {
        carportMaterials = null;
        carportParts = null;
        calcCarportMaterials = null;
        calculateCarportPartPrice = null;

        // Test data
        length = 3;
        width = 3;
        sidesWithCladding = 0;
        hasAShed = true;
        isHalfWidth = false;

        // Samme priser som fra DB
        screwPrice = 1;
        rafterPrice = 14;
        postPrice = 50;
        strapPrice = 20;

        // adding data
        carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);
        calcCarportMaterials = new CalcCarportMaterials(carportParts);
        calculateCarportPartPrice = new CalculateCarportPartsPrice(carportParts);
    }


    /**
     * Test method to test if the price calculation works for the carportParts.
     * Result is from the method call
     * Expected is the expected answer calculated
     */
    @Test
    public void carportPartsPrice() {
        double testScrews = carportParts.getTotalScrews() * screwPrice;
        double testRafters = carportParts.getTotalRafters() * rafterPrice;
        double testPosts = carportParts.getTotalPosts() * postPrice;
        double testStraps = carportParts.getStrapLength() * strapPrice;
        double testMaterial = carportParts.getCarportCladding() * carportMaterials.getMaterialPriceM();

        double expected = testScrews + testRafters + testPosts + testMaterial + testStraps;
        double result = calculateCarportPartPrice.calculateCarportPartPrice(screwPrice, rafterPrice, postPrice, strapPrice,carportMaterials);
        System.out.println(expected);
        assertEquals(expected, result, 0);

    }


}
