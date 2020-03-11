package jdbc;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo10 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        boolean flag= new Demo10().login(username, password);
        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }
    public boolean login(String username,String password){
        if(username==null||password==null){
            return false;
        }
        PreparedStatement pstmt = null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            java.lang.String sql="select * from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs=pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }
}
