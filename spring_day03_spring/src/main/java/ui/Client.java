package ui;

import dao.IAccountDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import service.IAccountService;

public class Client {

    public static void main(String [] args){
        //ApplicationContext ac=new FileSystemXmlApplicationContext("C:\\Users\\MI\\Desktop\\bean.xml");
        //ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //IAccountService as=(IAccountService)ac.getBean("accountService");
        //IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
        //System.out.println(as);
        //System.out.println(adao);
        //as.saveAccount();
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory=new XmlBeanFactory(resource);
        IAccountService as=(IAccountService)factory.getBean("accountService");
        System.out.println(as);
    }
}
