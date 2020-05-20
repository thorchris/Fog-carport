package FunctionLayer;

/**
 * @Author Josef, Hallur, Thor og Frederik
 */

public class CustomerOrder {

    private double cp_height, cp_width, price;
    private int customerOrderId, orderId, userId, claddingSides, roofAngle,roofMatId, cpMatId, shedMatId;
    private boolean hasShed, shedHalf;

    /**
     * @param roofMatId the ID specifying which roof material is used
     * @param cpMatId the ID specifying which carport material is used
     * @param shedMatId the ID specifying which shed material is used
     * @param orderId the ID for the order
     * @param userId the ID of the user that the order belongs to
     * @param cp_height variable with the length of the carport
     * @param cp_width variable with the width of the carport
     * @param claddingSides variable containing the number of sides with cladding
     * @param roofAngle variable with the roof angle
     * @param price variable containing the price for the customer order
     */

    public CustomerOrder(int roofMatId, int cpMatId, int shedMatId, int orderId, int userId, double cp_height, double cp_width, boolean hasShed, boolean shedHalf, int claddingSides, int roofAngle, double price) {
        this.roofMatId = roofMatId;
        this.cpMatId = cpMatId;
        this.shedMatId = shedMatId;
        this.orderId = orderId;
        this.userId = userId;
        this.cp_height = cp_height;
        this.cp_width = cp_width;
        this.claddingSides = claddingSides;
        this.roofAngle = roofAngle;
        this.hasShed=hasShed;
        this.shedHalf =shedHalf;
        this.price = price;
    }

    public boolean getHasShed() {
        return hasShed;
    }

    public void setHasShed(boolean hasShed) {
        this.hasShed = hasShed;
    }

    public boolean getShedHalf() {
        return shedHalf;
    }

    public void setShedHalf(boolean shedHalf) {
        this.shedHalf = shedHalf;
    }
    public int getRoofMatId() {
        return roofMatId;
    }

    public void setRoofMatId(int roofMatId) {
        this.roofMatId = roofMatId;
    }

    public int getCpMatId() {
        return cpMatId;
    }

    public void setCpMatId(int cpMatId) {
        this.cpMatId = cpMatId;
    }

    public int getShedMatId() {
        return shedMatId;
    }

    public void setShedMatId(int shedMatId) {
        this.shedMatId = shedMatId;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getCp_height() {
        return cp_height;
    }


    public double getCp_width() {
        return cp_width;
    }

    public int getCladdingSides() {
        return claddingSides;
    }

    public void setCladdingSides(int claddingSides) {
        this.claddingSides = claddingSides;
    }

    public int getRoofAngle() {
        return roofAngle;
    }

    public void setRoofAngle(int roofAngle) {
        this.roofAngle = roofAngle;
    }

    public double getPrice() {
        return price;
    }



    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "customerOrderId=" + customerOrderId +
                ", orderId=" + orderId +
                ", userId=" + userId +
                ", cp_length=" + cp_height +
                ", cp_width=" + cp_width +
                ", claddingSides=" + claddingSides +
                ", roofAngle=" + roofAngle +
                ", price=" + price +
                ", roofMatId=" + roofMatId +
                ", cpMatId=" + cpMatId +
                ", shedMatId=" + shedMatId +
                '}';
    }
}
