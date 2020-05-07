package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FunctionLayer.CarportMaterials;
import FunctionLayer.FullCarport;
import FunctionLayer.Order;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import javax.xml.crypto.Data;

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
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test
                Connector.setConnection( testConnection );
            }
            // reset test database
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "DROP TABLE if EXISTS carport_materials" );
                stmt.execute( "CREATE TABLE carport_materials LIKE fogcarport.carport_materials" );
                stmt.execute( "INSERT INTO carport_materials SELECT * FROM fogcarport.carport_materials" );

                stmt.execute( "DROP TABLE if EXISTS orders" );
                stmt.execute( "CREATE TABLE orders LIKE fogcarport.order" );
                stmt.execute( "INSERT INTO orders SELECT * FROM fogcarport.order" );
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }



    }


     //1	Egetræsbrædder	14	0.15	3
     //2	Bøgetræsplade	12	0.15	3
     //3	Plastiktræ	10	0.15	3

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void testGetCarportMaterialListSize(){
        List<CarportMaterials> carportMatListDB;
        carportMatListDB = DataMapper.getCarportMaterialsList();

        int result = carportMatListDB.size();
        int expected = 3;
        assertEquals(expected, result);
    }

    @Test
    public void testGetCarportMaterialList(){
        List<CarportMaterials> carportMatList = new ArrayList<>();

        CarportMaterials cm1 = new CarportMaterials("Egetræsbrædder" , 1, 14,0.15,3);
        CarportMaterials cm2 = new CarportMaterials("Bøgetræsplade" , 2, 12,0.15,3);
        CarportMaterials cm3 = new CarportMaterials("Plastiktræ" , 3, 10,0.15,3);

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
    public void testAddOrder(){
        Order order = new Order(3, 4,2,4,5,6,7,8,9,1,2);
    }






}