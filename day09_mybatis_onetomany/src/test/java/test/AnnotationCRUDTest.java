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
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    private InputStream in;

    @Before
    public void init()throws Exception{
        in= Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession();
        userDao=session.getMapper(IUserDao.class);
    }
    @After
    public void destroy()throws Exception{
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
//        for (User user : users) {
//            System.out.println("---");
//            System.out.println(user);
//            System.out.println(user.getAccounts());
//        }
    }

    @Test
    public void TestFindById(){
        User user=userDao.findById(45);
        System.out.println(user);

        User user2=userDao.findById(45);
        System.out.println(user2);

        System.out.println(user=user2);
    }

    @Test
    public void TestFindByName(){
        List<User> users=userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }


}
