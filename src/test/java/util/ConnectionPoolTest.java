package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/elysias");
        config.setUsername("root");
        config.setPassword("");

        // Konfigurasi Pool
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_00);
        config.setMaxLifetime(10 * 60_00);

        HikariDataSource dataSource = new HikariDataSource(config);
        Connection connection = dataSource.getConnection();
        connection.close();
        dataSource.close();
    }

    @Test
    void testUtil() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }

}