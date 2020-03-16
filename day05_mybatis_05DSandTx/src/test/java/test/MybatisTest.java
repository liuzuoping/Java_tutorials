package test;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
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
import java.util.ArrayList;
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
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        List<User> users=userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUsername("王五");
        //u.setSex("女");
        List<User> users=userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindInIds(){
        QueryVo vo=new QueryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(25);
        list.add(22);
        list.add(24);
        vo.setIds(list);
        List<User> users=userDao.findUserInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
