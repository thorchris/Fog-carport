package Util;

import FunctionLayer.Shed;
import FunctionLayer.ShedMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateShedPriceTest {
    private CalculateShedPrice calculateShedPrice;
    private Shed shed;
    double carportLength;
    double carportWidth;
    boolean isHalftWidth;
    ShedMaterials shedMaterials;


    //double carportLength, double carportWidth,boolean isHalfWidth, ShedMaterials shedMaterials
    @Before
    public void setup(){
        carportLength = 7.4;
        carportWidth = 3.4;
        isHalftWidth = true;
        isHalftWidth = true;
        //shed = new Shed(carportLength, carportWidth, isHalftWidth);
        //calculateShedPrice = new CalculateShedPrice(shed);
    }


    @Test
    public void calcShedPrice() {
        double strapsPrice = 10;
        double doorKnobPrice = 50;
        double doorHingePrice = 150;
        //calculateShedPrice.calcShedPrice();


    }
}