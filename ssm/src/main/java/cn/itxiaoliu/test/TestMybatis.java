package cn.itxiaoliu.test;

import cn.itxiaoliu.dao.AccountDao;
import cn.itxiaoliu.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void run1() throws Exception {
        InputStream in = Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        Account account=new Account();
        account.setName("熊大");
        account.setMoney(400d);
        InputStream in = Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        AccountDao dao = session.getMapper(AccountDao.class);
        dao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }
}
