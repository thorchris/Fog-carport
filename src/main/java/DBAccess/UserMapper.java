package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import PresentationLayer.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            if(ex.getMessage().contains("Duplicate Entry")){
                Log.finest("Create user " + user.getEmail() + "Duplicate Entry");
                throw new LoginSampleException("En bruger med det brugernavn findes allerede");
            }
            if(ex.getMessage().contains("link failure")){
                Log.severe("Registrer (DB er måske nede) " + ex.getMessage());
                throw new LoginSampleException("Databasen er nede. Kontakt admin.");
            }
            Log.severe("Create user " + ex.getMessage());
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT user_id, role FROM fogcarport.users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "user_id" );
                String role = rs.getString( "role" );
                User user = new User( email, password );
                user.setId( id );
                user.setRole(role);
                return user;
            } else {
                Log.info("Login " + "Could not validate user");
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            if(ex.getMessage().contains("link failure")){
                Log.severe("Login (DB er måske nede) " + ex.getMessage());
                throw new LoginSampleException("Databasen er nede. Kontakt admin.");
            }
            Log.severe("Login " + ex.getMessage());
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int getUserId(String email){
        int userId = 0;

        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM users where email = '" + email + "';";
            ResultSet rs = stmt.executeQuery(SQL);

            userId = 0;

            while (rs.next()) {
                userId = rs.getInt("user_id");
            }
            return userId;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return userId;
    }

    public static List<User> getCustomerList() {
        List<User> customerList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(email, password);
                user.setId(rs.getInt("user_id"));
                user.setRole(rs.getString("role"));
                customerList.add(user);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return customerList;
    }

}