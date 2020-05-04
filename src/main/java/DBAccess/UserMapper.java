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
            String SQL = "INSERT INTO fogcarport.customer (email, password) VALUES (?, ?)";
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
            String SQL = "SELECT customer_id, credit, role FROM fogcarport.customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "customer_id" );
                int credit = rs.getInt( "credit" );
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

    public static int getCustomerId(String email){
        int customerId = 0;

        try {
            Connection con = Connector.connection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM fogcarport.customer where email = '" + email + "';";
            ResultSet rs = stmt.executeQuery(SQL);

            customerId = 0;

            while (rs.next()) {
                customerId = rs.getInt("customer_id");
            }
            return customerId;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return customerId;
    }



    public static void deleteMember(String email) {
        try {
            String SQL = "DELETE FROM fogcarport.customer WHERE email = (?)";
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
            String SQL = "UPDATE fogcarport.customer SET password = (?) WHERE email = (?)";
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
            String SQL = "SELECT * FROM fogcarport.customer";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                User user = new User(email, password);
                user.setId(rs.getInt("customer_id"));
                user.setRole(rs.getString("role"));
                customerList.add(user);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return customerList;
    }

}