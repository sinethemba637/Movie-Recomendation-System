import static org.junit.jupiter.api.Assertions.*;

import org.example.DatabaseManagerConnection;
import org.example.User;
import org.example.UserLogin;
import org.example.UserManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManagerTest {
    private UserManager userManager;
    private Connection mockConnection;
    private PreparedStatement mockStatement;


    @BeforeEach
    void setUp() {
        mockConnection = Mockito.mock(Connection.class);
        mockStatement = Mockito.mock(PreparedStatement.class);
        userManager = new UserManager(mockConnection);


    }

    @Test
    void testCreateAccount_SuccessfulInsert() throws SQLException {
        User testUser = new User("sinethembazulu637", "Sine1234", "action movie");
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        boolean result = userManager.createAccount(testUser);

        assertTrue(result);
        Mockito.verify(mockStatement).setString(1, "sinethembazulu637");
        Mockito.verify(mockStatement).setString(2, "Sine1234");
        Mockito.verify(mockStatement).setString(3, "action movie");
        Mockito.verify(mockStatement).executeUpdate();

    }

    @Test
    void testAccountCreationFails() throws SQLException {

        User existingUser = new User("sinethembazulu637", "Sine1234", "Action movie");
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Duplicate entry"));


        boolean result = userManager.createAccount(existingUser);
        assertFalse(result);
    }
    @Test
    void testDeleteAccount_Successful() throws SQLException {
        User testUser = new User("sinethembazulu637", "Sine1234", "action movie");
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        boolean result = userManager.deleteAccount(testUser);

        assertTrue(result);
        Mockito.verify(mockStatement).setString(1, "sinethembazulu637");
        Mockito.verify(mockStatement).executeUpdate();
    }

    @Test
    void testAccountDeletionFails() throws SQLException {

        User existingUser = new User("sinethembazulu637","Sine1234","action movie");
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Duplicate entry"));


        boolean result = userManager.deleteAccount(existingUser);
        assertFalse(result);
    }
    @Test
    void testUpdateAccount_Successful() throws SQLException {
        User testUser = new User("sinethembazulu637", "Sine4321", "romantic movie");
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        boolean result = userManager.updateAccount(testUser);

        assertTrue(result);
        Mockito.verify(mockStatement).setString(1, "sinethembazulu637");
        Mockito.verify(mockStatement).setString(2,"Sine4321");
        Mockito.verify(mockStatement).setString(3,"romantic movie");
        Mockito.verify(mockStatement).executeUpdate();
    }

    @Test
    void testAccountUpdateFails() throws SQLException {
        User existingUser = new User("sinethembazulu637","Sine1234","action movie");
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Update fails"));


        boolean result = userManager.updateAccount(existingUser);
        assertFalse(result);
    }


//    @Test
//    void testSuccessfulLogin() throws SQLException {
//        UserLogin testUser = new UserLogin("sinethembazulu637", "Sine1234");
//        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
//
//        boolean result = UserLogin.login(testUser);
//
//        assertTrue(result);
//        Mockito.verify(mockStatement).setString(1, "sinethembazulu637");
//        Mockito.verify(mockStatement).setString(2,"Sine4321");
//        Mockito.verify(mockStatement).executeUpdate();
//    }
//
//    @Test
//    void testLoginFails() throws SQLException {
//        UserLogin existingUser = new UserLogin("sinethembazulu637","Sine1234");
//        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenThrow(new SQLException("Update fails"));
//
//
//        boolean result = UserLogin.login(existingUser);
//        assertFalse(result);
//    }
}




