import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.zerock.servletmvc.property.MariaDBProperty;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPConfig {
    @Test
    void connect() throws SQLException {
        HikariConfig config = new HikariConfig();
        MariaDBProperty props = new MariaDBProperty();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl(props.getUrl());
        config.setUsername(props.getUserName());
        config.setPassword(props.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();

    }
}
