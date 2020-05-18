package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FunctionLayer.*;
import PresentationLayer.Log;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;


public class DataMapperTest {

    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "kode";
    private static String DBNAME = "fogcarport_test?serverTimezone=CET&useSSL=false";
    private static String HOST = "localhost";
    private FullCarport carport;
    private Shed shed;
    private ShedMaterials shedMaterials;
    private Roof roof;
    private RoofMaterials roofMaterials;
    private CarportParts carportParts;
    private CarportMaterials carportMaterials;

    @BeforeClass
    public static void setUpConnection() {
        try {
            // awoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                Connector.setConnection(testConnection);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Before
    public void setup() {
        carportMaterials = new CarportMaterials("Bøgetræsplade", 2, 12, 0.15, 3);
        carportParts = new CarportParts(510, 330, true, false, carportMaterials, 1);
        roofMaterials = new RoofMaterials("Betontagsten - rød", 2, 450, 1, 2);
        roof = new Roof(false, roofMaterials, 510, 330);
        shedMaterials = new ShedMaterials();
        shed = new Shed(510, 330, false, shedMaterials);
        carport = new FullCarport(carportParts, roof, shed);
    }

    @Before
    public void beforeEachTest() {
        // reset test database
        try (Statement stmt = testConnection.createStatement()) {
            stmt.execute("DROP SCHEMA if exists fogcarport_test ");
            stmt.execute("CREATE SCHEMA fogcarport_test ");
            stmt.execute("use fogcarport_test; ");

            stmt.execute("DROP TABLE if EXISTS fogcarport_test.carport_materials");
            stmt.execute("CREATE TABLE fogcarport_test.carport_materials LIKE fogcarport.carport_materials");
            stmt.execute("INSERT INTO fogcarport_test.carport_materials SELECT * FROM fogcarport.carport_materials");

            stmt.execute("DROP TABLE if EXISTS fogcarport_test.roof_materials");
            stmt.execute("CREATE TABLE fogcarport_test.roof_materials LIKE fogcarport.roof_materials");
            stmt.execute("INSERT INTO fogcarport_test.roof_materials SELECT * FROM fogcarport.roof_materials");

            stmt.execute("DROP TABLE if EXISTS fogcarport_test.products");
            stmt.execute("CREATE TABLE fogcarport_test.products LIKE fogcarport.products");
            stmt.execute("INSERT INTO fogcarport_test.products SELECT * FROM fogcarport.products");

            stmt.execute("DROP TABLE if EXISTS fogcarport_test.users");
            stmt.execute("CREATE TABLE fogcarport_test.users LIKE fogcarport.users");
            stmt.execute("INSERT INTO fogcarport_test.users VALUES (1,'admin@admin.com','admin','employee'),(2,'user@user.com','user','customer')");

            stmt.execute("DROP TABLE if EXISTS fogcarport_test.orders");
            stmt.execute("CREATE TABLE fogcarport_test.orders LIKE fogcarport.orders");
            stmt.execute("INSERT INTO fogcarport_test.orders VALUES ('1','1','2','1','4','300','2','4','4','1','2') ");
            stmt.execute("INSERT INTO fogcarport_test.orders VALUES ('2','2','3','2','4','300','2','4','4','1','2') ");
            stmt.execute("INSERT INTO fogcarport_test.orders VALUES ('3','1','3','2','4','300','2','4','4','1','2') ");

            stmt.execute("DROP TABLE if EXISTS fogcarport_test.customer_order");
            stmt.execute("CREATE TABLE fogcarport_test.customer_order LIKE fogcarport.customer_order");
            stmt.execute("INSERT INTO fogcarport_test.customer_order VALUES ('1', '2', '1', '240', '240', '1', '1', '1', '1', '1', '2', '25', '10000');");
            stmt.execute("INSERT INTO fogcarport_test.customer_order VALUES ('2', '1', '2', '240', '240', '1', '1', '1', '1', '1', '2', '25', '10000');");
            stmt.execute("INSERT INTO fogcarport_test.customer_order VALUES ('3', '2', '1', '240', '240', '1', '1', '1', '1', '1', '2', '25', '10000');");

        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }

    }


    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }


    @Test
    public void testGetCarportMaterialListSize() {
        List<CarportMaterials> carportMatListDB;
        carportMatListDB = DataMapper.getCarportMaterialsList();

        int result = carportMatListDB.size();
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    public void testGetCarportMaterialListSizeDoesNotMatch() {
        List<CarportMaterials> carportMatListDB;
        carportMatListDB = DataMapper.getCarportMaterialsList();

        int result = carportMatListDB.size();
        int expected = 1000;
        assertNotEquals(expected, result);
    }

    @Test
    public void testGetCarportMaterialList() {
        List<CarportMaterials> carportMatList = new ArrayList<>();

        CarportMaterials cm1 = new CarportMaterials("Egetræsbrædder", 1, 14, 0.15, 3);
        CarportMaterials cm2 = new CarportMaterials("Bøgetræsplade", 2, 12, 0.15, 3);
        CarportMaterials cm3 = new CarportMaterials("Plastiktræ", 3, 10, 0.15, 3);

        carportMatList.add(cm1);
        carportMatList.add(cm2);
        carportMatList.add(cm3);

        List<CarportMaterials> carportMatListDB;
        carportMatListDB = DataMapper.getCarportMaterialsList();

        String expected = carportMatList.toString();
        String result = carportMatListDB.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testAddOrder() throws LoginSampleException {
        User original = new User("person", "kode");
        UserMapper.createUser(original);

        List<Order> orderListDB = DataMapper.getOrderList();
        int tmp = orderListDB.size();

        DataMapper.addOrder(original, carport);

        List<Order> updatedOrderListDB = DataMapper.getOrderList();
        int actual = updatedOrderListDB.size();

        assertNotEquals(tmp, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testAddOrderException() {
        DataMapper.addOrder(null, carport);
    }

    @Test
    public void testDeleteOrder() throws LoginSampleException {
        User original = new User("person", "kode");
        UserMapper.createUser(original);
        DataMapper.addOrder(original, carport);
        List<Order> orderListDB = DataMapper.getOrderList();
        int tmp = orderListDB.size();
        int orderId = DataMapper.getUserOrderId(original);
        DataMapper.deleteOrder(orderId);
        List<Order> updatedOrderListDB = DataMapper.getOrderList();
        int actual = updatedOrderListDB.size();
        assertNotEquals(tmp, actual);
    }

    @Test(expected = OrderException.class)
    public void testGetOrderExpectedOrderException() throws OrderException {
        LogicFacade.getOrder(5);
    }

    /**
     *
     * @throws SQLException exception is thrown when the connection is unestablished.
     */
    @Test(expected = SQLException.class)
    public void testGetCustomerDesignSQLException() throws SQLException {
        String url = "fakeurl";
        USERPW = "fakePassword";
        testConnection = DriverManager.getConnection(url, USER, USERPW);
        LogicFacade.getCustomerDesignOrder(1);
    }

    @Test
    public void testGetCustomerDesign() {
        int customerId = 1;
        List<CustomerOrder> getCustomerDesignOrderList = LogicFacade.getCustomerDesignOrder(customerId);

        int expected = 2;
        int result = getCustomerDesignOrderList.size();

        assertEquals(expected, result);
    }

    @Test
    public void testCreateCustomerDesign() throws LoginSampleException {
        User user = new User("hafthor", "bjornsson");
        UserMapper.createUser(user);

        int userId = UserMapper.getUserId("hafthor");

        CustomerOrder co = new CustomerOrder(1, 1, 1, 7, userId, 510, 330, true, false, 2, 2, 2100);

        DataMapper.createCustomerDesign(co);

        List<CustomerOrder> CustomerOrderList;
        CustomerOrderList = DataMapper.getCustomerDesignOrder(userId);

        int expected = UserMapper.getUserId("hafthor");
        int result = CustomerOrderList.get(0).getUserId();

        assertEquals(expected, result);

    }

    @Test
    public void testGetUserOrderId() throws LoginSampleException {
        User original = new User("person", "kode");

        UserMapper.createUser(original);

        DataMapper.addOrder(original, carport);

        List<Order> sizeOfOrderList = DataMapper.getOrderList();

        int expected = sizeOfOrderList.size();
        int result = DataMapper.getUserOrderId(original);

        assertEquals(expected, result);
    }


    @Test
    public void testUpdatePrice() throws OrderException {
        CustomerOrder co = LogicFacade.getCustomerOrder(1);
        double resultFirstPrice = co.getPrice();
        double expectedFirstPrice = 10000;
        assertEquals(resultFirstPrice, expectedFirstPrice, 0.1);

        DataMapper.updatePrice(2, 2500);
        co = LogicFacade.getCustomerOrder(1);
        double resultUpdatedPrice = co.getPrice();
        double expectedUpdatedPrice = 2500;
        assertEquals(resultUpdatedPrice,expectedUpdatedPrice, 0.1);
    }

}