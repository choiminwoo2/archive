package org.zerock.servletmvc.todo.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.zerock.servletmvc.property.MariaDBProperty;

import java.sql.Connection;
import java.sql.SQLException;

public enum ConnectionUtil {
    INSTANCE;

    private final HikariDataSource ds;

    ConnectionUtil(){
        HikariConfig config = new HikariConfig();
        MariaDBProperty props = new MariaDBProperty();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl(props.getUrl());
        config.setUsername(props.getUserName());
        config.setPassword(props.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}
