package test.test;
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
import java.util.List;

public class UserTest {
    private InputStream in;
    private IUserDao userDao;
    private SqlSession sqlSession;

    @Before
    public void init() throws Exception {
        in = Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testFindAll() throws Exception{
        List<User> users=userDao.findAll();
        for (User user : users) {
            System.out.println("------每个用户的信息--------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }


}
