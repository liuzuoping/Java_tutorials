package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.itheima.service.IAccountService;

public class Client {

    public static void main(String [] args){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=(IAccountService)ac.getBean("accountService");
        //IAccountService as2=(IAccountService)ac.getBean("accountService");
//        System.out.println(as);
//        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(adao);
        as.saveAccount();
        ((ClassPathXmlApplicationContext) ac).close();
       // System.out.println(as==as2);
    }
}
