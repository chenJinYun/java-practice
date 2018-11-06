package pers.kim.first_mvc.dbutil;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
public class DButil {
    private static Properties conf = new Properties();
    private static BasicDataSource dataSource = new BasicDataSource();
    private static String url;
    private static String username;
    private static String password;
    private static String driverClass;
    private static int initsize;
    private static int minidle;
    private static int maxactive;

    static {
        InputStream in = DButil.class.getClassLoader().getResourceAsStream("dbconf.properties");
        try {
            conf.load(in);
            url = conf.getProperty("url");
            username = conf.getProperty("username");
            password = conf.getProperty("password");
            driverClass = conf.getProperty("driverClass");
            initsize = Integer.parseInt(conf.getProperty("initsize"));
            minidle = Integer.parseInt(conf.getProperty("minidle"));
            maxactive = Integer.parseInt(conf.getProperty("maxactive"));
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driverClass);
            dataSource.setInitialSize(initsize);
            dataSource.setMinIdle(minidle);
            dataSource.setMaxActive(maxactive);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //    链接
    public static Connection getConnection2() {
        Connection connection = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            } ;
            if (pst != null) {
                pst.close();
            } ;
            if (rs != null) {
                rs.close();
            } ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con = DButil.getConnection();
        System.out.println(con);
    }

}
