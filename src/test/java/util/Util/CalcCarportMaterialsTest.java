package util.Util;


import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;
import Util.CalcCarportMaterials;
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


    @Before
    public void setup() {
        // Test data
        length = 3;
        width = 3;
        sidesWithCladding = 3;
        hasAShed = true;
        isHalfWidth = true;

        // adding data
        // double materialPriceM, double width, double length, samme værdier som fra DB
        carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);
        calcCarportMaterials = new CalcCarportMaterials(carportParts);
    }

    @Test
    public void amountOfPosts() {

        double expected = carportParts.getTotalPosts();
        double result = calcCarportMaterials.calculateAmountOfPosts();
        assertEquals(expected,result, 0);
    }

    @Test
    public void amountOfRafters(){

        double expected = carportParts.getTotalRafters();
        double result = calcCarportMaterials.calculateRafters();
        assertEquals(expected,result,0);

    }

    @Test
    public void carportCladding(){

        double expected = carportParts.getCarportCladding();
        double result = calcCarportMaterials.calculateCarportCladding();

        assertEquals(expected,result,0);
    }





}
