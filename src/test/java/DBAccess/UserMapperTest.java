package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {


    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "H7114bhs";
    private static String DBNAME = "fogcarport_test?serverTimezone=CET&useSSL=false";
    private static String HOST = "localhost";

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
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "DROP TABLE if EXISTS users" );
                stmt.execute( "CREATE TABLE users LIKE fogcarport.users" );
                stmt.execute( "INSERT INTO users SELECT * FROM fogcarport.users" );
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
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
        User user = UserMapper.login( "test@test.dk", "kode" );
        assertTrue( user != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        UserMapper.login( "test@test.dk", "forkert" );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // test is supposed to be a customer
        User user = UserMapper.login( "test@test.dk", "kode" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "test", "test");
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "test", "test" );
        assertEquals( "customer", retrieved.getRole() );
    }
}