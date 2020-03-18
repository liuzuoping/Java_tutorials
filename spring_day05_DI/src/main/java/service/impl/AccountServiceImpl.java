package service.impl;


import service.IAccountService;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name=name;
        this.age=age;
        this.birthday=birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }

}
