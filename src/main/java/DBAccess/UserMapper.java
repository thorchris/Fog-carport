package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogcarport.users (email, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
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
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int getUserId(String email){
        int userId = 0;

        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.users where email = '" + email + "';";
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



    public static void deleteMember(String email) {
        try {
            String SQL = "DELETE FROM fogcarport.users WHERE email = (?)";
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.execute();
            ps.close();


        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("FEJL! Kunne ikke fjerne medlem.");
        }
    }

    public static void changePassword(String password, String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE fogcarport.users SET password = (?) WHERE email = (?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getCustomerList() {
        List<User> customerList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.users";
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