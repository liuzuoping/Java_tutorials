package test;

import dao.IUserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    public static void main(String [] args)throws Exception{
        InputStream in= Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        IUserDao userDao=session.getMapper(IUserDao.class);
        List<User> users=userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
