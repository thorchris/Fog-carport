package FunctionLayer;

/**
 * @Author Josef, Hallur, Thor og Frederik
 */
public class Order {

    private int orderId, userId, rafters, cladding, posts,
            screws, fascia, brackets, straps, doorKnobs, doorHinges;

    /**
     *
     * @param orderId Id for the specific order
     * @param userId Id for the user which the order belongs to
     * @param rafters Variable that stores amount of rafters for the order
     * @param cladding Variable that stores amount of cladding for the order
     * @param posts Variable that stores amount of posts for the order
     * @param screws Variable that stores amount of screws for the order
     * @param fascia Variable that stores amount of fascia for the order
     * @param brackets Variable that stores amount of brackets for the order
     * @param straps Variable that stores amount of straps for the order
     * @param doorKnobs Variable that stores amount of doorknobs for the order
     * @param doorHinges Variable that stores amount of doorhinges for the order
     */

    public Order(int orderId, int userId, int rafters, int cladding, int posts, int screws, int fascia, int brackets, int straps, int doorKnobs, int doorHinges) {
        this.orderId = orderId;
        this.userId = userId;
        this.rafters = rafters;
        this.cladding = cladding;
        this.posts = posts;
        this.screws = screws;
        this.fascia = fascia;
        this.brackets = brackets;
        this.straps = straps;
        this.doorKnobs = doorKnobs;
        this.doorHinges = doorHinges;
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

    public int getRafters() {
        return rafters;
    }

    public void setRafters(int rafters) {
        this.rafters = rafters;
    }

    public int getCladding() {
        return cladding;
    }

    public void setCladding(int cladding) {
        this.cladding = cladding;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public int getScrews() {
        return screws;
    }

    public void setScrews(int screws) {
        this.screws = screws;
    }

    public int getFascia() {
        return fascia;
    }

    public void setFascia(int fascia) {
        this.fascia = fascia;
    }

    public int getBrackets() {
        return brackets;
    }

    public void setBrackets(int brackets) {
        this.brackets = brackets;
    }

    public int getStraps() {
        return straps;
    }

    public void setStraps(int straps) {
        this.straps = straps;
    }

    public int getDoorknobs() {
        return doorKnobs;
    }

    public void setDoorknobs(int doorknobs) {
        this.doorKnobs = doorknobs;
    }

    public int getDoorhinges() {
        return doorHinges;
    }

    public void setDoorhinges(int doorhinges) {
        this.doorHinges = doorhinges;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", rafters=" + rafters +
                ", cladding=" + cladding +
                ", posts=" + posts +
                ", screws=" + screws +
                ", fascia=" + fascia +
                ", brackets=" + brackets +
                ", straps=" + straps +
                ", doorknobs=" + doorKnobs +
                ", doorhinges=" + doorHinges +
                '}';
    }
}
