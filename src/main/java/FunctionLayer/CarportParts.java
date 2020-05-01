package FunctionLayer;

import Util.CalcCarportMaterials;

public class CarportParts {

    private double length, width, totalSkrew, totalRafters, carportCladding;
    private int totalPosts, sidesWithCladding;
    private boolean hasAShed, isHalfWidth;
    private CarportMaterials carportMaterials;


    // MEGET VIGTIGT RÆKKEFØLGE
    public CarportParts(double length, double width, boolean hasAShed, boolean isHalfWidth, CarportMaterials carportMaterials, int sidesWithCladding) {
        CalcCarportMaterials calcCarportMaterials = new CalcCarportMaterials(this);
        this.length = length;
        this.width = width;
        this.totalSkrew = 300; //you need 500 screws to do the carport parts
        this.hasAShed = hasAShed;
        this.isHalfWidth = isHalfWidth;
        this.totalRafters = calcCarportMaterials.calculateRafters();
        this.totalPosts = calcCarportMaterials.calculateAmountOfPosts();
        this.carportMaterials = carportMaterials;
        this.sidesWithCladding = sidesWithCladding;
        this.carportCladding = calcCarportMaterials.calculateCarportCladding();
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

    public double getTotalSkrew() {
        return totalSkrew;
    }

    public void setTotalSkrew(double totalSkrew) {
        this.totalSkrew = totalSkrew;
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

    @Override
    public String toString() {
        return "CarportParts{" +
                "length=" + length +
                ", width=" + width +
                ", totalSkrew=" + totalSkrew +
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
