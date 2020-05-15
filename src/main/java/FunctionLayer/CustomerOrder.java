package FunctionLayer;

public class CustomerOrder {

    int customerOrderId, orderId, userId, cp_length, cp_width, claddingSides, roofAngle, price,roofMatId, cpMatId, shedMatId;;

    /**
     * @param roofMatId the ID specifying which roof material is used
     * @param cpMatId the ID specifying which carport material is used
     * @param shedMatId the ID specifying which shed material is used
     * @param orderId the ID for the order
     * @param userId the ID of the user that the order belongs to
     * @param cp_length variable with the length of the carport
     * @param cp_width variable with the width of the carport
     * @param claddingSides variable containing the number of sides with cladding
     * @param roofAngle variable with the roof angle
     * @param price variable containing the price for the customer order
     */

    public CustomerOrder(int roofMatId, int cpMatId, int shedMatId, int orderId, int userId, int cp_length, int cp_width, int claddingSides, int roofAngle, int price) {
        this.roofMatId = roofMatId;
        this.cpMatId = cpMatId;
        this.shedMatId = shedMatId;

        this.orderId = orderId;
        this.userId = userId;
        this.cp_length = cp_length;
        this.cp_width = cp_width;
        this.claddingSides = claddingSides;
        this.roofAngle = roofAngle;
        this.price = price;
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

    public int getCp_length() {
        return cp_length;
    }

    public void setCp_length(int cp_length) {
        this.cp_length = cp_length;
    }

    public int getCp_width() {
        return cp_width;
    }

    public void setCp_width(int cp_width) {
        this.cp_width = cp_width;
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

    public int getPrice() {
        return price;
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
                ", cp_length=" + cp_length +
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
