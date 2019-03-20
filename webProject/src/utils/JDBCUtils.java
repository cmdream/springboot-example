package utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC(java Database Connectivity)
 */
public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;
    static{
        try {
            ResourceBundle resource = ResourceBundle.getBundle("jdbc");
            driver = resource.getString("driver");
            url = resource.getString("url");
            username = resource.getString("username");
            password = resource.getString("password");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet rs, PreparedStatement pre, Connection connection) {
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != pre){
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
