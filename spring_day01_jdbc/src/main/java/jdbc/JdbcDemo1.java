package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String [] args)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn=DriverManager.getConnection("jdbc:mysql:///address","xiaoliu" , "960614abcd");
        PreparedStatement pstmt=conn.prepareStatement("select * from account");
        ResultSet rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
