package test;

import dao.IAccountDao;
import dao.IUserDao;
import domain.Account;
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

public class AccountTest {
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;
    private InputStream in;

    @Before
    public void init()throws Exception{
        in= Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        factory=new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession();
        accountDao=session.getMapper(IAccountDao.class);
    }
    @After
    public void destroy()throws Exception{
        session.commit();
        session.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        List<Account> accounts=accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("---");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
