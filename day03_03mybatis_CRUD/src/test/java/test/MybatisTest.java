package test;

import dao.IUserDao;
import domain.QueryVo;
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
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before
    public void init()throws Exception{
        in= Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        sqlSession=factory.openSession();
        userDao=sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destroy()throws Exception{
        sqlSession.commit();
        sqlSession.close();
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
        user.setUsername("mybatis last insertid");
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
        user.setId(10);
        user.setUsername("mybatis.update");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(10);
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

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        List<User> users=userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
