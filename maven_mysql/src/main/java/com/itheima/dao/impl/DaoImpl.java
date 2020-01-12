package com.itheima.dao.impl;

import com.itheima.dao.Dao;
import com.itheima.domain.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {
    public List<Items> findAll() throws Exception{
        List<Items> list = new ArrayList<Items>();
        Connection connection=null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///address","root" ,"960614" );
            pst = connection.prepareCall("select * from account");
            rs = pst.executeQuery();

            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setNAME(rs.getString("name"));
                list.add(items);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
