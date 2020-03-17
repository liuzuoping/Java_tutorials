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
    public void TestSave(){
        User user=new User();
        user.setUsername("mybatis.annotation");
        user.setAddress("北京市昌平区");
        userDao.saveUser(user);
    }

    @Test
    public void TestUpdate(){
        User user=new User();
        user.setId(49);
        user.setUsername("mybatis.annotation.update");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void TestDelete(){
        userDao.deleteUser(42);
    }

    @Test
    public void TestFindById(){
        User user=userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void TestFindByName(){
        List<User> users=userDao.findUserByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void TestFindTotal(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }
}
