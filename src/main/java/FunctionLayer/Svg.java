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


    public Svg(int height, int width, String viewBox, int x, int y) {
        this.height = height;
        this.width = width;
        this.viewBox = viewBox;
        this.x = x;
        this.y = y;
        svg.append(String.format(headerTemplate, height, width, viewBox));
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
    public void addPosts(FullCarport fullCarport, int width) {
        int posts = fullCarport.getCarportParts().getTotalPosts();
        int postHeight = 9;
        int postWidth = 10;
        int posX = 200;
        int posY = 220;
        //Stolper i toppen
        if(posts >= 5) {
            addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2) - postWidth;
            addRect(posX, posY, postHeight, postWidth);
            //sørger for den sidste stolpe er yderst
            posX  = 440;
            addRect(posX - postWidth, posY, postHeight, postWidth);
         //Stolper i bunden
            posY = 450;
            posX = 200;
            addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2) - postWidth;
            addRect(posX, posY, postHeight, postWidth);
            //Sørger for den sidste stolpe er yderst på carport
            posX  = 440;
            addRect(posX - postWidth, posY, postHeight, postWidth);
        } else {
            addRect(posX, posY, postHeight, postWidth);
            //sørger for den sidste stolpe er yderst
            posX  = 440;
            addRect(posX - postWidth, posY, postHeight, postWidth);
            //Stolper i bunden
            posY = 450;
            posX = 200;
            addRect(posX, posY, postHeight, postWidth);
            //Sørger for den sidste stolpe er yderst på carport
            posX  = 440;
            addRect(posX - postWidth, posY, postHeight, postWidth);
        }
    }

    public void addShedPosts(Svg svg, FullCarport fullCarport){
        int startX = 440;
        int startY = 220;

        if (fullCarport.getCarportParts().isHasAShed() == true) {

            int intShedWidth = 0;
            int intShedHeight = 0;
            if (fullCarport.getCarportParts().isHalfWidth() == true) {
                intShedWidth = 120;
                intShedHeight = 120;
                //Shed
                svg.addRect(startX, startY, intShedHeight, intShedWidth);
                int postHeight = 9;
                int postWidth = 10;
                //Posts
                svg.addRect(startX+intShedWidth-postWidth,(startY + (intShedHeight/2)-postHeight),postHeight,postWidth);
                svg.addRect(startX+(intShedWidth/2),startY,postHeight,postWidth);
                svg.addRect(startX+(intShedWidth/2),(startY+intShedHeight)-postHeight,postHeight,postWidth);

            } else {
                intShedWidth = 240;
                intShedHeight = 120;
                //Shed
                svg.addRect(startX, startY, intShedHeight, intShedWidth);
                int postHeight = 9;
                int postWidth = 10;
                //posts
                svg.addRect(startX+intShedWidth-postWidth,startY,postHeight,postWidth);
                svg.addRect(startX+intShedWidth-postWidth,startY + intShedHeight-postHeight,postHeight,postWidth);

                svg.addRect(startX+(intShedWidth/2),startY,postHeight,postWidth);
                svg.addRect(startX+(intShedWidth/2),startY +intShedHeight-postHeight,postHeight,postWidth);
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

