package FunctionLayer;

public class ShedMaterials {

    private double woodWith, pricePrM2;
    private int materialID;

    /**
     * Fog uses a standard woodtype that always is 0.15m and a price off 25
     */

    public ShedMaterials() {
        this.woodWith = 0.15; this.pricePrM2 = 25;  this.materialID = 1;
    }

    public double getWoodWith() {
        return woodWith;
    }

    public void setWoodWith(double woodWith) {
        this.woodWith = woodWith;
    }

    public double getPricePrM2() {
        return pricePrM2;
    }

    @Override
    public String toString() {
        return "ShedMaterials{" +
                "woodWith=" + woodWith +
                ", pricePrM2=" + pricePrM2 +
                '}';
    }

    public int getMaterialID() {
        return materialID;
    }
}
