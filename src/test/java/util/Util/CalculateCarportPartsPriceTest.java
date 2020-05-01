package util.Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;
import Util.CalcCarportMaterials;
import Util.CalculateCarportPartsPrice;
import org.junit.Before;
import org.junit.Test;

public class CalculateCarportPartsPriceTest {

    private double length, width;
    private int sidesWithCladding;
    private boolean hasAShed, isHalfWidth;

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
        isHalfWidth = true;

        // adding data
        // double materialPriceM, double width, double length, samme værdier som fra DB
        carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);
        calcCarportMaterials = new CalcCarportMaterials(carportParts);
        calculateCarportPartPrice = new CalculateCarportPartsPrice(carportParts);
    }


    @Test
    public void carportPartsPrice(){
        // skal lave integrations test. Skal hente pris fra DB 



    }



}
