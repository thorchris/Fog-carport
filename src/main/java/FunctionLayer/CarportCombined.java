package FunctionLayer;

public class CarportCombined {

    private int totalPosts;
    private int amountOfScrews;
    private int amountOfRafters;
    private int amountOfCladding;
    private double totalAmountOfShedCladding ;
    private double amountOfRafter;
    private double amountOfBrackets;
    private int fascia;
    private double totalRoofAreal;
    private double roofHeight;

    public CarportCombined(int totalPosts, int amountOfScrews, int amountOfRafters, int amountOfCladding, double totalAmountOfShedCladding, double amountOfRafter, double amountOfBrackets, int fascia, double totalRoofAreal, double roofHeight) {
        this.totalPosts = totalPosts;
        this.amountOfScrews = amountOfScrews;
        this.amountOfRafters = amountOfRafters;
        this.amountOfCladding = amountOfCladding;
        this.totalAmountOfShedCladding = totalAmountOfShedCladding;
        this.amountOfRafter = amountOfRafter;
        this.amountOfBrackets = amountOfBrackets;
        this.fascia = fascia;
        this.totalRoofAreal = totalRoofAreal;
        this.roofHeight = roofHeight;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public int getAmountOfScrews() {
        return amountOfScrews;
    }

    public void setAmountOfScrews(int amountOfScrews) {
        this.amountOfScrews = amountOfScrews;
    }

    public int getAmountOfRafters() {
        return amountOfRafters;
    }

    public void setAmountOfRafters(int amountOfRafters) {
        this.amountOfRafters = amountOfRafters;
    }

    public int getAmountOfCladding() {
        return amountOfCladding;
    }

    public void setAmountOfCladding(int amountOfCladding) {
        this.amountOfCladding = amountOfCladding;
    }

    public double getTotalAmountOfShedCladding() {
        return totalAmountOfShedCladding;
    }

    public void setTotalAmountOfShedCladding(double totalAmountOfShedCladding) {
        this.totalAmountOfShedCladding = totalAmountOfShedCladding;
    }

    public double getAmountOfRafter() {
        return amountOfRafter;
    }

    public void setAmountOfRafter(double amountOfRafter) {
        this.amountOfRafter = amountOfRafter;
    }

    public double getAmountOfBrackets() {
        return amountOfBrackets;
    }

    public void setAmountOfBrackets(double amountOfBrackets) {
        this.amountOfBrackets = amountOfBrackets;
    }

    public int getFascia() {
        return fascia;
    }

    public void setFascia(int fascia) {
        this.fascia = fascia;
    }

    public double getTotalRoofAreal() {
        return totalRoofAreal;
    }

    public void setTotalRoofAreal(double totalRoofAreal) {
        this.totalRoofAreal = totalRoofAreal;
    }

    public double getRoofHeight() {
        return roofHeight;
    }

    public void setRoofHeight(double roofHeight) {
        this.roofHeight = roofHeight;
    }

    @Override
    public String toString() {
        return "CarportCombined" +
                "totalPosts=" + totalPosts +
                ", amountOfScrews=" + amountOfScrews +
                ", amountOfRafters=" + amountOfRafters +
                ", amountOfCladding=" + amountOfCladding +
                ", totalAmountOfShedCladding=" + totalAmountOfShedCladding +
                ", amountOfRafter=" + amountOfRafter +
                ", amountOfBrackets=" + amountOfBrackets +
                ", fascia=" + fascia +
                ", totalRoofAreal=" + totalRoofAreal +
                ", roofHeight=" + roofHeight +
                '}';
    }
}
