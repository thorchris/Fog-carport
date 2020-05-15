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
            String SQL = "SELECT * FROM roof_materials";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("material_name");
                int id = rs.getInt("material_id");
                double materialPriceM2 = rs.getDouble("material_price_m2");
                double width = rs.getDouble("width");
                double length = rs.getDouble("length");
                RoofMaterials roofMaterial = new RoofMaterials(name, id, materialPriceM2, width, length);
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
            String SQL = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("productID");
                String uom = rs.getString("uom");
                double price = rs.getDouble("price");
                Product product = new Product(id, name, uom, price);
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
            String SQL = "SELECT * FROM carport_materials";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("material_name");
                int id = rs.getInt("material_id");
                double materialPiecePrice = rs.getDouble("material_piece_price");
                double width = rs.getDouble("width");
                double length = rs.getDouble("length");
                CarportMaterials carportMat = new CarportMaterials(name, id, materialPiecePrice, width, length);
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
        int screws = (int) ((int) carport.getCarportParts().getTotalScrews() + carport.getRoof().getScrew());
        int posts = carport.getCarportParts().getTotalPosts();
        int fascia = (int) carport.getRoof().getFascia();
        int brackets = (int) carport.getRoof().getBracket();
        int straps = carport.getCarportParts().getAmountOfStraps();
        int doorKnobs = carport.getShed().getDoorKnob();
        int doorHinges = carport.getShed().getDoorHinges();
        int user_Id = user.getId();

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (user_id, rafters,  cladding,  posts,  screws,  fascia,  brackets,  straps,  doorKnobs,  doorHinges) VALUES (?, ?, ?, ?,?, ?, ?,?, ?, ?)";
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

    public static List<Order> getOrderList() {
        List<Order> CarportItemList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM orders";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int orderid = rs.getInt("order_id");
                int userid = rs.getInt("user_id");
                int rafters = rs.getInt("rafters");
                int cladding = rs.getInt("cladding");
                int posts = rs.getInt("posts");
                int screws = rs.getInt("screws");
                int fascia = rs.getInt("fascia");
                int brackets = rs.getInt("brackets");
                int straps = rs.getInt("straps");
                int doorknobs = rs.getInt("doorknobs");
                int doorhinges = rs.getInt("doorhinges");
                Order order = new Order(orderid, userid, rafters, cladding, posts, screws, fascia, brackets, straps, doorknobs, doorhinges);
                CarportItemList.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return CarportItemList;
    }

    /**
     * @param user GetCustomerDesign is used to get the saved user designs from the DB, we are using a user as parameter to get the logged in useres id.
     * @return We're returning an object of a customer order
     */
    public static List<CustomerOrder> getCustomerDesign(User user) {
        List<CustomerOrder> customerOrderList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM customer_order WHERE user_id = " + user.getId();
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);

            while (rs.next()) {
                int roofMatId = rs.getInt("roof_mats");
                int cpMatId = rs.getInt("cp_mats");
                int shedMatId = rs.getInt("shed_mats");
                int customerOrderId = rs.getInt("co_id");
                int orderId = rs.getInt("order_id");
                int userId = rs.getInt("user_id");
                double cpLength = rs.getDouble("cp_length");
                double cpWidth = rs.getDouble("cp_width");
                int claddingSides = rs.getInt("cladding_sides");
                int roofAngle = rs.getInt("roof_angle");
                double price = rs.getDouble("price");
                CustomerOrder co = new CustomerOrder(roofMatId, cpMatId, shedMatId, orderId, userId, cpLength, cpWidth, claddingSides, roofAngle, price);
                co.setCustomerOrderId(customerOrderId);
                customerOrderList.add(co);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return customerOrderList;
    }

    public static void createCustomerDesign(CustomerOrder customerOrder) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO customer_order (order_id, user_id, cp_length, cp_width, " +
                    "roof_mats, shed_mats, cp_mats, cladding_sides, roof_angle, price) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerOrder.getOrderId());
            ps.setInt(2, customerOrder.getUserId());
            ps.setDouble(3, customerOrder.getCp_length());
            ps.setDouble(4, customerOrder.getCp_width());
            ps.setInt(5, customerOrder.getRoofMatId());
            ps.setInt(6, customerOrder.getShedMatId());
            ps.setInt(7, customerOrder.getCpMatId());
            ps.setInt(8, customerOrder.getCladdingSides());
            ps.setInt(9, customerOrder.getRoofAngle());
            ps.setDouble(10, customerOrder.getPrice());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("There was a error creating the customerOrder in the database");
        }

    }


    public static List<CustomerOrder> getCustomerDesignOrder(int customerId) {
        List<CustomerOrder> customerOrderList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM customer_order WHERE user_id = " + customerId;
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);

            while (rs.next()) {
                int roofMatId = rs.getInt("roof_mats");
                int cpMatId = rs.getInt("cp_mats");
                int shedMatId = rs.getInt("shed_mats");
                int customerOrderId = rs.getInt("co_id");
                int orderId = rs.getInt("order_id");
                int userId = rs.getInt("user_id");
                double cpLength = rs.getDouble("cp_length");
                double cpWidth = rs.getDouble("cp_width");
                int claddingSides = rs.getInt("cladding_sides");
                int roofAngle = rs.getInt("roof_angle");
                double price = rs.getDouble("price");
                CustomerOrder co = new CustomerOrder(roofMatId, cpMatId, shedMatId, orderId, userId, cpLength, cpWidth, claddingSides, roofAngle, price);
                co.setCustomerOrderId(customerOrderId);
                customerOrderList.add(co);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return customerOrderList;
    }

    public static int getUserOrderId(User user) {
        int orderid = 0;
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM orders WHERE user_id = " + user.getId();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                orderid = rs.getInt("order_id");

            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            System.out.println("Kunne ikke finde orderID");
        }
        return orderid;
    }


    public static Order getCustomerOrder(int orderId) throws OrderException {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM orders WHERE order_id = " + orderId;
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int orderid = rs.getInt("order_id");
                int userid = rs.getInt("user_id");
                int rafters = rs.getInt("rafters");
                int cladding = rs.getInt("cladding");
                int posts = rs.getInt("posts");
                int screws = rs.getInt("screws");
                int fascia = rs.getInt("fascia");
                int brackets = rs.getInt("brackets");
                int straps = rs.getInt("straps");
                int doorknobs = rs.getInt("doorknobs");
                int doorhinges = rs.getInt("doorhinges");
                Order order = new Order(orderid, userid, rafters, cladding, posts, screws, fascia, brackets, straps, doorknobs, doorhinges);
                return order;
            } else {
                throw new OrderException("Could not find order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }


    public static void deleteOrder(int order_id) {
        try {
            String SQL = "DELETE FROM orders WHERE order_id = " + order_id;
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            ps.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke fjerne order");
        }
    }


    public static void updatePrice(int co_Id, double price) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE customer_order SET price = (?) WHERE co_Id = (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, price);
            ps.setInt(2, co_Id);
            ps.execute();
            ps.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke opdatere pris");
        }
    }


}