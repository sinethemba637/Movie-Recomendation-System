package org.example;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseManagerConnection dbManager = new DatabaseManagerConnection();
        dbManager.connect();
        User DeletedUser = new User("sinethembazulu637","Sine1234","action movie");
        User CreateUserAccount= new User("sinethembazulu637","Sine1234","action movie");
        User UpdateUserAccount = new User("sinethembazulu637","Sine4321","romance");
        UserLogin userAuthenticator = new UserLogin(dbManager.getConnection());
        UserManager usermanager = new UserManager(dbManager.getConnection());
        userAuthenticator.login("sinethembazulu637","Sine1234");
        usermanager.createAccount(CreateUserAccount);
        usermanager.updateAccount(UpdateUserAccount);
        usermanager.deleteAccount(DeletedUser);
        dbManager.closeConnection();



    }
}