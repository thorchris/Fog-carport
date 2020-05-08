package FunctionLayer;

public class CustomerOrder {
    String roofMatName, cpMatName, shedMatName;
    int customerOrderId, orderId, userId, cp_length, cp_width, claddingSides, roofAngle, price;

    public CustomerOrder(String roofMatName, String cpMatName, String shedMatName, int customerOrderId, int orderId, int userId, int cp_length, int cp_width, int claddingSides, int roofAngle, int price) {
        this.roofMatName = roofMatName;
        this.cpMatName = cpMatName;
        this.shedMatName = shedMatName;
        this.customerOrderId = customerOrderId;
        this.orderId = orderId;
        this.userId = userId;
        this.cp_length = cp_length;
        this.cp_width = cp_width;
        this.claddingSides = claddingSides;
        this.roofAngle = roofAngle;
        this.price = price;
    }

    public String getRoofMatName() {
        return roofMatName;
    }

    public void setRoofMatName(String roofMatName) {
        this.roofMatName = roofMatName;
    }

    public String getCpMatName() {
        return cpMatName;
    }

    public void setCpMatName(String cpMatName) {
        this.cpMatName = cpMatName;
    }

    public String getShedMatName() {
        return shedMatName;
    }

    public void setShedMatName(String shedMatName) {
        this.shedMatName = shedMatName;
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
}
