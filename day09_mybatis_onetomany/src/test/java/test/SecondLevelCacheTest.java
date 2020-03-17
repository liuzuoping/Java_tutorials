package test;

import dao.IUserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.InputStream;

public class SecondLevelCacheTest {
    private SqlSessionFactory factory;
    private InputStream in;

    @Before
    public void init()throws Exception{
        in= Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);

    }
    @After
    public void destroy()throws Exception{
        in.close();
    }
    @Test
    public void testFindOne(){
        SqlSession session=factory.openSession();
        IUserDao userDao=session.getMapper(IUserDao.class);
        User user=userDao.findById(45);
        System.out.println(user);

        session.close();

        SqlSession session1=factory.openSession();
        IUserDao userDao1=session1.getMapper(IUserDao.class);
        User user1=userDao1.findById(45);
        System.out.println(user1);
    }
}
