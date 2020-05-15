package FunctionLayer;

public class FullCarport {
    private CarportParts carportParts;
    private Roof roof;
    private Shed shed;
    private Order order;

    /**
     * @param carportParts variable containing an object of the class CarportParts
     * @param roof variable containing an object of the class Roof
     * @param shed variable containing an object of the class Shed
     */

    public FullCarport(CarportParts carportParts, Roof roof, Shed shed) {
        this.carportParts = carportParts;
        this.roof = roof;
        this.shed = shed;
    }

    public CarportParts getCarportParts() {
        return carportParts;
    }

    public Roof getRoof() {
        return roof;
    }

    public Shed getShed() {
        return shed;
    }

    @Override
    public String toString() {
        return "FullCarport{" +
                "carportParts=" + carportParts.toString() +
                ", roof=" + roof.toString() +
                ", shed=" + shed.toString() +
                '}';
    }
}
