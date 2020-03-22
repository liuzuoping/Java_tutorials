import java.sql.*;

public class Demo1 {
    public static void main(String [] args) throws Exception {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn=DriverManager.getConnection("jdbc:mysql:///address", "xiaoliu", "960614abcd");
        PreparedStatement pstmt = conn.prepareStatement("select * from account");
        ResultSet rs=pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("NAME"));
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
