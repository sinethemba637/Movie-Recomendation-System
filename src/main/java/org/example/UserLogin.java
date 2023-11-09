package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserLogin {
    private Connection connection;

    public UserLogin(Connection connection) {
        this.connection = connection;
    }

    public boolean login(String username, String password) {

        String query = "SELECT username, password FROM Users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            System.out.println("User logged in successfully!");
        }
        return false;
    }

}


