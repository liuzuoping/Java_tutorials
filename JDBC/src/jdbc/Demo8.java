package jdbc;

import main.Emp;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 */
public class Demo8 {

    public static void main(String[] args) {
        List<Emp> list = new Demo8().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Emp> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            //1.注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2.获取连接
//            conn = DriverManager.getConnection("jdbc:mysql:///address", "root", "960614abcd");
            conn = JDBCUtils.getConnection();
            String sql = "select * from user";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Emp emp=null;
            list = new ArrayList<Emp>();
            while (rs.next()) {
                //获取数据
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                // 创建emp对象,并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setUsername(username);
                emp.setPassword(password);
                //装载集合
                list.add(emp);
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return list;
    }
}
