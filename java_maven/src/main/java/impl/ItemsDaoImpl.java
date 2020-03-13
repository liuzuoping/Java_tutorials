package impl;

import dao.ItemsDao;
import domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl  implements ItemsDao {
    public List<Items> findAll() throws Exception {
        List<Items> list=new ArrayList<Items>();
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///address","xiaoliu","960614abcd");
            pst=conn.prepareCall("select * from account");
            rs = pst.executeQuery();
            while(rs.next()){
                Items items=new Items();
                items.getId(rs.getInt("id"));
                items.getNAME(rs.getString("NAME"));
                list.add(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
