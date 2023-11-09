import static org.junit.jupiter.api.Assertions.*;

import org.example.UserLogin;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class TestUserLogin {
    private UserLogin userLogin;
    private Connection mockConnection;
    private PreparedStatement mockStatement;

    @Test
    void testSuccessfulLogin() throws SQLException {
        UserLogin userAuthenticator = new UserLogin(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        boolean result = userAuthenticator.login("sinethembazulu637", "Sine1234");

        assertTrue(result);
        Mockito.verify(mockStatement).setString(1, "sinethembazulu637");
        Mockito.verify(mockStatement).setString(2, "Sine4321");
        Mockito.verify(mockStatement).executeUpdate();
    }

    @Test
    void testLoginFails() throws SQLException {
        UserLogin userAuthenticator = new UserLogin(mockConnection);

        // Create a different mockStatement for login failure test
        PreparedStatement mockStatementForFailure = Mockito.mock(PreparedStatement.class);

        // Configure the behavior of mockStatementForFailure to throw an exception
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatementForFailure);
        Mockito.when(mockStatementForFailure.execute()).thenThrow(new SQLException("Login failed"));

        boolean result = userAuthenticator.login("sinethembazulu637", "Sine1234");
        assertFalse(result);
    }
}
