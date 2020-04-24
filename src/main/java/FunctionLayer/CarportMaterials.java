package FunctionLayer;

public class CarportMaterials {
    private String materialName;
    private int materialID;
    private double materialPriceM;
    private double width;
    private double length;

    public CarportMaterials(String materialName, int materialID, double materialPriceM, double width, double length) {
        this.materialName = materialName;
        this.materialID = materialID;
        this.materialPriceM = materialPriceM;
        this.width = width;
        this.length = length;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getMaterialPriceM() {
        return materialPriceM;
    }

    public void setMaterialPriceM(double materialPriceM) {
        this.materialPriceM = materialPriceM;
    }
}
