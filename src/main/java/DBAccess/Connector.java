package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper -> Original
 @Author Josef, Hallur, Thor og Frederik -> edited
 */
public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        setDBCCredentialts();
        if (singleton == null || singleton.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

    public static void setDBCCredentialts() {
        String deplyoed = System.getenv("DEPLOYED");

        if (deplyoed != null) {
            //SERVER
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {
            //LOCALHOST
            URL = "jdbc:mysql://localhost:3306/fogcarport?serverTimezone=CET&useSSL=false";
            USERNAME = "root";
            PASSWORD = "green8house17";


        }
    }
}

