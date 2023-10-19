package org.example;
import java.sql.*;


public class UserManager {
    private Connection connection;

    public UserManager(Connection connection) {
        this.connection = connection;
    }

    public UserManager() {

    }

    public boolean createAccount(User user) {
        try{String query = "INSERT INTO Users VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPreferences());
            statement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.out.println("account already exists!");
        }


        return false;
    }




    public boolean deleteAccount(User user) {
        try {
            String query = "DELETE FROM Users WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.out.println("failed to delete user!");
        }
        return false;
    }

    public boolean updateAccount(User user) {
        try {
            String query = "UPDATE Users SET password = ?, preferences= ? WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPreferences());
            statement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.out.println("failed to update user");
        }
        return false;
    }

}



  







