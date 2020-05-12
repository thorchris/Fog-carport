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

import javax.xml.crypto.Data;

public class DataMapperTest {


    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "H7114bhs";
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
            } catch (SQLException ex) {
                System.out.println("Could not open connection to database: " + ex.getMessage());
            }

        }


    //1	Egetræsbrædder	14	0.15	3
    //2	Bøgetræsplade	12	0.15	3
    //3	Plastiktræ	10	0.15	3

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

        DataMapper.addOrder(original, carport);



    }
}