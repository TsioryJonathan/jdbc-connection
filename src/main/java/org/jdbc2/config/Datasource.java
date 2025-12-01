package org.jdbc2.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    private final String dbBaseUrl;
    private final String dbUsername;
    private final String dbPassword;
    public Datasource(){
        Dotenv dotenv = Dotenv.load();
        this.dbBaseUrl = dotenv.get("DB_BASE_URL");
        this.dbUsername = dotenv.get("DB_USERNAME");
        this.dbPassword = dotenv.get("DB_PASSWORD");
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbBaseUrl, dbUsername , dbPassword);
    }
}
