package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import factory.BeanFactory;
import service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao=new AccountDaoImpl();
    private IAccountDao accountDao=(IAccountDao) BeanFactory.getBean("accountDao");
    public void setAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }

    public void saveAccount() {
        int i = 1;
        System.out.println(i);
        i++;
        System.out.println("保存了账户");
    }
}
