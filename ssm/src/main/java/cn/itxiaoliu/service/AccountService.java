package cn.itxiaoliu.service;

import cn.itxiaoliu.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public void saveAccount(Account account);
}
