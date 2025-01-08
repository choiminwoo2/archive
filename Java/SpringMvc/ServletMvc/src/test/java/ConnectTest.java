import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.property.MariaDBProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectTest {



    @Test
    @DisplayName("커넥션 여부")
    public void connectionTest() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        MariaDBProperty props = new MariaDBProperty();
        Connection connection = DriverManager.getConnection(
                props.getUrl(),
                props.getUserName(),
                props.getPassword()
        );

        assertNotNull(connection);

        connection.close();
    }
}
