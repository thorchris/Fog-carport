package FunctionLayer;

public class Product {
    private int id;
    private String name, uom;
    private double price;

    /**
     * @param id variable containing the id for the specific product
     * @param name name of the product
     * @param uom unit of measurement of the product
     * @param price price of the product
     */

    public Product(int id, String name, String uom, double price) {
        this.id = id;
        this.name = name;
        this.uom = uom;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uom='" + uom + '\'' +
                ", price=" + price +
                '}';
    }
}
