package org.example;

import java.sql.*;

public class DatabaseManager {


    // Implement database connection and methods to store/retrieve movie information
    public static void main(String[] args) {
//       
        try {
            DatabaseManagerConnection dbManager = new DatabaseManagerConnection();
            Connection connection = dbManager.getConnection();
            //create statement to execute queries to database
            Statement statement = connection.createStatement();
            String query = "select * from mymovies";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String title = results.getString("title");
                String genre = results.getString("genre");
                int releaseYear = results.getInt("releaseYear");
                int ratings = results.getInt("ratings");
                String director = results.getString("director");
                System.out.println(String.format("Title: %s\ngenre: %s\nreleaseYear: %d\nratings: %d\ndirector: %s\n\n", title, genre, releaseYear, ratings, director));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

   
}
