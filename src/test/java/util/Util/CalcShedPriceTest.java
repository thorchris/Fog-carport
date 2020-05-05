package util.Util;

import FunctionLayer.Shed;
import FunctionLayer.ShedMaterials;
import Util.CalculateShedPrice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcShedPriceTest {
    private CalculateShedPrice calculateShedPrice;
    private Shed shed;
    private ShedMaterials shedMaterials;

    private double carportLength, carportWidth;
    private boolean isHalfWidth;

    double doorKnobPrice, doorHingesPrice, strapsPricePrM;

    /**
     *@Before notation makes sure that this method is run pre every test.
     *        Sets every local variabel equal null to assure the test starts fresh.
     *        Then instantiates the variabels to be equal to our test value
     */

    @Before
    public void setup() {
        shed = null;
        calculateShedPrice = null;
        shedMaterials = null;

        //test data
        carportLength = 5.0;
        carportWidth = 3.0;
        isHalfWidth = false;

        //priser fra DB
        doorKnobPrice = 100;
        doorHingesPrice = 55;
        strapsPricePrM = 20;

        shedMaterials = new ShedMaterials();
        shed = new Shed(carportLength, carportWidth, isHalfWidth, shedMaterials);
        calculateShedPrice = new CalculateShedPrice(shed);

    }

    /**
     * Test method to test if the price calculation works for the shed.
     * Result is from the method call
     * Expected is the expected answer calculated
     */

    @Test
    public void CalcShedPrice() {
        double testDoorKnob = shed.getDoorKnob() * doorKnobPrice;
        double testDoorHinges = shed.getDoorHinges() * doorHingesPrice;
        double testMaterial = shed.getTotalShedCladding() * shedMaterials.getPricePrM2();

        double expected = testDoorKnob+testDoorHinges+testMaterial;
        double result = calculateShedPrice.calcShedPrice(doorKnobPrice,doorHingesPrice);

        assertEquals(expected, result, 0);
    }
}
