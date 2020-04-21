package DBAccess;

import FunctionLayer.RoofMaterials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static List<RoofMaterials> getRoffMaterialsList() {
        List<RoofMaterials> materialNames = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.roof_materials";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("material_name");
                int id = rs.getInt("material_id");
                double materialPrice = rs.getDouble("material_price_m");
                RoofMaterials roofMaterial = new RoofMaterials(name, id, materialPrice);
                materialNames.add(roofMaterial);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return materialNames;
    }

    public static void main(String[] args) {
        List<RoofMaterials> test2 = getRoffMaterialsList();
        System.out.println(test2);
    }
}
