package com.itheima.mapper;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountMapper {
    //根据id查询账户信息
    Account findById(Integer id);
    //更新账户信息
    void updateAccount(Account account);

    List<Account> findAll();
}
