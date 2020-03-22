package jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo2 {
    public static void main(String [] args){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        jt.execute("insert into account(name,money)values ('ddd',2222)");
//        DriverManagerDataSource ds=new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql:///address");
//        ds.setUsername("xiaoliu");
//        ds.setPassword("960614abcd");
//        JdbcTemplate jt=new JdbcTemplate();
//        jt.setDataSource(ds);
//        jt.execute("insert into account(name,money)values ('ccc',1000)");
    }
}
