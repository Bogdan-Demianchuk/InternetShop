package mate.academy.internetshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find mySQL Driver", e);
        }
    }

    public static Connection getConnection() {
        Properties dbProperties = new Properties();
        dbProperties.put("user", "root");
        dbProperties.put("password", "864@mhx~H^LN");
        String url = "jdbc:mysql://localhost:3306/internet_shop";
        try {
            return DriverManager.getConnection(url, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't esteblish the connection to DB", e);
        }
    }
}
