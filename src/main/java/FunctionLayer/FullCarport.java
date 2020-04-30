package FunctionLayer;

public class FullCarport {
    private CarportParts carportParts;
    private Roof roof;
    private Shed shed;

    public FullCarport(CarportParts carportParts, Roof roof, Shed shed) {
        this.carportParts = carportParts;
        this.roof = roof;
        this.shed = shed;
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
