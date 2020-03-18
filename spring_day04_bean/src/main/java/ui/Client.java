package ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.IAccountService;

public class Client {

    public static void main(String [] args){
        //ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=(IAccountService)ac.getBean("accountService");

        as.saveAccount();
        ac.close();

    }
}
