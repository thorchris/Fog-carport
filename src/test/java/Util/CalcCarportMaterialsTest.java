package Util;


import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalcCarportMaterialsTest {

    private double length, width;
    private int sidesWithCladding;
    private boolean hasAShed, isHalfWidth;

    CarportParts carportParts;
    CarportMaterials carportMaterials;
    CalcCarportMaterials calcCarportMaterials;


    /**
     *@Before notation makes sure that this method is run pre every test.
     *        Sets every local variabel equal null to assure the test starts fresh.
     *        Then instantiates the variabels to be equal to our test value
     */
    @Before
    public void setup() {
        carportParts = null;
        carportMaterials = null;
        calcCarportMaterials = null;

        // Test data
        length = 3;
        width = 3;
        sidesWithCladding = 3;
        hasAShed = true;
        isHalfWidth = true;

        // adding data
        carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);
        calcCarportMaterials = new CalcCarportMaterials(carportParts);
    }

    /**
     * Test to see if the amountOfPosts method works as expected
     */
    @Test
    public void amountOfPostsTest() {
        double expected = carportParts.getTotalPosts();
        double result = calcCarportMaterials.calculateAmountOfPosts();
        assertEquals(expected,result, 0);
    }

    /**
     * Test to see if the amountOfRafters method works as expected
     */
    @Test
    public void amountOfRaftersTest(){
        double expected = carportParts.getTotalRafters();
        double result = calcCarportMaterials.calculateRafters();
        assertEquals(expected,result,0);

    }

    /**
     * Test to see if the carportCladding method works as expected
     */
    @Test
    public void carportCladdingTest(){
        double expected = carportParts.getCarportCladding();
        double result = calcCarportMaterials.calculateCarportCladding();

        assertEquals(expected,result,0);
    }

    /**
     * Test to see if the calcStrapLength method works as expected
     */
    @Test
    public void calcStrapLengthTest(){
        double expected = carportParts.getStrapLength();
        double result = calcCarportMaterials.calcStrapLength();

        assertEquals(expected,result,0);
    }


}
