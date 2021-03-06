package FunctionLayer;

import Util.CalcCarportMaterials;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
/**
 * Class for testing the SVG drawing.
 * All tests are "basicly" comparing two strings since SVG drawings are made based in HTML-style code.
 * @Author Josef, Hallur, Thor og Frederik
 */
public class SvgTest {

    // CarportParts
    private double length;
    private double width;
    private int sidesWithCladding;
    private boolean hasAShed;
    private boolean isHalfWidth;

    // Roof
    private boolean isHighRoof;

    private int intCarportLength;
    private int intCarportWidth;

    private Svg svg;
    private CarportMaterials carportMaterials;
    private CarportParts carportParts;
    private RoofMaterials roofMaterials;
    private Roof roof;
    private ShedMaterials shedMaterials;
    private Shed shed;
    private FullCarport fullCarport;
    private StringBuilder stringBuilder;

    /**
     * Run before each test to asure data is as expected.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        svg = new Svg(800, 600, "0,0,800,600", 0, 0);
        stringBuilder = new StringBuilder();

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

        // Aspect Ratio for the tests and converting to metric measurements as they are metric on the actual site.
        if (width < 5) {
            intCarportLength = (int) (length * 120);
            intCarportWidth = (int) (width * 120);
        } else {
            intCarportLength = (int) (length * 100);
            intCarportWidth = (int) (width * 100);
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
     */
    @Test
    public void addPosts() {
        svg.addPosts(fullCarport, intCarportWidth, intCarportLength);

        CalcCarportMaterials CalcCarportMats = new CalcCarportMaterials(carportParts);
        int postsAmount = CalcCarportMats.calculateAmountOfPosts();


        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">";
        String post1 = "<rect x=\"0\" y=\"20\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post2 = "<rect x=\"134\" y=\"20\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post3 = "<rect x=\"278\" y=\"20\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post4 = "<rect x=\"0\" y=\"299\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post5 = "<rect x=\"134\" y=\"299\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String post6 = "<rect x=\"278\" y=\"299\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";

        stringBuilder.append(String.format(headerTemplate, post1, post2, post3, post4, post5, post6));

        assertEquals(postsAmount, fullCarport.getCarportParts().getTotalPosts());
        assertThat(svg.toString(), containsString(stringBuilder.toString()));
    }

    @Test
    public void addStrap() {
        svg.addStraps(intCarportWidth, intCarportLength);

        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">";
        String strap1 = "<rect x=\"0\" y=\"83\" height=\"9\" width=\"288\" style=\"stroke:#000000; fill: #ffffff\" />";
        String strap2 = "<rect x=\"0\" y=\"227\" height=\"9\" width=\"288\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";

        stringBuilder.append(String.format(headerTemplate, strap1, strap2));

        assertThat(svg.toString(), containsString(stringBuilder.toString()));
    }

    /**
     * The FullCarport made for this tests has a width of 2.4 and length of 2.4 therefor
     * the amount of rafters for the carport will be 5. Added the CalcCarportMats to assertEquals for extra test assurance.
     */
    @Test
    public void addRafters() {
        svg.addRafters(fullCarport, intCarportWidth, intCarportLength);

        CalcCarportMaterials CalcCarportMats = new CalcCarportMaterials(carportParts);
        int rafterAmount = CalcCarportMats.calculateRafters();

        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">";
        String rafter1 = "<rect x=\"53\" y=\"20\" height=\"288\" width=\"4\" style=\"stroke:#000000; fill: #ffffff\" />";
        String rafter2 = "<rect x=\"106\" y=\"20\" height=\"288\" width=\"4\" style=\"stroke:#000000; fill: #ffffff\" />";
        String rafter3 = "<rect x=\"159\" y=\"20\" height=\"288\" width=\"4\" style=\"stroke:#000000; fill: #ffffff\" />";
        String rafter4 = "<rect x=\"212\" y=\"20\" height=\"288\" width=\"4\" style=\"stroke:#000000; fill: #ffffff\" />";
        String rafter5 = "<rect x=\"265\" y=\"20\" height=\"288\" width=\"4\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";

        stringBuilder.append(String.format(headerTemplate, rafter1, rafter2, rafter3, rafter4, rafter5));

        assertEquals(rafterAmount, fullCarport.getCarportParts().getTotalRafters(), 0);
        assertThat(svg.toString(), containsString(stringBuilder.toString()));

    }

    /**
     * The FullCarport made for this tests has a Shed and the Shed is set to half width.
     * The Shed is first drawn then a single strap inside and due to the half width 3 posts.
     */

    @Test
    public void addShedPosts() {
        svg.addShedPosts(fullCarport, intCarportWidth);

        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">";
        String shedRect = "<rect x=\"0\" y=\"20\" height=\"80\" width=\"144\" style=\"stroke:#000000; fill: #ffffff\" />";
        String shedStrap = "<rect x=\"10\" y=\"30\" height=\"60\" width=\"124\" style=\"stroke:#000000; fill: #ffffff\" />";
        String shedPost1 = "<rect x=\"0\" y=\"51\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String shedPost2 = "<rect x=\"134\" y=\"51\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" />";
        String shedPost3 = "<rect x=\"72\" y=\"91\" height=\"9\" width=\"10\" style=\"stroke:#000000; fill: #ffffff\" /></svg>";

        stringBuilder.append(String.format(headerTemplate, shedRect, shedStrap, shedPost1, shedPost2, shedPost3));

        assertThat(svg.toString(), containsString(stringBuilder.toString()));
    }

    @Test
    public void addVerticalPointer() {
        int pointerX = intCarportWidth + 20;
        int pointerY = 20;
        int finishY = intCarportLength;
        svg.addVerticalPointer(pointerX, pointerY, finishY, intCarportLength - 20);

        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">  <defs>\n";
        String arrowTemplate = "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
                "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
                "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "    </defs> ";
        String arrowAndVerticalPointerText = "<line x1=\"328\" y1=\"20\" x2=\"328\" y2=\"288\" style=\"stroke:#000000;\n" +
                "        marker-start: url(#beginArrow);\n" +
                "        marker-end: url(#endArrow);\" /><text style=\"text-anchor: middle\" transform=\"translate(308,154) rotate(-90)\"> 268 cm</text></svg>";


        stringBuilder.append(String.format(headerTemplate, arrowTemplate, arrowAndVerticalPointerText));


        assertThat(svg.toString(), containsString(stringBuilder.toString()));
    }

    @Test
    public void addHorizontalPointer() {
        int pointerX = intCarportWidth + 20;
        int pointerY = intCarportLength + 20;
        int finishX = intCarportWidth;
        svg.addHorizontalPointer(pointerX, pointerY, finishX, intCarportWidth - 20);


        String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"800\" width=\"600\" viewBox=\"0,0,800,600\" preserveAspectRatio=\"xMinYMin\">  <defs>\n";
        String arrowTemplate = "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
                "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
                "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                "        </marker>\n" +
                "    </defs> ";
        String arrowAndHorizontalPointerText = "</defs> <line x1=\"308\" y1=\"338\" x2=\"288\" y2=\"338\" style=\"stroke:#000000;\n" +
                "        marker-start: url(#beginArrow);\n" +
                "        marker-end: url(#endArrow);\" /> <text style=\"text-anchor: middle\" x=\"144\" y=\"328\"> 268 cm</text></svg>\"";


        stringBuilder.append(String.format(headerTemplate, arrowTemplate, arrowAndHorizontalPointerText));

        assertThat(svg.toString(), containsString(stringBuilder.toString()));
    }

}