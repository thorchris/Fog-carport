package FunctionLayer;

import Util.CalcCarportMaterials;

public class CarportParts {

    /**
     * CarportParts class:
     * @gbl length: Variable that stores the length of the carport
     * @gbl width: Variable that stores the width of the carport
     * @gbl totalRafters: Variable that stores the total amount of rafters for the carport
     * @gbl carportCladding: Variable that stores amount of cladding for the carport
     * @gbl strapLength: Variable that stores length of Straps for the carport
     * @gbl totalPosts: Variable that stores the total amount of posts for the carport
     * @gbl sidesWithCladding: Variable that stores the amount of sides with cladding
     * @gbl amountOfStraps: Variable that stores the amount of straps for the carport
     * @gbl hasAShed: Boolean variable that determines if the carport has a shed
     * @gbl isHalfWidh: Boolean variable that determines if the shed is half or full width of the carport
     * @gbl carportMaterials: Carport Materials is the materials you can choose to have your carport built from
     */

    private double length, width, totalScrews, totalRafters, carportCladding, strapLength;
    private int totalPosts, sidesWithCladding, amountOfStraps;
    private boolean hasAShed, isHalfWidth;
    private CarportMaterials carportMaterials;

    /**
     * The constructor for CarportParts calls calculation methods from the class CalcCarportMaterials.
     * I uses these to determine the values for CarportParts - The global variabels are set upon creating a instance of carportParts.
     * @param length Variable that stores the length
     * @param width Variable that stores the Width
     * @param hasAShed Boolean variable that determines if there is a shed
     * @param isHalfWidth Boolean variable that determines if the shed is full or half width
     * @param carportMaterials Variable that contains the material the carport is built out of
     * @param sidesWithCladding contains the amount of sides with cladding
     */


    // MEGET VIGTIGT RÆKKEFØLGE
    public CarportParts(double length, double width, boolean hasAShed, boolean isHalfWidth, CarportMaterials carportMaterials, int sidesWithCladding) {
        CalcCarportMaterials calcCarportMaterials = new CalcCarportMaterials(this);
        this.length = length;
        this.width = width;
        this.totalScrews = 300; //you need 500 screws to do the carport parts
        this.hasAShed = hasAShed;
        this.isHalfWidth = isHalfWidth;
        this.totalRafters = calcCarportMaterials.calculateRafters();
        this.totalPosts = calcCarportMaterials.calculateAmountOfPosts();
        this.carportMaterials = carportMaterials;
        this.sidesWithCladding = sidesWithCladding;
        this.carportCladding = calcCarportMaterials.calculateCarportCladding();
        this.amountOfStraps =  calcCarportMaterials.amountOfStraps();
        this.strapLength = calcCarportMaterials.calcStrapLength();

    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getTotalScrews() {
        return totalScrews;
    }

    public void setTotalScrews(double totalScrews) {
        this.totalScrews = totalScrews;
    }

    public double getTotalRafters() {
        return totalRafters;
    }

    public void setTotalRafters(double totalRafters) {
        this.totalRafters = totalRafters;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public boolean isHasAShed() {
        return hasAShed;
    }

    public void setHasAShed(boolean hasAShed) {
        this.hasAShed = hasAShed;
    }

    public boolean isHalfWidth() {
        return isHalfWidth;
    }

    public void setHalfWidth(boolean halfWidth) {
        isHalfWidth = halfWidth;
    }

    public CarportMaterials getCarportMaterials() {
        return carportMaterials;
    }

    public void setCarportMaterials(CarportMaterials carportMaterials) {
        this.carportMaterials = carportMaterials;
    }

    public int getSidesWithCladding() {
        return sidesWithCladding;
    }

    public double getCarportCladding() {
        return carportCladding;
    }

    public double getStrapLength() {
        return strapLength;
    }

    public int getAmountOfStraps() {
        return amountOfStraps;
    }

    @Override
    public String toString() {
        return "CarportParts{" +
                "length=" + length +
                ", width=" + width +
                ", totalSkrew=" + totalScrews +
                ", totalRafters=" + totalRafters +
                ", carportCladding=" + carportCladding +
                ", totalPosts=" + totalPosts +
                ", sidesWithCladding=" + sidesWithCladding +
                ", hasAShed=" + hasAShed +
                ", isHalfWidth=" + isHalfWidth +
                ", carportMaterials=" + carportMaterials +
                '}';
    }
}
