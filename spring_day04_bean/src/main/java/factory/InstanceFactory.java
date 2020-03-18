package factory;

import service.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountServiceImpl getAccountService(){
        return new AccountServiceImpl();
    }
}
