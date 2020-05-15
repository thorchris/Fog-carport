package FunctionLayer;

public class CarportMaterials {

    private String materialName;
    private int materialID;
    private double materialPriceM;
    private double width;
    private double length;

    /**
     * @param materialName variable containing the name of the specific material
     * @param materialID variable containing the ID for the specific material
     * @param materialPriceM variable with the price for each material
     * @param width varibale with the width of material
     * @param length variable with the length of material
     */

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

    @Override
    public String toString() {
        return "CarportMaterials{" +
                "materialName='" + materialName + '\'' +
                ", materialID=" + materialID +
                ", materialPriceM=" + materialPriceM +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
