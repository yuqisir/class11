package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {
    //根据id查询账户信息
    Account findById(Integer id);
    public void transfer(Integer sid, Integer tid, float money);

    List<Account> findAll();
}
