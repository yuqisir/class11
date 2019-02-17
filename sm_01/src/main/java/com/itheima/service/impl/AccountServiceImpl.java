package com.itheima.service.impl;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;


    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    public void transfer(Integer sid, Integer tid, float money) {
        Account saccount=accountMapper.findById(sid);
        Account taccount=accountMapper.findById(tid);

        saccount.setMoney(saccount.getMoney()-money);
        taccount.setMoney(taccount.getMoney()+money);

        accountMapper.updateAccount(saccount);
        int i=1/0;
        accountMapper.updateAccount(taccount);
    }
}
