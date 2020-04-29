package test;

import Util.CalculateMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateMaterialsTest {
    private CalculateMaterials cm;

    @Before
    public void setup() {
        cm = new CalculateMaterials();
    }

    @Test //positive test with input requiring the method to use the % operator.
    public void getAmountOfRaftersPositiveModulus() {
        int result = cm.calculateRafters(2.4);
        int expected = 5;

        assertEquals(expected, result);
    }

    @Test //positive test with simple input
    public void getAmountOfRaftersPositiveSimple() {
        int result = cm.calculateRafters(2);
        int expected = 4;

        assertEquals(expected, result);
    }

    @Test
    public void calculateAmountOfPosts() {
    }

    @Test
    public void calculateScrews() {
    }

    @Test
    public void calculateCladdingCarport() {
    }

    @Test
    public void calculateShedCladding() {
    }

    @Test
    public void calculateStraps() {
    }
}