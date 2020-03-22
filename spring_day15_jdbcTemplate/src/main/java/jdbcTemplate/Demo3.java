package jdbcTemplate;

import domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Demo3 {
    public static void main(String [] args){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
       // jt.execute("insert into account(name,money)values ('ddd',2222)");
        //jt.update("insert into account(name,money) values (?,?)","eee",333f);
        //jt.update("update account set money=?,name=? where id=?", 4567,"test",6);
        //jt.update("delete from account where id=?", 6);
        //List<Account> accounts=jt.query("select * from account where money>?", new AccountRowMapper(),1000f);
//        List<Account> accounts=jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class),1000f);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //List<Account> accounts=jt.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class),1);
        //System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));

        Long count=jt.queryForObject("select count(*) from account where money>?", Long.class,1000f);
        System.out.println(count);
    }
}
//class AccountRowMapper implements RowMapper<Account>{
//    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Account account=new Account();
//        account.setId(rs.getInt("id"));
//        account.setName(rs.getString("name"));
//        account.setMoney(rs.getFloat("money"));
//        return account;
//    }
//}
