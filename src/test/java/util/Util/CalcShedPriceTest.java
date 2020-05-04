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

    @Before
    public void setup() {

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


    @Test
    public void CalcShedPrice() {


        double testDoorKnob = shed.getDoorKnob() * doorKnobPrice;
        double testDoorHinges = shed.getDoorHinges() * doorHingesPrice;
        double testStraps = shed.getStrapLength() * strapsPricePrM;
        double testMaterial = shed.getTotalShedCladding() * shedMaterials.getPricePrM2();

        double expected = testDoorKnob+testDoorHinges+testStraps+testMaterial;
        double result = calculateShedPrice.calcShedPrice(strapsPricePrM,doorKnobPrice,doorHingesPrice);

        assertEquals(expected, result, 0);
    }
}
