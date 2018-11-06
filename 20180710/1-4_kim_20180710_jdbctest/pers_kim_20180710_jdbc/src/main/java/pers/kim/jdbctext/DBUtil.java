package pers.kim.jdbctext;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Properties conf=new Properties();
    private static BasicDataSource dataSource=new BasicDataSource();
    private static String url;
    private static String username;
    private static String userWord;
    private static String joinClass;
    private static int initSize;
    private static int minidle;
    private static int maxActive;
    static {
        InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("dbconf");
        try {
            conf.load(in);
            url=conf.getProperty("url");
            username=conf.getProperty("username");
            userWord=conf.getProperty("userWord");
            joinClass=conf.getProperty("joinClass");
            initSize=Integer.parseInt(conf.getProperty("initSize"));
            minidle=Integer.parseInt(conf.getProperty("minidle"));
            maxActive=Integer.parseInt(conf.getProperty("maxActive"));
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(userWord);
            dataSource.setDriverClassName(joinClass);
            dataSource.setInitialSize(initSize);
            dataSource.setMinIdle(minidle);
            dataSource.setMaxActive(maxActive);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            con=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //    链接
    public static Connection getConnection2(){
        Connection connection= null;
        try {
            Class.forName(joinClass);
            connection = DriverManager.getConnection(url,username,userWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static  void close(Connection con, PreparedStatement pst, ResultSet rs){
        try {
            if(con!=null) con.close();
            if(pst!=null) pst.close();
            if(rs!=null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con=DBUtil.getConnection();
        System.out.println(con);
    }
}
