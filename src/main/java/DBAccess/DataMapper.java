package DBAccess;

import FunctionLayer.*;
import PresentationLayer.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Datamapper class is used to get information from the database regarding products, orders etc.
 * It uses the connection, that is created with the singleton principle.
 * @Author Josef, Hallur, Thor og Frederik
 */
public class DataMapper {

    /**
     * Return a list of roof materials from the database. Used in roof class to get material.
     * @return a List<> containing all the roofmaterials.
     * If connections is not established it catches an exception and logs it
     */
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
            Log.severe("GetRoofMaterials " + ex.getMessage() + "Databasen er nede.");
            System.out.println(ex);
        }
        return materialNames;
    }

    /**
     * Returns a list of products  from the database. Used to calculate prices.
     * @return a List<> containing all the products.
     * If connections is not established it catches an exception and logs it
     */
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
            Log.severe("GetProductList " + ex.getMessage() + "Databasen er nede.");
            System.out.println(ex);
        }
        return productsList;
    }

    /**
     * Returns a list of carport materials  from the database, used in the carportParts class
     * @return a List<> containing all the carport materials.
     * If connections is not established it catches an exception and logs it
     */
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
            Log.severe("CarportMaterialsList " + ex.getMessage() + "Databasen er nede.");
            System.out.println(ex);
        }
        return CarportMaterialNames;
    }

    /**
     * Adds order to the database using an SQL query.
     * @param user The user which order we want to add.
     *             The user needs to be in the database and have an ID since the UserID is foreign key.
     * @param carport The carport we want to add to the database.
     * If connections is not established it catches an exception and logs it
     */

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
            Log.severe("AddOrder " + ex.getMessage() + "Der kunne ikke oprettes en order i databasen(måske er den nede??)");
            System.out.println("FEJL! Kunne ikke finde oprette order med carporten");
        }
    }

    /**
     * Returns a list of orders  from the database
     * @return a List<> containing all the orders.
     * If connections is not established it catches an exception and logs it
     */

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
            Log.severe("getOrderList " + ex.getMessage() + "Databasen er nede.");
            System.out.println(ex);
        }
        return CarportItemList;
    }

    /**
     * Adds customerOrder to the database using an SQL query.
     * @param customerOrder The customerOrder which order we want to add.
     *                      The customerOrder contains all information regarding user, orderID etc.
     * In this database there are alot of foreign keys:
     *                      orderId
     *                      userId
     *                      roof_mats
     *                      cp_mats
     * These are used to ensure the program is working on existing orders, users and materials.
     * If connections is not established it catches an exception and logs it
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
                int cpLength = rs.getInt("cp_length");
                int cpWidth = rs.getInt("cp_width");
                int claddingSides = rs.getInt("cladding_sides");
                int roofAngle = rs.getInt("roof_angle");
                int price = rs.getInt("price");
                CustomerOrder co = new CustomerOrder(roofMatId, cpMatId, shedMatId, orderId, userId, cpLength, cpWidth, claddingSides, roofAngle, price);
                co.setCustomerOrderId(customerOrderId);
                customerOrderList.add(co);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return customerOrderList;
    }

    /**
     * method inserts an object of customerOrder into database table 'customer_order'
     * @param customerOrder is an object of the CustomerOrder class
     */

    public static void createCustomerDesign(CustomerOrder customerOrder) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO customer_order (order_id, user_id, cp_length, cp_width,hasShed, shedHalf, " +
                    "roof_mats, shed_mats, cp_mats, cladding_sides, roof_angle, price) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerOrder.getOrderId());
            ps.setInt(2, customerOrder.getUserId());
            ps.setDouble(3, customerOrder.getCp_height());
            ps.setDouble(4, customerOrder.getCp_width());
            ps.setBoolean(5, customerOrder.getHasShed());
            ps.setBoolean(6, customerOrder.getShedHalf());
            ps.setInt(7, customerOrder.getRoofMatId());
            ps.setInt(8, customerOrder.getShedMatId());
            ps.setInt(9, customerOrder.getCpMatId());
            ps.setInt(10, customerOrder.getCladdingSides());
            ps.setInt(11, customerOrder.getRoofAngle());
            ps.setDouble(12, customerOrder.getPrice());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Log.severe("createCustomerDesign " + ex.getMessage() + "Kunne ikke oprette design i DB eller databasen er nede.");
            System.out.println("There was a error creating the customerOrder in the database");
        }

    }

    /**
     * @param customerId GetCustomerDesign is used to get the saved user designs from the DB,
     *             we are using a user as parameter to get the logged in users id.
     * @return We're returning an object of a customer order
     *  If connections is not established it catches an exception and logs it
     */

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
                boolean hasShed = rs.getBoolean("hasShed");
                boolean shedHalf = rs.getBoolean("shedHalf");
                int claddingSides = rs.getInt("cladding_sides");
                int roofAngle = rs.getInt("roof_angle");
                double price = rs.getDouble("price");
                CustomerOrder co = new CustomerOrder(roofMatId, cpMatId, shedMatId, orderId, userId, cpLength, cpWidth, hasShed, shedHalf, claddingSides, roofAngle, price);
                co.setCustomerOrderId(customerOrderId);
                customerOrderList.add(co);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Log.severe("getCustomerDesignOrder " + ex.getMessage() + "Databasen er nede.");
            System.out.println(ex);
        }
        return customerOrderList;
    }

    /**
     * Used to get the orderID mathing the user ID from the databse
     * @param user, the user which we want to get the user id from.
     * @return the user from the input parameters id.
     * If connections is not established it catches an exception and logs it
     */

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
            Log.severe("getUserOrderId " + ex.getMessage() + "Databasen er nede.");
            System.out.println(ex);
            System.out.println("Kunne ikke finde orderID");
        }
        return orderid;
    }

    /**
    public static Order getCustomerOrder(int orderId) throws OrderException {
     * Returns the order with the orderId given as input parameter
     * @param orderId the id of the order we want to return
     * @return the order found from orderId
     * @throws OrderException, "homemade" exception thrown when the method cannot return the order.
     * If connections is not established it catches an exception and logs it
     */
    public static Order getOrder(int orderId) throws OrderException {

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
                Log.finest("getCustomerOrder " + "Kunne ikke finde order");
                throw new OrderException("Could not find order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Log.severe("getCustomerOrder " + "Databasen er nede.");
            throw new OrderException(ex.getMessage());
        }
    }

    /**
     * @param order_id is a variable containing the orderId of a specific order
     * the method removes/deletes an order in the database containing the given orderId
     * Method used to delete a customerOrder
     * @param order_id deletes the customerOrder with the given order_Id.
     * If connections is not established it catches an exception and logs it
     */
    public static void deleteCustomerOrder(int order_id) {
        try {
            String SQL = "DELETE FROM customer_order WHERE order_id = " + order_id;
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            ps.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Log.severe("deleteOrder " + "Kunne ikke fjerne order eller databasen er nede.");
            System.out.println("FEJL! Kunne ikke fjerne order");
        }
    }

    /**
     * Method used to delete an order
     * @param order_id deletes the order with the given order_Id.
     * If connections is not established it catches an exception and logs it
     */
    public static void deleteOrder(int order_id) {
        try {
            String SQL = "DELETE FROM orders WHERE order_id = " + order_id;
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.execute();
            ps.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Log.severe("deleteOrder " + "Kunne ikke fjerne order eller databasen er nede.");
            System.out.println("FEJL! Kunne ikke fjerne order");
        }
    }

    /**
    public static void updatePrice(int co_Id, int price) {
     * Updates price on a customerOrder
     * @param co_Id, the id of the customerOrder which we want to change the price.
     * @param price, the new price of customerOrder.
     * If connections is not established it catches an exception and logs it
     */
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
            Log.severe("deleteOrder " + "Kunne ikke opdatere pris eller databasen er nede.");
            System.out.println("FEJL! Kunne ikke opdatere pris");
        }
    }

    /**
     *
     * @param orderid the orderId we want to find mathing customerOrders for
     * @return the given CustomerOrder
     * @throws OrderException, "homemade" exception thrown when the method cannot return the order.
     * If connections is not established it catches an exception and logs it
     */
    public static CustomerOrder getCustomerOrder(int orderid) throws OrderException {
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM customer_order WHERE order_id = " + orderid;
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                int roofMatId = rs.getInt("roof_mats");
                int cpMatId = rs.getInt("cp_mats");
                int shedMatId = rs.getInt("shed_mats");
                int orderId = rs.getInt("order_id");
                int userId = rs.getInt("user_id");
                double cpLength = rs.getDouble("cp_length");
                double cpWidth = rs.getDouble("cp_width");
                boolean hasShed = rs.getBoolean("hasShed");
                boolean shedHalf = rs.getBoolean("shedHalf");
                int claddingSides = rs.getInt("cladding_sides");
                int roofAngle = rs.getInt("roof_angle");
                double price = rs.getDouble("price");
                CustomerOrder co = new CustomerOrder(roofMatId, cpMatId, shedMatId, orderId, userId, cpLength, cpWidth, hasShed, shedHalf, claddingSides, roofAngle, price);
                return co;
            } else {
                Log.finest("getCustomerSingleOrder " + "Kunne ikke finde order");
                throw new OrderException("Could not find customer order");
            }
        } catch (ClassNotFoundException | SQLException | OrderException ex) {
            Log.severe("getCustomerOrder " + "Databasen er nede.");
            throw new OrderException(ex.getMessage());
        }
    }
}

