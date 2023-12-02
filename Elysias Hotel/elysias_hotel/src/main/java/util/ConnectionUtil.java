package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {

    private static HikariDataSource dataSource;

    static{
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/elysias");
        config.setUsername("root");
        config.setPassword("");

        // Konfigurasi Poll
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_00);
        config.setMaxLifetime(10 * 60_00);

        dataSource = new HikariDataSource(config);
    }

    public static  HikariDataSource getDataSource(){
        return dataSource;
    }

}
