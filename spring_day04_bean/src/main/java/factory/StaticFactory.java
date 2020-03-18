package factory;

import service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountServiceImpl getAccountService(){

        return new AccountServiceImpl();
    }
}
