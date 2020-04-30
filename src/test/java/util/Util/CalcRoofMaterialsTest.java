package Util;

import FunctionLayer.Roof;
import FunctionLayer.RoofMaterials;
import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class CalcRoofMaterialsTest {
    private Roof roof;
    boolean isHighRoof;
    RoofMaterials roofmaterial;
    double carportLength;
    double carportWidth;
    CalcRoofMaterials calcRoofMaterials;

    @Before
    public void setup(){
        //Making sure that it's cleared of data
        isHighRoof = false;
        roofmaterial = null;
        carportLength = 0;
        carportWidth = 0;
        roof = null;
        //adding data
        roofmaterial = new RoofMaterials("testMateriale", 1, 25, 10,15);

    }

    @Test
    public void amountOfRafter() {
        isHighRoof = true;
        carportLength = 5;
        carportWidth = 2.5;
        roof = new Roof(isHighRoof,roofmaterial,carportLength,carportWidth);
        calcRoofMaterials = new CalcRoofMaterials(roof);

        int expected = 10;
        int result = calcRoofMaterials.amountOfRafter();

        assertEquals(expected, result);
    }

    @Test
    public void amountOfBrackets() {
        isHighRoof = true;
        carportLength = 5;
        carportWidth = 2.5;
        roof = new Roof(isHighRoof,roofmaterial,carportLength,carportWidth);
        calcRoofMaterials = new CalcRoofMaterials(roof);

        int expected = 20;
        int result = calcRoofMaterials.amountOfBrackets();

        assertEquals(expected,result);
    }

    @Test
    public void calcFlatRoofAreal() {
        isHighRoof = false;
        carportLength = 5.0;
        carportWidth = 2.0;
        roof = new Roof(isHighRoof,roofmaterial,carportLength,carportWidth);
        calcRoofMaterials = new CalcRoofMaterials(roof);

        double expected = 10;
        double result = calcRoofMaterials.calcFlatRoofAreal();
        assertEquals(expected,result, 2); //TODO BEDRE DELTAVÆRDI?
    }

    @Test
    public void highRoofArealCalc() {
        isHighRoof = true;
        carportLength = 5;
        carportWidth = 2.0;
        roof = new Roof(isHighRoof,roofmaterial,carportLength,carportWidth);
        roof.setRoofHeight(15);
        calcRoofMaterials = new CalcRoofMaterials(roof);

        double expected = 5;
        double result = calcRoofMaterials.highRoofArealCalc();
        assertEquals(expected,result, 1); //TODO BEDRE DELTAVÆRDI?
    }


    @Test
    public void calcRoofArealDoesIfWork() {
        isHighRoof = true;
        carportLength = 5;
        carportWidth = 2.0;
        roof = new Roof(isHighRoof,roofmaterial,carportLength,carportWidth);
        roof.setRoofHeight(15);
        calcRoofMaterials = new CalcRoofMaterials(roof);

        double expected = 5;
        double result = calcRoofMaterials.highRoofArealCalc();
        assertEquals(expected,result, 1);

        isHighRoof = false;
        expected = 10;
        result = calcRoofMaterials.calcFlatRoofAreal();
        assertEquals(expected,result, 2);
    }



}