package com.sy4.Dao;

import com.sy4.JDBC.JdbcUtils;
import com.sy4.entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class UserDao {
    public static String gettime(){
        java.util.Date now = new java.util.Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
        String hehe = dateFormat.format(now);
        return hehe;
    }

    //创建用户
    public static boolean createUser(String username,String realname,String password,String tel,String email){
        String sql ="insert into tuser (login_name, real_name, password, tel, email, `type`, last_login_time) values ( "+
                "'"+username+"'"+
                ","+"'"+realname +"'"+
                ","+"'"+password+"'"+
                ","+"'"+tel+"'"+
                ","+"'"+email+"'"+
                ","+1+","+"'"+gettime()+"'"+
                ");";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        Boolean ret = false;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e1) {
            ret=true;
        }
        return ret;
    }
    //更新用户登录时间
    public static void updatelogintime(Integer id){
        String sql = "update tuser set last_login_time="+"'"+gettime()+"' where id = "+id+";";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    //数据库验证登录信息
    public static User findUser(String username,String password,Integer type){
        String sql = "select * from tuser  where login_name = '"+username+"' and " +
                "password = '"+password+"' and `type`="+type+";";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret =null;
        User user = new User();
        try {
            stmt = conn.createStatement();
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                user.setId(ret.getInt(1));
                user.setRealName(ret.getString(3));
                user.setType(ret.getInt(7));
            }stmt.close();
            conn.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return user;
    }

    public static Map<Integer,String> getuserlist(){
        String sql = "select id,real_name from tuser;";
        Map<Integer,String> userlist = new LinkedHashMap<>();
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        try {
            stmt = conn.createStatement();
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                userlist.put(ret.getInt(1),ret.getString(2));
            }
            ret.close();
            stmt.close();
            conn.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return userlist;
    }
    public static String findrealnamebyid(Integer id)
    {
        String sql = "select real_name from tuser where id = "+id+";";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        String realname = null;
        try {
            stmt = conn.createStatement();
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                realname = ret.getString(1);
            }
            ret.close();
            stmt.close();
            conn.close();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return realname;
    }
}
