package pers.kim.jdbctext;

import oracle.jdbc.proxy.annotation.Pre;
import pers.kim.xmltodb.ReaderHandle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao{
    public int addPerson(Person per) {
        int i=0;
        Connection con=null;
        PreparedStatement pst=null;
        String sql="insert into person(id,name,age,sex) values(seqPerson.nextVal,?,?,?)";
        try {
            con=DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1,per.getName());
            pst.setInt(2, (int) per.getAge());
            pst.setString(3,per.getSex());
            i=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(con,pst,null);
        return i;
    }

    public List<Person> finAllPerson() {
        List<Person> perList=new ArrayList<Person>();
        String sql="select id,name,age,sex from person";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        Person p=null;
        try {
            con=DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()){
                p=new Person(0,"",0,"");
                p.setId(rs.getInt("id"));
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                p.setSex(rs.getString("sex"));
                perList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(con,pst,rs);
        return perList;
    }

    public int updatePerson(int id, Person per) {
        int i=0;
        Connection con=null;
        PreparedStatement pst=null;
        String sql="update person set id=?,name=?,age=?,sex=? where id=?";
        try {
            con=DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1,per.getId());
            pst.setString(2,per.getName());
            pst.setInt(3, (int) per.getAge());
            pst.setString(4,per.getSex());
            pst.setInt(5,id);
            i=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(con,pst,null);
        return i;
    }

    public int deletePerson(int id) {
        int i=0;
        Connection con=null;
        PreparedStatement pst=null;
        String sql="delete from person where id=?";
        try {
            con=DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            i=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(con,pst,null);
        return i;
    }

    public Person loadPerson(int id) {
        int i=0;
        Person per=null;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select id,name,age,sex from person where id=?";
        try {
            con=DBUtil.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while (rs.next()){
                per=new Person(0,"",0,"");
                per.setId(rs.getInt("id"));
                per.setSex(rs.getString("sex"));
                per.setAge(rs.getInt("age"));
                per.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(con,pst,rs);
        return per;
    }

    public int xmlToDB(String path) {
        List<Person> perList=new ArrayList<Person>();
        int i=0;
        try {
            long start=System.currentTimeMillis();
            perList=ReaderHandle.readerFile(path);
            for (Person pp:perList) {
                i=addPerson(pp);
                if(i<=0) break;
            }
            long end=System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
