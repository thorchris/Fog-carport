package util;

import Util.CalculateMaterials;
import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

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

    @Test(expected = InputMismatchException.class)   //negative test -> expected exception
    public void getAmountOfRaftersNegative() {
        cm.calculateRafters(-2.0);
    }

    @Test
    public void calculateAmountOfPostsAllPositive() {
        boolean hasShed = true;
        boolean isHalfWidth = true;
        double length = 7.40;
        double width = 3.40;

        int result = cm.calculateAmountOfPosts(hasShed, isHalfWidth, length, width);
        // Length post = 6, width post = 2, shed post = 3
        int expected = 11;

        assertEquals(result, expected);
    }

    @Test
    public void calculateAmountOfPostsPosNegMix() {
        boolean hasShed = true;
        boolean isHalfWidth = false;
        double length = 7.40;
        double width = 3.40;

        int result = cm.calculateAmountOfPosts(hasShed, isHalfWidth, length, width);
        // Length post = 6, width post = 2, shed post = 4
        int expected = 12;

        assertEquals(result, expected);
    }

    @Test
    public void calculateAmountOfPostsPosNegSmallLength() {
        boolean hasShed = true;
        boolean isHalfWidth = false;
        double length = 3.20;
        double width = 3.40;
        int result = cm.calculateAmountOfPosts(hasShed, isHalfWidth, length, width);
        // Length post = 4, width post = 2, shed post = 4
        int expected = 10;

        assertEquals(result, expected);
    }

    @Test
    public void calculateAmountOfPostFalseBool() {
        boolean hasShed = false;
        boolean isHalfWidth = false;
        double length = 7.40;
        double width = 3.40;

        int result = cm.calculateAmountOfPosts(hasShed, isHalfWidth, length, width);
        // Length post = 6, width post = 2
        int expected = 8;

        assertEquals(result, expected);
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