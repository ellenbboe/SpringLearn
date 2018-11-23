package com.sy4.JDBC;

import java.sql.*;

public class JdbcUtils {
    private static Connection conn = null;

    public static Connection getConn() {
        PropertiesUtil.loadFile("jdbc.properties");
        String driver = PropertiesUtil.getPropertyValue("jdbc.driver");
        String url = PropertiesUtil.getPropertyValue("jdbc.url");
        String username=PropertiesUtil.getPropertyValue("jdbc.username");
        String password = PropertiesUtil.getPropertyValue("jdbc.password");


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
        return conn;
    }


    public static void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}