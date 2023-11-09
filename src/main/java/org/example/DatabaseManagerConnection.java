package org.example;

import java.sql.*;

public class DatabaseManagerConnection {
    private static final String DB_URL = "jdbc:sqlite:users.db";
    private Connection connection;

    public DatabaseManagerConnection(Connection mockConnection) {
    }

    public DatabaseManagerConnection() {

    }


    public void createTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS Users (\n" +
                    " username PRIMARY KEY NOT NULL,\n"+
                    " password TEXT NOT NULL,\n"+
                    " preferences TEXT NOT NULL\n"+
                    ");";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            createTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}