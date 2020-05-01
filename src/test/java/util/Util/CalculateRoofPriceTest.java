package Util;

import FunctionLayer.Roof;
import FunctionLayer.RoofMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateRoofPriceTest {
    private CalculateRoofPrice calculateRoofPrice;
    private Roof roof;
    private RoofMaterials roofMaterial;

    /**
     *@Before notation makes sure that this method is run pre every test.
     *        Sets every local variabel equal null to assure the test starts fresh.
     *        Then instantiates the variabel roofMaterial to be equal to our test value
     */
    @Before
    public void setup(){
        //Making sure it's empty pre testing
        roof = null;
        calculateRoofPrice = null;
        roofMaterial = null;
        //Adding data
        roofMaterial = new RoofMaterials("testMateriale", 1, 10, 0.10,0.15);

    }

    @Test
    public void calcRoofPriceHighRoof() {
        boolean isHighRoof = true;
        double carportLength = 5;
        double carportWidth = 2.5;
        roof = new Roof(isHighRoof,roofMaterial,carportLength,carportWidth);
        roof.setRoofHeight(15);
        calculateRoofPrice = new CalculateRoofPrice(roof);
        double roofAreal = new CalcRoofMaterials(roof).calcRoofAreal(roof);
        roof.setRoofAreal(roofAreal);

        double screwPricePrPiece = 2;
        double fasciaPricePrPiece = 50;
        double rafterPricePrPiece = 20;
        double bracketPricePrPiece = 15;


        double expected = 1172;
        double result = calculateRoofPrice.calcRoofPrice(screwPricePrPiece, fasciaPricePrPiece, rafterPricePrPiece, bracketPricePrPiece);

        assertEquals(expected,result,2);
    }

    @Test
    public void calcRoofPriceLowRoof() {
        boolean isHighRoof = false;
        double carportLength = 5;
        double carportWidth = 2.5;
        roof = new Roof(isHighRoof,roofMaterial,carportLength,carportWidth);

        double roofAreal = new CalcRoofMaterials(roof).calcRoofAreal(roof);
        roof.setRoofAreal(roofAreal);
        calculateRoofPrice = new CalculateRoofPrice(roof);

        double screwPricePrPiece = 2;
        double fasciaPricePrPiece = 50;
        double rafterPricePrPiece = 20;
        double bracketPricePrPiece = 15;

        double expected = 1036;
        double result = calculateRoofPrice.calcRoofPrice(screwPricePrPiece, fasciaPricePrPiece, rafterPricePrPiece, bracketPricePrPiece);

        assertEquals(expected,result,1);
    }

    /**
     * Making sure that the method does not work without a roof input.
     * The setup method declares roof to be equal null and therefore we get a nullpointer. 
     */
    @Test(expected = NullPointerException.class)
    public void calcRoofPriceNullPointer() {
        double roofAreal = new CalcRoofMaterials(roof).calcRoofAreal(roof);
    }
}