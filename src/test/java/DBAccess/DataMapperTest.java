package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FunctionLayer.*;
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
                public void beforeEachTest(){

            // reset test database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("DROP TABLE if EXISTS carport_materials");
                stmt.execute("CREATE TABLE carport_materials LIKE fogcarport.carport_materials");
                stmt.execute("INSERT INTO carport_materials SELECT * FROM fogcarport.carport_materials");

                stmt.execute("DROP TABLE if EXISTS roof_materials");
                stmt.execute("CREATE TABLE roof_materials LIKE fogcarport.roof_materials");
                stmt.execute("INSERT INTO roof_materials SELECT * FROM fogcarport.roof_materials");

                stmt.execute("DROP TABLE if EXISTS products");
                stmt.execute("CREATE TABLE products LIKE fogcarport.products");
                stmt.execute("INSERT INTO products SELECT * FROM fogcarport.products");

                stmt.execute("DROP TABLE if EXISTS orders");
                stmt.execute("CREATE TABLE orders LIKE fogcarport.orders");
                stmt.execute("INSERT INTO orders SELECT * FROM fogcarport.orders");

                stmt.execute( "DROP TABLE if EXISTS users" );
                stmt.execute( "CREATE TABLE users LIKE fogcarport.users" );
                stmt.execute( "INSERT INTO users SELECT * FROM fogcarport.users" );

                stmt.execute("DROP TABLE if EXISTS customer_order");
                stmt.execute("CREATE TABLE customer_order LIKE fogcarport.customer_order");
                stmt.execute("INSERT INTO customer_order SELECT * FROM fogcarport.customer_order");

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
    public void testAddOrder()throws LoginSampleException {


        //Skaber alt data til at lave en fuld carport
        CarportMaterials carportMaterials = new CarportMaterials("Bøgetræsplade", 2, 12, 0.15, 3);
        CarportParts carportParts = new CarportParts(510, 330, true, false, carportMaterials, 1);

        RoofMaterials roofmaterials = new RoofMaterials("Betontagsten - rød", 2, 450, 1, 2);
        Roof roof = new Roof(false, roofmaterials, 510, 330);

        ShedMaterials shedMaterials = new ShedMaterials();
        Shed shed = new Shed(510, 330, false, shedMaterials);

        //instantierer en ny carport med alt dataet ovenfor
        FullCarport carport = new FullCarport(carportParts, roof, shed);
        User original = new User( "person", "kode");
        UserMapper.createUser( original );

        List<Order> orderListDB = DataMapper.getOrderList();
        int tmp = orderListDB.size();

        DataMapper.addOrder(original, carport);

        List<Order> updatedOrderListDB = DataMapper.getOrderList();
        int actual = updatedOrderListDB.size();

        assertNotEquals(tmp,actual);


    }

    @Test(expected = NullPointerException.class)
    public void testAddOrderException()throws LoginSampleException {


        //Skaber alt data til at lave en fuld carport
        CarportMaterials carportMaterials = new CarportMaterials("Bøgetræsplade", 2, 12, 0.15, 3);
        CarportParts carportParts = new CarportParts(510, 330, true, false, carportMaterials, 1);

        RoofMaterials roofmaterials = new RoofMaterials("Betontagsten - rød", 2, 450, 1, 2);
        Roof roof = new Roof(false, roofmaterials, 510, 330);

        ShedMaterials shedMaterials = new ShedMaterials();
        Shed shed = new Shed(510, 330, false, shedMaterials);

        //instantierer en ny carport med alt dataet ovenfor
        FullCarport carport = new FullCarport(carportParts, roof, shed);
        User original = new User( "hej", "kode");

        DataMapper.addOrder(null, carport);

    }

    @Test
    public void testDeleteOrder() throws LoginSampleException {

        //Skaber alt data til at lave en fuld carport
        CarportMaterials carportMaterials = new CarportMaterials("Bøgetræsplade", 2, 12, 0.15, 3);
        CarportParts carportParts = new CarportParts(510, 330, true, false, carportMaterials, 1);

        RoofMaterials roofmaterials = new RoofMaterials("Betontagsten - rød", 2, 450, 1, 2);
        Roof roof = new Roof(false, roofmaterials, 510, 330);

        ShedMaterials shedMaterials = new ShedMaterials();
        Shed shed = new Shed(510, 330, false, shedMaterials);

        //instantierer en ny carport med alt dataet ovenfor
        FullCarport carport = new FullCarport(carportParts, roof, shed);
        User original = new User( "person", "kode");
        UserMapper.createUser( original );

        //tilføjer en ordre til databasen
        DataMapper.addOrder(original, carport);

        //checker størrelsen af listen af ordrer på databasen, og sætter tallet ind i en variabel
        List<Order> orderListDB = DataMapper.getOrderList();
        int tmp = orderListDB.size();

        //sletter ordre fra databasen
        int orderId = DataMapper.getUserOrderId(original);
        DataMapper.deleteOrder(orderId);

        //checker igen størrelsen af listen af ordrer, og sætter det ind i en variabel
        List<Order> updatedOrderListDB = DataMapper.getOrderList();
        int actual = updatedOrderListDB.size();

        //checker om der er forskel på før deleteorder blev kaldt og efter
        assertNotEquals(tmp,actual);

    }

    @Test
    public void testGetCustomerDesign(){
        //User user = new User("hafthor", "bjornsson");
        //CustomerOrder co = new CustomerOrder(1,1,1,7,3,510,330,1,10, 2000);
    }

    @Test
    public void testCreateCustomerDesign() throws LoginSampleException {

        User user = new User("hafthor", "bjornsson");
        UserMapper.createUser(user);

        int userId = UserMapper.getUserId("hafthor");

        CustomerOrder co = new CustomerOrder(1,1,1,7,userId,510,330,1,10, 2100);

        DataMapper.createCustomerDesign(co);

        List<CustomerOrder> CustomerOrderList;
        CustomerOrderList = DataMapper.getCustomerDesignOrder(userId);

        int expected = UserMapper.getUserId("hafthor");
        int result = CustomerOrderList.get(0).getUserId();

        assertEquals(expected,result);

    }

    @Test
    public void testGetUserOrderId() throws LoginSampleException {

        //Skaber alt data til at lave en fuld carport
        CarportMaterials carportMaterials = new CarportMaterials("Bøgetræsplade", 2, 12, 0.15, 3);
        CarportParts carportParts = new CarportParts(510, 330, true, false, carportMaterials, 1);

        RoofMaterials roofmaterials = new RoofMaterials("Betontagsten - rød", 2, 450, 1, 2);
        Roof roof = new Roof(false, roofmaterials, 510, 330);

        ShedMaterials shedMaterials = new ShedMaterials();
        Shed shed = new Shed(510, 330, false, shedMaterials);

        FullCarport carport = new FullCarport(carportParts, roof, shed);
        User original = new User( "person", "kode");

        UserMapper.createUser( original );

        DataMapper.addOrder(original, carport);

        List<Order> sizeOfOrderList = DataMapper.getOrderList();


        int expected = sizeOfOrderList.size();
        int result = DataMapper.getUserOrderId(original);

        assertEquals(expected,result);


    }



   /* @Test
    public void testUpdatePrice() throws LoginSampleException {

        CustomerOrder co = new CustomerOrder(1,1,1,7,1,510,330,1,10, 2100);

        DataMapper.createCustomerDesign(co);
        co.setCustomerOrderId(1);

        DataMapper.updatePrice(1, 2500);


        assertEquals(2500,co.getPrice());

    }*/

}