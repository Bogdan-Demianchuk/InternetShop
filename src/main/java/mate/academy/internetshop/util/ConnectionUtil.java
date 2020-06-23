package mate.academy.internetshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String USER = "bc49dbe2ec8a70";
    private static final String PASSWORD = "4ad5dbc3";
    private static final String URL = "jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306/"
            + "heroku_17fce8ecbbe6750?serverTimezone=UTC";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find mySQL Driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Can't esteblish the connection to DB", e);
        }
    }
}
