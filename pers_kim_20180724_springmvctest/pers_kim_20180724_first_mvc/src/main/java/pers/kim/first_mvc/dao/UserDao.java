package pers.kim.first_mvc.dao;

import pers.kim.first_mvc.dbutil.DButil;
import pers.kim.first_mvc.pojo.UserPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create on 7/24/2018
 *
 * @Author Kim
 */
public class UserDao {
    public static UserPojo findUser(UserPojo userPojo){
        int i=0;
        UserPojo per=null;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select name from mvcuser where name=? and password=?";
        try {
            con=DButil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1,userPojo.getName());
            pst.setString(2,userPojo.getPassword());
            rs=pst.executeQuery();
            while (rs.next()){
                per=new UserPojo();
                per.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(con,pst,rs);
        }
        return per;
    }

    public static int insertUser(UserPojo userPojo){
        int i=0;
        Connection con=null;
        PreparedStatement pst=null;
        String sql="insert into mvcuser(name,password,password1,age) values(?,?,?,?)";
        try {
            con=DButil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1,userPojo.getName());
            pst.setString(2,  userPojo.getPassword());
            pst.setString(3, userPojo.getRpassword());
            pst.setInt(4,userPojo.getAge());
            i=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(con,pst,null);
        }
        return i;
    }
}
