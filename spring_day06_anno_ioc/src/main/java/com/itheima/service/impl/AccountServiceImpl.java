package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
