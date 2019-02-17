package com.demo;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SmTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void transfer(){
        accountService.transfer(1,2,50);
    }
    @Test
    public void find(){
        Account account = accountService.findById(1);
        System.out.println(account.getName());
    }
}
