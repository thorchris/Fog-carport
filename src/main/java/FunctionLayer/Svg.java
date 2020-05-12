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

    public void addRect(int x, int y, int height, int width) {
        svg.append(String.format(rectTemplate, x, y, height, width));
    }

    public void addPosts(Svg svg, FullCarport fullCarport, int width, int height) {
        int posts = fullCarport.getCarportParts().getTotalPosts();
        int postHeight = 9;
        int postWidth = 10;
        int posX = 0;
        int posY = 0;
        //Stolper i toppen
        for (int i = 0; i < (posts / 2) - 1; i++) {
            svg.addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2)-postWidth;
        }

        //sørger for den sidste stolpe er yderst
        svg.addRect(width-postWidth, posY, postHeight, postWidth);
        //Stolper i bunden af tegningen
        posY = height-postHeight;
        posX = 0;
        for (int i = 0; i < (posts / 2) - 1; i++) {
            svg.addRect(posX, posY, postHeight, postWidth);
            posX += (width / 2)-postWidth;
        }
        //Sørger for den sidste stolpe er yderst på carport
        svg.addRect(width-postWidth, posY, postHeight, postWidth);

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

