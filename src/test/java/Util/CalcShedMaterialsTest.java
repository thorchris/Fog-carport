package Util;

import FunctionLayer.Shed;
import FunctionLayer.ShedMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcShedMaterialsTest {
    double carportLength = 0;
    double carportWidth = 0;
    boolean isHalfWidth = false;
    ShedMaterials shedMaterials = null;


    /**
     *@Before notation makes sure that this method is run pre every test.
     *        Sets every local variabel equal null to assure the test starts fresh.
     *        We instantiates the variabels to be equal to our test value in the different test methods.
     */
    @Before
    public void setup() {
        double carportLength = 0;
        double carportWidth = 0;
        boolean isHalfWidth = false;
        ShedMaterials shedMaterials = null;
        Shed shed = null;

    }

    /**
     * Test to see if the calculateShedCladding method works with a shed half the size of the carport
     */
    @Test
    public void calculateShedCladdingTest1(){
        carportLength = 2.4;
        carportWidth = 2.4;
        isHalfWidth = false;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = shed.getTotalShedCladding();
        double result = csm.calculateShedCladding();

        assertEquals(expected, result, 1);
    }
    /**
     * Test to see if the calculateShedCladding method works with a shed the same size as the carport
     */
    @Test
    public void calculateShedCladdingTest2(){
        carportLength = 7.2;
        carportWidth = 6.8;
        isHalfWidth = true;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = shed.getTotalShedCladding();
        double result = csm.calculateShedCladding();

        assertEquals(expected, result, 1);
    }

    /**
     * Test to see if the calculateStrapsHalfWidth method works with a shed half the size of the carport
     */
    @Test
    public void calculateStrapsHalfWidth() {
        carportLength = 7.2;
        carportWidth = 6.8;
        isHalfWidth = true;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = shed.getStrapLength();
        double result = csm.calculateStrapsLength();

        assertEquals(expected, result, 0.1);
    }

    /**
     * Test to see if the calculateStrapsFullWidth method works with a shed the same size as the carport
     */
    @Test
    public void calculateStrapsFullWidth() {
        carportLength = 7.2;
        carportWidth = 6.8;
        isHalfWidth = false;
        shedMaterials = new ShedMaterials();

        Shed shed = new Shed(carportLength,carportWidth ,isHalfWidth, shedMaterials);
        CalcShedMaterials csm = new CalcShedMaterials(shed);

        double expected = shed.getStrapLength();
        double result = csm.calculateStrapsLength();

        assertEquals(expected, result, 0.1);
    }

    }
