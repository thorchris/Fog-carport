package FunctionLayer;

/**
 * @Author Josef, Hallur, Thor og Frederik
 */
public class Svg {
    private int height;
    private int width;
    private String viewBox;
    private int x;
    private int y;
    private StringBuilder svg = new StringBuilder();
    private final String headerTemplate = "<svg version=\"1.1\" " +
            "xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
            "height=\"%s\" width=\"%s\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\"" +
            " style=\"stroke:#000000; fill: #ffffff\" />";
    private final String arrowTemplate = "  <defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";
    private final String pointerTemplate = " <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:#000000;\n" +
            "        marker-start: url(#beginArrow);\n" +
            "        marker-end: url(#endArrow);\" />";
    private final String verticalPointerText = "<text style=\"text-anchor: middle\" transform=\"translate(%d,%d) rotate(-90)\"> %d cm</text>";

    private final String horizontalPointerText = " <text style=\"text-anchor: middle\" x=\"%d\" y=\"%d\"> %d cm</text>";

    /**
     * The constructor of the SVG object used to determine the size of the SVG drawing.
     * @param height of the drawing
     * @param width of the drawing
     * @param viewBox size of the SVG viewbox -> "like a frame for the drawing"
     * @param x starting point in X axis of the drawing
     * @param y starting point in Y axis of the drawing
     */
    public Svg(int height, int width, String viewBox, int x, int y) {
        this.height = height;
        this.width = width;
        this.viewBox = viewBox;
        this.x = x;
        this.y = y;
        svg.append(String.format(headerTemplate, height, width, viewBox));
    }

    /**
     * Used to make a pointer, inserts the values from the variables into a SVG string.
     *
     * @param x            starting and ending point of the pointer so that it is vertical
     * @param y            starting point in y axis
     * @param y2           finishing point i y axis
     * @param measurement, the value that is the carport length. Reworked into a scalable measure.
     */
    public void addVerticalPointer(int x, int y, int y2, int measurement) {
        svg.append(arrowTemplate);
        svg.append(String.format(pointerTemplate, x + 20, y, x + 20, y2));
        svg.append(String.format(verticalPointerText, x, (y2 / 2) + 10, measurement));
    }

    /**
     * Used to make a pointer, inserts the values from the variables into a SVG string.
     *
     * @param y            starting and ending point of the pointer so that it is horizontal
     * @param x            starting point in the x axis
     * @param x2           finishing point in the x axis
     * @param measurement, the value that is the carport width. Reworked into a scalable measure.
     */
    public void addHorizontalPointer(int x, int y, int x2, int measurement) {
        svg.append(arrowTemplate);
        svg.append(String.format(pointerTemplate, x, y + 30, x2, y + 30));
        svg.append(String.format(horizontalPointerText, (x2 / 2), y + 20, measurement));
    }

