package FunctionLayer;

public class RoofMaterials {
    private String materialName;
    private int materialID;
    private double materialPriceM2, length, width;

    public RoofMaterials(String materialName, int materialID, double materialPriceM2, double width, double length) {
        this.materialName = materialName;
        this.materialID = materialID;
        this.materialPriceM2 = materialPriceM2;
        this.width = width;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
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

    public double getmaterialPriceM2() {
        return materialPriceM2;
    }

    public void setmaterialPriceM2(double materialPriceM2) {
        this.materialPriceM2 = materialPriceM2;
    }

    @Override
    public String toString() {
        return "RoofMaterials{" +
                "materialName='" + materialName + '\'' +
                ", materialID=" + materialID +
                ", materialPriceM2=" + materialPriceM2 +
                '}';
    }
}
