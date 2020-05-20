package DBAccess;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Class for testing the UserMapper.
 * @Author Josef, Hallur, Thor og Frederik
 */
public class UserMapperTest {


    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "green8house17";
    private static String DBNAME = "fogcarport_test?serverTimezone=CET&useSSL=false";
    private static String HOST = "localhost";

    /**
     * Run before the first test.
     */
    @BeforeClass
    public static void setUp() {
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


        } catch (ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    /**
     * Run pre everytest to assure it's the same database tables being tested.
     */
    @Before
    public void setUpDB(){
        try ( Statement stmt = testConnection.createStatement() ) {
            stmt.execute("DROP SCHEMA if exists fogcarport_test ");
            stmt.execute("CREATE SCHEMA fogcarport_test ");
            stmt.execute("use fogcarport_test; ");
            stmt.execute("DROP TABLE if EXISTS fogcarport_test.users");
            stmt.execute("CREATE TABLE fogcarport_test.users LIKE fogcarport.users");
            stmt.execute("INSERT INTO fogcarport_test.users VALUES (1,'admin@admin.com','admin','employee'),(2,'user@user.com','user','customer')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "admin@admin.com", "admin" );
        assertTrue( user != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        UserMapper.login( "test@test.dk", "forkert" );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // test is supposed to be a customer
        User user = UserMapper.login( "user@user.com", "user" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        User original = new User( "testperson", "test");
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "testperson", "test" );
        assertEquals( "customer", retrieved.getRole() );
    }

    /**
     * Gives a fake password for the connection so that it will throw an SQL exception
     * @throws SQLException exception is thrown when the connection is unestablished.
     */
    @Test(expected = SQLException.class)
    public void testGetUserIdSQLException() throws SQLException {
        String url = "fakeurl";
        USERPW = "fakePassword";
        testConnection = DriverManager.getConnection(url, USER, USERPW);
        LogicFacade.getUserId("user@user.com");
    }

    @Test
    public void testUserList(){
        List<User> userList = LogicFacade.getCustomerList();
        int expectedSize = 2;
        int actualSize = userList.size();
        assertEquals(expectedSize, actualSize);

    }


}