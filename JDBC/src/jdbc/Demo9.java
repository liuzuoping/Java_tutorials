package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo9 {
    public static void main(String [] args){
        Connection conn=null;
        PreparedStatement pstmt=null;
        PreparedStatement pstmt1=null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql="update account set balance=balance-? where id=?";
            String sql1="update account set balance=balance+? where id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt1=conn.prepareStatement(sql1);
            pstmt.setDouble(1, 500);
            pstmt.setInt(2, 1);
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 4);
            pstmt.executeUpdate();
            int i=3/0;
            pstmt1.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if(conn!=null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt, conn);
            JDBCUtils.close(pstmt1, null);
        }
    }
}
