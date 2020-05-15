package FunctionLayer;

public class CustomerOrder {

    double cp_length, cp_width, price;
    int customerOrderId, orderId, userId, claddingSides, roofAngle,roofMatId, cpMatId, shedMatId;;

    public CustomerOrder(int roofMatId, int cpMatId, int shedMatId, int orderId, int userId, double cp_length, double cp_width, int claddingSides, int roofAngle, double price) {
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

    public double getCp_length() {
        return cp_length;
    }

    public void setCp_length(int cp_length) {
        this.cp_length = cp_length;
    }

    public double getCp_width() {
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

    public double getPrice() {
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
