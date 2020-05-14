package FunctionLayer;

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
    private final String verticalPointerText = "<text style=\"text-anchor: middle\" transform=\"translate(165,300) rotate(-90)\"> %d cm</text>";

    private final String horizontalPointerText = " <text style=\"text-anchor: middle\" x=\"320\" y=\"180\"> %d cm</text>";


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
     * @param x
     * @param y
     * @param x2
     * @param y2
     * @param measurement
     */
    public void addVerticalPointer(int x, int y, int x2, int y2, int measurement){
        svg.append(arrowTemplate);
        svg.append(String.format(pointerTemplate, x, y, x2, y2));
        svg.append(String.format(verticalPointerText,measurement));
    }

    /**
     * Used to make a pointer, inserts the values from the variables into a SVG string.
     * @param x
     * @param y
     * @param x2
     * @param y2
     * @param measurement
     */
    public void addHorizontalPointer(int x, int y, int x2, int y2, int measurement){
        svg.append(arrowTemplate);
        svg.append(String.format(pointerTemplate, x, y, x2, y2));
        svg.append(String.format(horizontalPointerText,measurement));
    }

    /**
     * Used to generate a lot of the rectangles in the carport design. For an example, the frame of the carport and the posts
     * @param x, start X point of the rectangle
     * @param y, start Y point of the rectangle
     * @param height, end point of the rectangle -> used to define size
     * @param width, end point of the rectangle -> used to define size
     */
    public void addRect(int x, int y, int height, int width) {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    /**
     * Adding Posts to the SVG drawing, since the drawing is a fixed size, some values have been hardcoded.
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
        if(posts >= 5) {
            addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2) - postWidth;
            addRect(posX, posY, postHeight, postWidth);
            //sørger for den sidste stolpe er yderst
            posX  = 0 + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
         //Stolper i bunden
            posY = 20 + height-postHeight;
            posX = 0;
            addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2) - postWidth;
            addRect(posX, posY, postHeight, postWidth);
            //Sørger for den sidste stolpe er yderst på carport
            posX  = 0 + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
        } else {
            addRect(posX, posY, postHeight, postWidth);
            //sørger for den sidste stolpe er yderst
            posX  = posX + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
            //Stolper i bunden
            posY = height + posY;
            posX = 0;
            addRect(posX, posY, postHeight, postWidth);
            //Sørger for den sidste stolpe er yderst på carport
            posX  = 0 + width;
            addRect(posX - postWidth, posY, postHeight, postWidth);
        }
    }

    /**
     * StartX = starting point for the posts in X
     *      * Starts in  x = 0
     *      * Changed as we go to match different positions
     * StartY = starting point for the posts in Y
     *      * Starts in Y = 20
     *      * Changed as we go to match different positions
     * @param fullCarport, the carport were working on.
     * @param width, the width of the carport recalculated to CM
     */
    public void addShedPosts(FullCarport fullCarport, int width){
        int startX = 0;
        int startY = 20;

        if (fullCarport.getCarportParts().isHasAShed() == true) {

            int intShedWidth = width;
            int intShedHeight = (int) (fullCarport.getShed().getShedLength()*80);
            if (fullCarport.getCarportParts().isHalfWidth() == true) {
                //Shed
                intShedWidth = intShedWidth/2;
                addRect(startX, startY, intShedHeight, intShedWidth);

                //Shed REMME
                addRect(startX+10, startY+10, intShedHeight-20, intShedWidth-20);
                int postHeight = 9;
                int postWidth = 10;
                //Posts
                addRect(startX,(startY + (intShedHeight/2)-postHeight),postHeight,postWidth);
                addRect(startX+(intShedWidth)-postWidth,(startY + (intShedHeight/2)-postHeight),postHeight,postWidth);
                addRect(startX+(intShedWidth/2),(startY+intShedHeight)-postHeight,postHeight,postWidth);

            } else {
                intShedWidth = width;
                intShedHeight = (int) (fullCarport.getShed().getShedLength()*80);
                //Shed
                addRect(startX, startY, intShedHeight, intShedWidth);


                //Shed REMME
                addRect(startX+10, startY+10, intShedHeight-20, intShedWidth-20);
                int postHeight = 9;
                int postWidth = 10;
                //posts
                addRect(startX+intShedWidth-postWidth,startY,postHeight,postWidth);
                addRect(startX+intShedWidth-postWidth,startY + intShedHeight-postHeight,postHeight,postWidth);

                addRect(startX,startY+intShedHeight-postHeight,postHeight,postWidth);
                addRect(startX+(intShedWidth/2),startY+intShedHeight-postHeight,postHeight,postWidth);
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

