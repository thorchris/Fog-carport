package SVGTest;

import FunctionLayer.*;
import Util.CalcCarportMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SvgTest {

    // CarportParts
    private double length;
    private double width;
    private int sidesWithCladding;
    private boolean hasAShed;
    private boolean isHalfWidth;

    // Roof
    private boolean isHighRoof;

    private int intCarportHeight;
    private int intCarportWidth;


    Svg svg;
    CarportMaterials carportMaterials;
    CarportParts carportParts;
    RoofMaterials roofMaterials;
    Roof roof;
    ShedMaterials shedMaterials;
    Shed shed;
    FullCarport fullCarport;

    @Before
    public void setUp() throws Exception {
        svg = new Svg(800, 600, "0,0,800,600", 0, 0);

        // Test data CarportParts
        length = 2.4;
        width = 2.4;
        sidesWithCladding = 1;
        hasAShed = true;
        isHalfWidth = true;

        //Test data Roof
        isHighRoof = false;


        // adding data
        carportMaterials = new CarportMaterials("testMateriale", 1, 14, 0.15, 3);
        carportParts = new CarportParts(length, width, hasAShed, isHalfWidth, carportMaterials, sidesWithCladding);
        roofMaterials = new RoofMaterials("Tagplader Plastmo blåtonet", 1, 250, 1.06, 2.4);
        roof = new Roof(isHighRoof, roofMaterials, length, width);
        shedMaterials = new ShedMaterials();
        shed = new Shed(length, width, isHalfWidth, shedMaterials);


        fullCarport = new FullCarport(carportParts, roof, shed);

        // Aspect Ratio for the addPosts test
        if(width < 5){
            intCarportHeight = (int) (length*120);
            intCarportWidth = (int) (width*120);
        }else{
            intCarportHeight = (int) (length*100);
            intCarportWidth = (int) (width*100);
        }


    }

    @Test
    public void addRect01() {
        svg.addRect(0, 0, 100, 100);
        String expectedRect = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\"><rect x=\"0\" y=\"0\" height=\"100\" width=\"100\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";
        assertEquals(svg.toString(), expectedRect);
    }

    @Test
    public void addRect02() {
        svg.addRect(0, 0, 99, 99);
        String expectedRect = "<rect x=\"0\" y=\"0\" height=\"99\" width=\"99\" style=\"stroke:#000000; fill: #ffffff\" />";
        assertThat(svg.toString(), containsString(expectedRect));
    }


    /**
     * The FullCarport made for this tests has a shed and the shed is half width therefor
     * the amount of posts for the carport will be 6. Added the CalcCarportMats to assertEquals for extra test assurance.
     *
     */
    @Test
    public void addPosts() {
        svg.addPosts(fullCarport, intCarportWidth, intCarportHeight);

        CalcCarportMaterials CalcCarportMats = new CalcCarportMaterials(carportParts);
        int postsAmount = CalcCarportMats.calculateAmountOfPosts();


        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">";
        String post1 = "<rect x=\"0\" y=\"20\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post2 = "<rect x=\"134\" y=\"20\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post3 = "<rect x=\"278\" y=\"20\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post4 = "<rect x=\"0\" y=\"299\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post5 = "<rect x=\"134\" y=\"299\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post6 = "<rect x=\"278\" y=\"299\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";

        String expectedRect = headerTemplate + post1 + post2 + post3 + post4 + post5 + post6;


        assertEquals(postsAmount, fullCarport.getCarportParts().getTotalPosts());
        assertThat(svg.toString(), containsString(expectedRect));
    }





}