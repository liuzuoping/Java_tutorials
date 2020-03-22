package dao;

import domain.Account;

public interface IAccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByname(String accountName);
    void updateAccount(Account account);
}
