package FunctionLayer;

public class CarportMaterials {
    private String materialName;
    private int materialID;
    private double materialPrice;

    public CarportMaterials(String materialName, int materialID, double materialPrice) {
        this.materialName = materialName;
        this.materialID = materialID;
        this.materialPrice = materialPrice;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(double materialPrice) {
        this.materialPrice = materialPrice;
    }

    @Override
    public String toString() {
        return "CarportMaterials{" +
                "materialName='" + materialName + '\'' +
                ", materialID=" + materialID +
                ", materialPrice=" + materialPrice +
                '}';
    }
}
