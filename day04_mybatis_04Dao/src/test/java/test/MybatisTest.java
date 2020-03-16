package test;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
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

public class MybatisTest {
    private InputStream in;
    private IUserDao userDao;
    @Before
    public void init()throws Exception{
        in= Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        userDao=new UserDaoImpl(factory);
    }
    @After
    public void destroy()throws Exception{
        in.close();
    }
    @Test
    public void testFindAll(){
        List<User> users=userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user=new User();
        user.setUsername("dao impl user");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后"+user);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(30);
        user.setUsername("mybatis.update");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(30);
    }

    @Test
    public void testFindone() {
        User user=userDao.findById(28);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users=userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int count=userDao.findTotal();
        System.out.println(count);
    }

}