    /**
     * Used to generate a lot of the rectangles in the carport design. For an example, the frame of the carport and the posts
     *
     * @param x,      start X point of the rectangle
     * @param y,      start Y point of the rectangle
     * @param height, end point of the rectangle -> used to define size
     * @param width,  end point of the rectangle -> used to define size
     */
    public void addRect(int x, int y, int height, int width) {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    /**
     * Adding Posts to the SVG drawing, since the drawing is a fixed size, some values have been hardcoded.
     *
     * @param fullCarport, used to get amount of posts
     * @param width
     */
    public void addPosts(FullCarport fullCarport, int width, int height) {
        int posts = fullCarport.getCarportParts().getTotalPosts();
        int postHeight = 9;
        int postWidth = 10;
        int posX = 0;
        int posY = 20;
        //Stolper i toppen
        if (posts >= 5) {
            addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2) - postWidth;
            addRect(posX, posY, postHeight, postWidth);
            //sørger for den sidste stolpe er yderst
            posX = 0 + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
            //Stolper i bunden
            posY = 20 + height - postHeight;
            posX = 0;
            addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2) - postWidth;
            addRect(posX, posY, postHeight, postWidth);
            //Sørger for den sidste stolpe er yderst på carport
            posX = 0 + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
        } else {
            addRect(posX, posY, postHeight, postWidth);
            //sørger for den sidste stolpe er yderst
            posX = posX + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
            //Stolper i bunden
            posY = height + posY;
            posX = 0;
            addRect(posX, posY, postHeight, postWidth);
            //Sørger for den sidste stolpe er yderst på carport
            posX = 0 + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
        }
    }

    /**
     *  Adds Straps to the SVG drawing.
     * @param width used to find the X position to draw the straps.
     * @param height used to find the Y position to draw the straps.
     */

    public void addStraps(int width, int height) {
        int strapWidth = 9;
        int posX = 0;
        int posY = 20;
        //First Strap
        posY += (height / 4) - strapWidth;
        addRect(posX, posY, strapWidth, width);
        //Second Strap
        posY = 20;
        posY += height - (height / 4) - strapWidth;
        addRect(posX, posY, strapWidth, width);
    }

    /**
     * Adds rafters to the SVG drawing.
     * @param fullCarport used to get the amount of rafters for the specific carport.
     * @param width used to find the X position to draw the rafter.
     * @param height used to find the Y position to draw the rafter.
     */
    public void addRafters(FullCarport fullCarport, int width, int height) {
        int rafters = (int) fullCarport.getCarportParts().getTotalRafters();

        int rafterWidth = 4;
        int posX = 0;
        int posY = 20;
        for (int i = 0; i < rafters; i++) {
            posX += (width / rafters) - rafterWidth;
            addRect(posX, posY, height, rafterWidth);
        }

    }


    /**
     * StartX = starting point for the posts in X
     * * Starts in  x = 0
     * * Changed as we go to match different positions
     * StartY = starting point for the posts in Y
     * * Starts in Y = 20
     * * Changed as we go to match different positions
     *
     * @param fullCarport, the carport were working on.
     * @param width,       the width of the carport recalculated to CM
     */
    public void addShedPosts(FullCarport fullCarport, int width) {
        int startX = 0;
        int startY = 20;

        if (fullCarport.getCarportParts().isHasAShed() == true) {

            int intShedWidth = width;
            int intShedHeight = (int) (fullCarport.getShed().getShedLength() * 80);
            if (fullCarport.getCarportParts().isHalfWidth() == true) {
                //Shed
                intShedWidth = intShedWidth / 2;
                addRect(startX, startY, intShedHeight, intShedWidth);

                //Shed Straps
                addRect(startX + 10, startY + 10, intShedHeight - 20, intShedWidth - 20);
                int postHeight = 9;
                int postWidth = 10;
                //Posts
                addRect(startX, (startY + (intShedHeight / 2) - postHeight), postHeight, postWidth);
                addRect(startX + (intShedWidth) - postWidth, (startY + (intShedHeight / 2) - postHeight), postHeight, postWidth);
                addRect(startX + (intShedWidth / 2), (startY + intShedHeight) - postHeight, postHeight, postWidth);

            } else {
                intShedWidth = width;
                intShedHeight = (int) (fullCarport.getShed().getShedLength() * 80);
                //Shed
                addRect(startX, startY, intShedHeight, intShedWidth);


                //Shed Straps
                addRect(startX + 10, startY + 10, intShedHeight - 20, intShedWidth - 20);
                int postHeight = 9;
                int postWidth = 10;
                //posts
                addRect(startX + intShedWidth - postWidth, startY, postHeight, postWidth);
                addRect(startX + intShedWidth - postWidth, startY + intShedHeight - postHeight, postHeight, postWidth);

                addRect(startX, startY + intShedHeight - postHeight, postHeight, postWidth);
                addRect(startX + (intShedWidth / 2), startY + intShedHeight - postHeight, postHeight, postWidth);
            }

        }
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getViewBox() {
        return viewBox;
    }

    public void setViewBox(String viewBox) {
        this.viewBox = viewBox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}

