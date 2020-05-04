package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static List<RoofMaterials> getRoofMaterialsList() {
        List<RoofMaterials> materialNames = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.roof_materials";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("material_name");
                int id = rs.getInt("material_id");
                double materialPriceM2 = rs.getDouble("material_price_m2");
                double width = rs.getDouble("width");
                double length = rs.getDouble("length");
                RoofMaterials roofMaterial = new RoofMaterials(name, id, materialPriceM2,width,length);
                materialNames.add(roofMaterial);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return materialNames;
    }

    public static List<Product> getProductList() {
        List<Product> productsList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.products";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("productID");
                String uom = rs.getString("uom");
                double price = rs.getDouble("price");
                Product product = new Product(id,name, uom, price);
                productsList.add(product);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return productsList;
    }

    public static List<CarportMaterials> getCarportMaterialsList() {
        List<CarportMaterials> CarportMaterialNames = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.carport_materials";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("material_name");
                int id = rs.getInt("material_id");
                double materialPiecePrice = rs.getDouble("material_piece_price");
                double width = rs.getDouble("width");
                double length = rs.getDouble("length");
                CarportMaterials carportMat = new CarportMaterials(name, id, materialPiecePrice,width,length);
                CarportMaterialNames.add(carportMat);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return CarportMaterialNames;
    }
    public static void addOrder(User user, FullCarport carport) {
        int rafters = (int) carport.getCarportParts().getTotalRafters();
        int cladding = (int) carport.getCarportParts().getCarportCladding();
        int screws = (int) ((int) carport.getCarportParts().getTotalScrews() + carport.getRoof().getScrew()); ;
        int posts = carport.getCarportParts().getTotalPosts();
        int fascia = (int) carport.getRoof().getFascia();
        int brackets = (int) carport.getRoof().getBracket();
        int straps = carport.getCarportParts().getAmountOfStraps();
        int doorKnobs = carport.getShed().getDoorKnob();
        int doorHinges = carport.getShed().getDoorHinges();
        int user_Id = user.getId();

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogcarport.order (user_id, rafters,  cladding,  posts,  screws,  fascia,  brackets,  straps,  doorKnobs,  doorHinges) VALUES (?, ?, ?, ?,?, ?, ?,?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user_Id);
            ps.setInt(2, rafters);
            ps.setInt(3, cladding);
            ps.setInt(4, posts);
            ps.setInt(5, screws);
            ps.setInt(6, fascia);
            ps.setInt(7, brackets);
            ps.setInt(8, straps);
            ps.setInt(9, doorKnobs);
            ps.setInt(10, doorHinges);
            ps.execute();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke finde oprette order med carporten");
        }
    }
}
