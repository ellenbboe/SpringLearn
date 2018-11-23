package com.sy4.Dao;

import com.sy4.JDBC.JdbcUtils;
import com.sy4.entity.Equipment;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EquipmentDao {


    public static String timeformat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Sdate = sdf.format(date);
        return Sdate;
    }

    //添加
    public static boolean addequipment(String name, String description, String code,float price,String place,Integer userid){
        String sql ="insert into tequipment (name, description, code, add_time, price, place, user_id) values ( "+
                "'"+name+"'"+
                ","+"'"+description+"'"+
                ","+"'"+code +"'"+
                ","+"'"+UserDao.gettime()+"'"+
                ","+"'"+price+"'"+
                ","+"'"+place+"'"+
                ","+userid+
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
            e1.printStackTrace();
            ret = true;
        }
        return ret;
    }
    //删除
    public static boolean delequipment(){
//        String sql = "";
        return false;
    }
    //查看(该用户)
    public static List<Equipment> listEquipmentByid(Integer id){
        String sql = "select * from tequipment where user_id = "+id+" order by id asc;";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        List<Equipment> list =new ArrayList<Equipment>();
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集  
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                Equipment one = new Equipment();
                one.setAddTime(timeformat(new Date(ret.getTimestamp(5,Calendar.getInstance(TimeZone.getTimeZone("GMT+8"))).getTime())));
                one.setCode(ret.getString(4));
                one.setDescription(ret.getString(3));
                one.setId(ret.getInt(1));
                one.setName(ret.getString(2));
                one.setPlace(ret.getString(7));
                one.setPrice(ret.getFloat(6));
                one.setUserId(ret.getInt(8));
                list.add(one);
            }
            ret.close();
            stmt.close();
            conn.close();//关闭连接  

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }
    //查看全部用户
    public static Map<Equipment,String> listAllequipment(){
        String sql = "select * from tequipment order by id ASC;";
        Connection conn = JdbcUtils.getConn();
        Statement stmt = null;
        ResultSet ret = null;
        Map<Equipment,String> list =new LinkedHashMap<>();
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集  
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                Equipment one = new Equipment();
                one.setAddTime(timeformat(new Date(ret.getTimestamp(5,Calendar.getInstance(TimeZone.getTimeZone("GMT+8"))).getTime())));
                one.setCode(ret.getString(4));
                one.setDescription(ret.getString(3));
                one.setId(ret.getInt(1));
                String realName = UserDao.findrealnamebyid(ret.getInt(8));
                one.setName(ret.getString(2));
                one.setPlace(ret.getString(7));
                one.setPrice(ret.getFloat(6));
                one.setUserId(ret.getInt(8));
                list.put(one,realName);
            }
            ret.close();
            stmt.close();
            conn.close();//关闭连接  
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }
}
