package util.Util;

import FunctionLayer.CarportMaterials;
import FunctionLayer.CarportParts;
import FunctionLayer.Shed;
import FunctionLayer.ShedMaterials;
import Util.CalcCarportMaterials;
import Util.CalcShedMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcShedMaterialsTest {
    double carportLength = 0;
    double carportWidth = 0;
    boolean isHalfWidth = false;
    ShedMaterials shedMaterials = null;

    @Before
    public void setup() {
        double carportLength = 0;
        double carportWidth = 0;
        boolean isHalfWidth = false;
        ShedMaterials shedMaterials = null;
        Shed shed = null;

    }

    @Test
    public void calculateShedCladdingTest1(){
        carportLength = 2.4;
        carportWidth = 2.4;
        isHalfWidth = false;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = 23;
        double result = csm.calculateShedCladding();

        assertEquals(expected, result, 1);
    }

    @Test
    public void calculateShedCladdingTest2(){
        carportLength = 7.2;
        carportWidth = 6.8;
        isHalfWidth = true;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = 44;
        double result = csm.calculateShedCladding();

        assertEquals(expected, result, 1);
    }

    @Test
    public void calculateStrapsHalfWidth() {
        carportLength = 7.2;
        carportWidth = 6.8;
        isHalfWidth = true;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = 3.4;
        double result = csm.calculateStrapsLength();

        assertEquals(expected, result, 1);
    }

    @Test
    public void calculateStrapsFullWidth() {
        carportLength = 7.2;
        carportWidth = 6.8;
        isHalfWidth = false;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = 6.8;
        double result = csm.calculateStrapsLength();

        assertEquals(expected, result, 1);
    }

    }
